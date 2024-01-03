import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../services/product.service";
import {Product} from "../model/product.model";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {update} from "@angular-devkit/build-angular/src/tools/esbuild/angular/compilation/parallel-worker";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-edit-product',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './edit-product.component.html',
  styleUrl: './edit-product.component.css'
})
export class EditProductComponent implements OnInit{
  productId!: number;
  productFormGroup!: FormGroup;
  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private formBuilder: FormBuilder,
              private router: Router)
  {
  }
  ngOnInit(): void {
    this.productId =  this.activatedRoute.snapshot.params['id'];
    this.productService.getProductById(this.productId).subscribe((data: any) => {
      this.productFormGroup = this.formBuilder.group({
        id: this.formBuilder.control(data.id),
        name: this.formBuilder.control(data.name),
        price: this.formBuilder.control(data.price),
        checked: this.formBuilder.control(data.checked)
      });
    });
  }
  updateProduct() {
    let product: Product = this.productFormGroup.value;
    this.productService.updateProduct(product).subscribe((data: any) => {
      this.router.navigate(['/admin/products'])
    });
  }
}
