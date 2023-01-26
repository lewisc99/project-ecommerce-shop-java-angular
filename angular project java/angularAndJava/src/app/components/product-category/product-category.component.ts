import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {



  constructor(private categoryService:CategoryService) { }
  categories:Category[] = [];

  ngOnInit(): void {

    this.getCategories();
  }


  getCategories()
  {

    this.categoryService.getCategories().subscribe(
      response => {this.categories = response
      console.log(response)}
    
    )
  }

}
