import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-product-category-by-id',
  host: {
    class:'Project-category'
  },
  templateUrl: './product-category-by-id.component.html',
  styleUrls: ['./product-category-by-id.component.css']
})
export class ProductCategoryByIdComponent implements OnInit {

  products!: Product[];
  price!:number;
  quantity!:number;

  constructor( private categoryService:CategoryService, private activeRouter:ActivatedRoute,private cartService:CartService) { }

  ngOnInit(): void {
    this.activeRouter.paramMap.subscribe(() => {
    this.getCategoryById();
    });

    this.handleCartTotal();
  }

  getCategoryById()
  {
    let categoryId = +this.activeRouter.snapshot.params['id'];

    this.categoryService.getCategoryById(categoryId).subscribe(
    
      response => {this.products = response
      console.log(response)}
     
    )

  }

  addToCart(tempProduct:Product)
  {
    this.cartService.addToCart(tempProduct);
  }


  handleCartTotal()
  {
    this.cartService.priceTotal.subscribe(
      response => 
      this.price = response
    )

    this.cartService.quantityTotal.subscribe(
      response => 
      this.quantity = response
    )
  }

}
