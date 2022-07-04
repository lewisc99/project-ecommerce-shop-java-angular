import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';

import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'product-list',
  host: {
    class:'Project-list'
  },
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private productService:ProductService, private cartService:CartService, private activedRoute:ActivatedRoute, private router:Router) { }
  products:Product[] = [];
  index:number = 0;
  valueOfKeyword!:string;

  quantity!:number;
  price!:number;
  

  ngOnInit(): void {

 

    this.handleCartTotal();
    this.activedRoute.paramMap.subscribe(() => {
      this.productList();
    });

    
  }

  indexPaginationIndex(event:number)
      {
        this.index = event;
        this.productList();
      }
 

    productList()
    {
     
      this.valueOfKeyword = this.activedRoute.snapshot.paramMap.get("keyword")!
       
      if (this.valueOfKeyword != null)
      {
        
        this.handleProductByName();
        

      }
      else{
     

      this.productService.getProductList(this.index).subscribe(
        response => {
          this.products = response;
          console.log("Response " + response)
        }
      )
    }      
    }

    handleProductByName()
    {
      this.productService.getProductBySearchName(this.valueOfKeyword).subscribe(
        response =>
        {
          this.products = response;
          console.log(response) 
          
        }
       )

    }

    addToCart(temp:Product)
    {
     

       this.cartService.addToCart(temp);
    }


    handleCartTotal()
    {
      this.cartService.priceTotal.subscribe(
        response =>
        {
          this.price = response
        }
      )

      this.cartService.quantityTotal.subscribe(
        response =>
        {
          this.quantity = response
        }
      )

    }
}
