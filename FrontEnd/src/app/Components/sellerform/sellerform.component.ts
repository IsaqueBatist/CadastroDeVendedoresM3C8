import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { ISeller } from '../../types/seller';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { IGender } from '../../types/gender';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SellerService } from '../../service/seller.service';

@Component({
  selector: 'app-sellerform',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [SellerService],
  templateUrl: './sellerform.component.html',
  styleUrl: './sellerform.component.css'
})
export class SellerformComponent implements OnInit, OnChanges{

  constructor(private formBuilder: FormBuilder){
    this.formGroupSeller = this.formBuilder.group({
      id: {value: null, disable:true},
      name: ['', [Validators.required, Validators.minLength(3)]],
      salary: ['', [Validators.required, Validators.min(1000)]],
      gender: ['', [Validators.required]]
    })
  }
  formGroupSeller: FormGroup;

  @Input()
  seller: ISeller = {} as ISeller

  @Input()
  genders: IGender[] = []

  @Output()
  saveEmmiter = new EventEmitter()


  ngOnChanges(): void {
    if(this.seller.id){
      this.formGroupSeller.setValue(this.seller)
    }
  }
  ngOnInit(): void { }
  
  emmiteSave() {
    if(this.formGroupSeller.invalid) return
    Object.assign(this.seller, this.formGroupSeller.value)
    this.saveEmmiter.emit(true)
  }
  cancelButton() {
    this.formGroupSeller.reset()
    this.saveEmmiter.emit(false)
  }

  get pfsName() {return this.formGroupSeller.get('name')}
  get pfsSalary() {return this.formGroupSeller.get('salary')}
  get pfsGender() {return this.formGroupSeller.get('gender')}
}
