import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";
import { SellerformComponent } from "../sellerform/sellerform.component";
import { ISeller } from '../../types/seller';
import { CommonModule } from '@angular/common';
import { IGender } from '../../types/gender';

@Component({
  selector: 'app-seller',
  standalone: true,
  imports: [HeaderComponent, FooterComponent, SellerformComponent, CommonModule],
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css'
})
export class SellerComponent {

  seller: ISeller = {} as ISeller
  genders: IGender[] = [
    { id: 1, name: 'Masculino' },
    { id: 2, name: 'Feminino' }
  ]
  isEditing: boolean = false

  sellers: ISeller[] = [
    { id: 1, name: 'Seller 1', salary: 1000, gender: { id: 1, name: 'Maculino' } },
    { id: 2, name: 'Seller 2', salary: 1500, gender: { id: 2, name: 'Feminino' } },
    { id: 3, name: 'Seller 3', salary: 2000, gender: { id: 1, name: 'Maculino' } },
    { id: 4, name: 'Seller 4', salary: 1800, gender: { id: 2, name: 'Feminino' } },
    { id: 5, name: 'Seller 5', salary: 1300, gender: { id: 1, name: 'Maculino' } }
  ]

  saveSeller() {
    if(this.isEditing) {
      this.isEditing = false
      this.seller = {} as ISeller
      return
    }
    this.sellers.push(this.seller)
    this.seller = {} as ISeller
  }
  updateSeller(seller: ISeller) {
    this.seller = seller
    this.isEditing = true
  }
}
