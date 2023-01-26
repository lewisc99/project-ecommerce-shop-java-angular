import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import {HttpClientModule} from '@angular/common/http';
import { ProductCategoryComponent } from './components/product-category/product-category.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { RouterModule, Routes } from '@angular/router';
import { ProductCategoryByIdComponent } from './components/product-category-by-id/product-category-by-id.component';
import { CartStatusComponent } from './components/product-search/cart-status/cart-status.component';
import { CartDetailComponent } from './components/cart-detail/cart-detail.component';
import { PaginationComponent } from './components/product-list/pagination/pagination.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ReactiveFormsModule } from '@angular/forms';


const routes:Routes =
 [{path:'',component:ProductListComponent},
{path:'detail/:id',component:ProductDetailComponent},
{path:'search/:keyword',component:ProductListComponent},
{path:'categories/:id',component:ProductCategoryByIdComponent},
{path:'cart-detail',component:CartDetailComponent},
{path:'checkout',component:CheckoutComponent},
{path:"**",redirectTo: "", pathMatch:"full"},
{path:"",redirectTo: "", pathMatch:"full"},
]

 
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryComponent,
    ProductSearchComponent,
    ProductDetailComponent,

    ProductCategoryByIdComponent,
     CartStatusComponent,
     CartDetailComponent,
     PaginationComponent,
     CheckoutComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
    
   
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
