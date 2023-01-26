import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-detail',
  host: {
    class:'Project-wrapper'
},
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {


  tempProduct!:Product;
  price!:number;
  quantity!:number;

  constructor(private productService:ProductService, private route:ActivatedRoute, private cartService:CartService) { }

  ngOnInit(): void {
    this.productById();
    this.handleCartTotal();
    
  }

  productById()
  {
    let ProductId = +this.route.snapshot.params['id'];
   
    
    this.productService.getProductbyId(ProductId).subscribe(
      responseProductById => {
        this.tempProduct = responseProductById;
      }
    )
  }

  addToCart(tempProduct:Product)

  {
    this.cartService.addToCart(tempProduct);

  }

  handleCartTotal()
  {
    this.cartService.priceTotal.subscribe(
     ( response )=> {
        this.price= response
      }
    )

    this.cartService.quantityTotal.subscribe(
      ( response )=> {
         this.quantity = response
       }
     )
  }
}
