import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProductsComponent} from "./products/products.component";
import {NewProductComponent} from "./new-product/new-product.component";
import {EditProductComponent} from "./edit-product/edit-product.component";
import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'home', component: HomeComponent},
  {path: 'admin', component: AdminTemplateComponent, children: [
      {path: 'products', component: ProductsComponent},
      {path: 'newProduct', component: NewProductComponent},
      {path: 'editProduct/:id', component: EditProductComponent},
    ]},
  {path: 'login', component: LoginComponent},
];
