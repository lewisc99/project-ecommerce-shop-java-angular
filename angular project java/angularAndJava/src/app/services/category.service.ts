import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Category } from '../models/category';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient:HttpClient) { }


  getCategories() : Observable<Category[]>
  {
      return this.httpClient.get<CategoryResponse>('http://localhost:8080/api/categories/').pipe(
        map(
          (response:any) => response
        )
      )
  }

  getCategoryById(id:number): Observable<Product[]>
  {
    return this.httpClient.get<CategoryIdResponse>('http://localhost:8080/api/categories/' + id).pipe(
      map(
        (response:any) => response.products
      )
    )
  }
}
interface CategoryResponse
{
  categories: Category[];
}

interface CategoryIdResponse
{
  categories: Category;
  products: Product[]
}