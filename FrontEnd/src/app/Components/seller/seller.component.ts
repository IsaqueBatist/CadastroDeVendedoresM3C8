import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";
import { SellerformComponent } from "../sellerform/sellerform.component";
import { ISeller } from '../../types/seller';
import { CommonModule } from '@angular/common';
import { IGender } from '../../types/gender';
import {ReactiveFormsModule} from '@angular/forms';
@Component({
  selector: 'app-seller',
  standalone: true,
  imports: [
    HeaderComponent,
    FooterComponent,
    SellerformComponent,
    CommonModule
          ],
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css'
})
export class SellerComponent {

  seller: ISeller = {} as ISeller
  idCounter: number = 5
  isEditing: boolean = false
  isFormtoBeShown: boolean = true
  deletedSeller: ISeller = {} as ISeller


  genders: IGender[] = [
    { id: 1, name: 'Masculino' },
    { id: 2, name: 'Feminino' }
  ]
  sellers: ISeller[] = [
    { id: 1, name: 'Seller 1', salary: 1000, gender: 1 },
    { id: 2, name: 'Seller 2', salary: 1500, gender: 2 },
    { id: 3, name: 'Seller 3', salary: 2000, gender: 1 },
    { id: 4, name: 'Seller 4', salary: 1800, gender: 2 },
    { id: 5, name: 'Seller 5', salary: 1300, gender: 1 }
  ]

  saveSeller() {
    if(this.isEditing) {
      this.isEditing = false
      this.seller = {} as ISeller
    }else{
      this.seller.id = this.idCounter + 1
      this.sellers.push(this.seller)
      this.seller = {} as ISeller
      this.idCounter++
    }
    this.isFormtoBeShown = false
    console.log(this.sellers)
  }
  updateSeller(seller: ISeller) {
    this.seller = seller
    this.isFormtoBeShown = true
    this.isEditing = true
  }
  cancel(){
    this.seller = {} as ISeller
    this.isFormtoBeShown = false
  }
  deleteSeller(seller: ISeller) {
      this.deletedSeller = seller
      this.sellers = this.sellers.filter(s => s.id !== seller.id)
  }
}
