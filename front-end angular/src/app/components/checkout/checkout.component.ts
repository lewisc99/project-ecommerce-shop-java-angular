import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormGroupName, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Country } from 'src/app/models/country';
import { Order } from 'src/app/models/order';
import { OrderItem } from 'src/app/models/order-item';
import { Purchase } from 'src/app/models/purchase';
import { State } from 'src/app/models/state';
import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';
import { LewisShopFormService } from 'src/app/services/lewis-shop-form.service';
import { LewisShopValidators } from 'src/app/Validators/lewis-shop-validators';

@Component({
  selector: 'app-checkout',
  host:{
    class:'Project-checkout'
  },
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {


  checkOutFormGroup:FormGroup;
  totalPrice:number = 0;
  totalQuantity:number = 0;
  creditCardYears:number[] = [];
  creditCardMonths:number[] = [];
  startMonth:number;


  countries:Country[] = [];
  shippingAddressStates:State[] = [];



  constructor(private formBuilder:FormBuilder,
     private lewisShopFormService: LewisShopFormService,
      private cartService:CartService,
      private checkoutService:CheckoutService,
      private router: Router) { }

  ngOnInit(): void {

    this.checkOutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: new FormControl("",[Validators.required,Validators.minLength(2), LewisShopValidators.notOnlyWhiteSpace, LewisShopValidators.maxLengthOfWord]),
        lastName: new FormControl("",[Validators.required,Validators.minLength(2), LewisShopValidators.notOnlyWhiteSpace]),
        email: new FormControl("",
        [Validators.required, Validators.pattern
        ("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
      ])
      }),
      shippingAddress: this.formBuilder.group({
        street: new FormControl("",[Validators.required, Validators.minLength(2), LewisShopValidators.notOnlyWhiteSpace]),
        city: new FormControl("",[Validators.required, Validators.minLength(2), LewisShopValidators.notOnlyWhiteSpace]),
        state:new FormControl("",[Validators.required]),
        country:new FormControl("",[Validators.required]),
        zipCode:new FormControl("",[Validators.required, LewisShopValidators.notOnlyWhiteSpace]),
      }),
      creditCard: this.formBuilder.group({
        cardType: new FormControl("", [Validators.required]),
        nameOnCard: new FormControl("", [Validators.required, Validators.minLength(2), LewisShopValidators.notOnlyWhiteSpace]),
        cardNumber:  new FormControl("", [Validators.required, Validators.pattern("[0-9]{16}")]),
        securityCode:   new FormControl("", [Validators.required, Validators.pattern("[0-9]{3}")]),
        expirationMonth:  new FormControl("", [Validators.required]),
        expirationYear:  new FormControl("", [Validators.required])
      })
    })

    this.startMonth = new Date().getMonth() + 1;
    console.log("StartMonth " + this.startMonth);

    this.lewisShopFormService.getCreditCardMonth(this.startMonth).subscribe(
      data => {
        console.log("Retrieved credit card months: " + JSON.stringify(data))
        this.creditCardMonths = data;
      }
    )


    this.lewisShopFormService.getCreditCardYears().subscribe(
      data => {
        console.log("Retrieved credit card years: " + JSON.stringify(data));
        this.creditCardYears = data;
      }
    )

    this.lewisShopFormService.getCountries().subscribe(
      data =>
      {
        console.log("Retrieved countries: " + JSON.stringify(data));
        this.countries = data;
      }
    )

    this.reviewCartDetails();

  }

  reviewCartDetails()
  {

    this.cartService.quantityTotal.subscribe(
      totalQuantity => this.totalQuantity = totalQuantity
    )

    this.cartService.priceTotal.subscribe(
      totalPrice => this.totalPrice = totalPrice
    )

  }


  get firstName() {return this.checkOutFormGroup.get("customer.firstName")}
  get lastName() {return this.checkOutFormGroup.get("customer.lastName")}
  get email() {return this.checkOutFormGroup.get("customer.email")}
  
  get shippingStreet() {return this.checkOutFormGroup.get("shippingAddress.street")}
  get shippingCity() {return this.checkOutFormGroup.get("shippingAddress.city")}
  get shippingState() {return this.checkOutFormGroup.get("shippingAddress.state")}
  get shippingCountry() {return this.checkOutFormGroup.get("shippingAddress.country")}
  get shippingZipCode() {return this.checkOutFormGroup.get("shippingAddress.zipCode")}

  get creditCardType() { return this.checkOutFormGroup.get("creditCard.cardType")}
  get creditCardNameOnCard() { return this.checkOutFormGroup.get("creditCard.nameOnCard")}
  get creditCardNumber() { return this.checkOutFormGroup.get("creditCard.cardNumber")}
  get creditCardSecurityCode() { return this.checkOutFormGroup.get("creditCard.securityCode")}

  onSubmit()
  {

    console.log("Handling the submit button");
  
    if (this.checkOutFormGroup.invalid)
    {
      this.checkOutFormGroup.markAllAsTouched();
    }

    //set up order
    let order = new Order();
    order.totalPrice = this.totalPrice;
    order.totalQuantity = this.totalQuantity;


    //get cart items 
    const cartItems = this.cartService.cartItems;

    //create orderItems from cartItems

    let orderItemsShort:OrderItem[] = cartItems.map(tempCartItem =>
      new OrderItem(tempCartItem));

      //set up purchase
      let purchase = new  Purchase();


      purchase.customer = 
      this.checkOutFormGroup.controls['customer'].value;

      //populate purchase - shipping address

      purchase.shippingAddress = this.checkOutFormGroup.controls['shippingAddress'].value;
      const shippingState:State = JSON.parse(JSON.stringify(purchase.shippingAddress.state));
      const shippingCountry:Country = JSON.parse(JSON.stringify(purchase.shippingAddress.country));

      purchase.shippingAddress.state = shippingState.name;
      purchase.shippingAddress.country = shippingCountry.name;

      //populate purchase - order and orderItems
      purchase.order = order;
      purchase.orderItems = orderItemsShort;


      //call REST API VIA THE checkoutService
      this.checkoutService.placeOrder(purchase).subscribe(
      {
        next: response => {
          alert("Your order has been received. \n Order Tracking number " 
          + response.orderTrackingNumber)

          //reset cart
          this.resetCart();
        },
        error: errorResponse =>
        {
          alert("There's an error: " + errorResponse.message)
        }
      }
      )
  }

  resetCart()
  {
    this.cartService.cartItems = [];
    this.cartService.priceTotal.next(0);
    this.cartService.quantityTotal.next(0);

    this.checkOutFormGroup.reset();

    this.router.navigateByUrl("/products");
  }



  handleMonthsAndYears()
  {
    const creditCardFormGroup = this.checkOutFormGroup.get("creditCard");

    const currentYear:number = new Date().getFullYear();
    const selectedYear:number = Number(creditCardFormGroup?.value.expirationYear);




    if (currentYear === selectedYear)
    {
      this.startMonth = new Date().getMonth() + 1;
    }
    else 
    {
      this.startMonth = 1;
    }
      this.lewisShopFormService.getCreditCardMonth(this.startMonth).subscribe(
        data =>
        {
          console.log("Retrieved credit card month: " + JSON.stringify(data));

          this.creditCardMonths = data;
          this.checkOutFormGroup.get("creditCard")?.get("expirationMonth")?.setValue(this.startMonth)
        }
      )
   
  }


  getStates(formgroupName:string)
  {

    const formGroup  = this.checkOutFormGroup.get(formgroupName);


    const countryCode = formGroup?.value.country.code;
    const countryName = formGroup?.value.country.name;

    this.lewisShopFormService.getStates(countryCode).subscribe(
      result => 
      {
        if (formgroupName  == 'shippingAddress')
        {
          this.shippingAddressStates = result;
        }
      }
    )

  }

}
