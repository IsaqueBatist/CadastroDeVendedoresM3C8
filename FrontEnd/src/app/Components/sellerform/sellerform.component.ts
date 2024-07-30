import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ISeller } from '../../types/seller';
import { FormsModule } from '@angular/forms';
import { IGender } from '../../types/gender';
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
  seller: ISeller = {} as ISeller

  @Input()
  genders: IGender[] = []

  @Output()
  saveEmmiter = new EventEmitter<ISeller>()

  @Output()
  cancelEmmiter = new EventEmitter<void>()

  emmiteSave() {
    this.saveEmmiter.emit()
  }
  emmiteCancel() {
    this.cancelEmmiter.emit()
  }
}
