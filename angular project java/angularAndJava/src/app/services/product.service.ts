import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

 

  constructor(private httpClient:HttpClient) { }

 
getProductList(value:number): Observable<Product[]> {
  
    return this.httpClient.get<GetResponseProduct>(`http://localhost:8080/products/${value}/6`).pipe( //size specify the number you want.
      map((response:any)  => 
      
      response)
    )
  }


  getProductbyId(id:number): Observable<Product> {
    return this.httpClient.get<GetResponseProduct>('http://localhost:8080/products/' + id).pipe(
      map((response:any) =>
      response )
    )
  }

  getProductBySearchName(nameOfProduct:string):Observable<Product[]>
  {
    return this.httpClient.get<GetResponseProducts>("http://localhost:8080/products/search?name="+ nameOfProduct).pipe(
      map(
        (response:any ) => response
      )
    )
  }

  

  
}

interface GetResponseProducts
{
  product:Product[]
}





  interface GetResponseProduct 
 {
    product:Product
 }