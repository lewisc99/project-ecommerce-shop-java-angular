import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-status',
  templateUrl: './cart-status.component.html',
  styleUrls: ['./cart-status.component.css']
})
export class CartStatusComponent implements OnInit {

  constructor(private cartService:CartService) { }
  totalPrice!:number;
  totalQuantity!:number;

  ngOnInit(): void {


    this.cartStatus();
  }


  cartStatus()
  {
      this.cartService.priceTotal.subscribe(
         response => 
         {
           this.totalPrice = response
         }
      )

      this.cartService.quantityTotal.subscribe(
        response => 
        {
          this.totalQuantity = response
        }
     )
  }
}
