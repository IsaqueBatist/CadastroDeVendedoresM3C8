import { Component, Input } from '@angular/core';
import { ISeller } from '../../interfaces/seller';
import { FormsModule } from '@angular/forms';
import { IGender } from '../../interfaces/gender';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sellerform',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './sellerform.component.html',
  styleUrl: './sellerform.component.css'
})
export class SellerformComponent {


  @Input()
  seller: ISeller = {
    id: 1,
    name: 'Isaque',
    salary: 1200,
    gender: {
      id: 1,
      name: 'Masculino'
    }
  }

  @Input()
  genders: IGender[] = []
}
