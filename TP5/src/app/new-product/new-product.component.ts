import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {ProductService} from "../services/product.service";
import {Product} from "../model/product.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-product',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './new-product.component.html',
  styleUrl: './new-product.component.css'
})
export class NewProductComponent implements OnInit{
  public productForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      name: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      price: this.formBuilder.control(0, [Validators.required, Validators.min(0)]),
      checked: this.formBuilder.control(false)
    });
  }

  saveProduct() {
    let product : Product = this.productForm.value;
    this.productService.saveProduct(product).subscribe((data: any) => {
      this.router.navigate(['/admin/products']);
    });
  }
}
