import { Component, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-search',

  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {

  constructor(private router:Router) { }
  completeWord:string = "";


  ngOnInit(): void {

  }


  searchForProduct()
  {
   
   this.router.navigateByUrl("search/" + this.completeWord)

  }

  OnCallSearch(valueInput:any)
  {
    this.completeWord = valueInput
    this.searchForProduct();
  }

}
