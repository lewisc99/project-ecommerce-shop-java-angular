import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../models/cart-item';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() {
    
   }

  cartItems:CartItem[] = [];
    priceTotal:Subject<number> = new BehaviorSubject<number>(0);
    quantityTotal:Subject<number> = new BehaviorSubject<number>(0);

 

    addToCart(tempProduct:Product)
    {
      if (this.cartItems.length > 0)
      {
       
        let  hasCartItem = this.cartItems.find(prod => prod.product.id == tempProduct.id);

        if (hasCartItem != null)
        {
          this.cartItems.filter(prod => prod.product.id == tempProduct.id).map(prod => prod.quantity++);
      
        }
        else
        {
          let cart = new CartItem(tempProduct,1);
          this.cartItems.push(cart);
       
        }
        
      }
      else 
      {
        let cart:CartItem = new CartItem(tempProduct,1);
        this.cartItems.push(cart);
       
      }

      this.computeCartTotal();


    }

    removeQuantityOnCart(productItem:Product)
    {
      let  hasCartItem = this.cartItems.find(prod => prod.product.id == productItem.id);

      if (hasCartItem != null)
        {
          if (hasCartItem.quantity > 1){
            this.cartItems.filter(prod => prod.product.id == productItem.id).map(prod => prod.quantity-=1);
          }
      
        }
      this.computeCartTotal();
    }


    removeProductOnCart(productItem:Product)
    {
      
      let hasCartItem = this.cartItems.find(prod => prod.product.id == productItem.id);

      if (hasCartItem != null)
      {
        if (hasCartItem.quantity >= 1)
        {
          let findIndex = this.cartItems.findIndex(prod => prod.product.id == hasCartItem?.product.id);

          this.cartItems.splice(findIndex,1);
        }
      }

      this.computeCartTotal();
    }

  computeCartTotal() {

      let tempPrice:number = 0;
      let tempQuantity:number = 0;

      for(let tempCart of this.cartItems)
      {
          tempPrice +=  tempCart.quantity * tempCart.product.price
          tempQuantity += tempCart.quantity;

      }


      this.priceTotal.next(tempPrice);
      this.quantityTotal.next(tempQuantity);

  }

}
