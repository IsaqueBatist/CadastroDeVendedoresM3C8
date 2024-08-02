import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FooterComponent } from "../footer/footer.component";
import { SellerformComponent } from "../sellerform/sellerform.component";
import { ISeller } from '../../types/seller';
import { CommonModule } from '@angular/common';
import { IGender } from '../../types/gender';
import { ReactiveFormsModule } from '@angular/forms';
import { SellerService } from '../../service/seller.service'
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-seller',
  standalone: true,
  imports: [
    HeaderComponent,
    FooterComponent,
    SellerformComponent,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [SellerService],
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css'
})
export class SellerComponent implements OnInit {

  constructor(private sellerService: SellerService) { }

  seller: ISeller = {} as ISeller
  idCounter: number = 5
  isEditing: boolean = false
  isFormtoBeShown: boolean = true
  deletedSeller: ISeller = {} as ISeller


  genders: IGender[] = [
    { id: 1, name: 'Masculino' },
    { id: 2, name: 'Feminino' }
  ]
  sellers: ISeller[] = []

  loadSeller() {
    this.sellerService.getSellers().subscribe({
      next: (data: ISeller[]) => {
        this.sellers = data
      },
    })
  }

  ngOnInit() {
    this.loadSeller();
  }

  saveSeller(save: boolean) {
    if (save) {
      if (this.isEditing) {
        this.sellerService.updateSeller(this.seller).subscribe()
      } else {
        this.sellerService.saveSllers(this.seller).subscribe(({
          next: (data: ISeller) => {
            this.sellers.push(data)
            this.seller = {} as ISeller
          }
        }))
      }
    }
    this.seller = {} as ISeller
    this.isEditing = false
    this.isFormtoBeShown = false
  }
  updateSeller(seller: ISeller) {
    this.seller = seller
    this.isEditing = true
    this.isFormtoBeShown = true
  }
  deleteSeller(seller: ISeller) {
    this.sellerService.deleteSeller(seller).subscribe({
      next: () => {
        this.deletedSeller = seller
        this.sellers = this.sellers.filter(s => s.id !== this.deletedSeller.id)
      }
    })
  }
}
