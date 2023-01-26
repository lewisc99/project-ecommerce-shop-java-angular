import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/models/cart-item';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-detail',
  host: {
    class:'Project-cart-detail'
  },
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {

  constructor(private cartService:CartService) { }
  cartItems!:CartItem[];
  totalPrice!:number;
  totalQuantity!:number;


  ngOnInit(): void {
    
    this.updateCartDetailInfo();
    
 

  }

  addQuantityOnCart(tempProduct:Product)
  {
    this.cartService.addToCart(tempProduct);
  }

  removeQuantityOnCart(productItem:Product)
  {
    this.cartService.removeQuantityOnCart(productItem);

  }

  removeOnCart(productItem: Product)
  {
    this.cartService.removeProductOnCart(productItem);
  }


  updateCartDetailInfo()
  {
    this.cartItems = this.cartService.cartItems;

    this.cartService.priceTotal.subscribe(
      response => this.totalPrice = response
    )

    this.cartService.quantityTotal.subscribe(
      response => this.totalQuantity = response
    )

    this.cartService.computeCartTotal();
  }
}
