import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ISeller } from '../types/seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http: HttpClient) { }

  getSellers(): Observable<ISeller[]>{
    return this.http.get<ISeller[]>('http://localhost:8080/sellers');
  }

  saveSllers(seller: ISeller){
    return this.http.post<ISeller>('http://localhost:8080/sellers', seller);
  }

  updateSeller(seller: ISeller){
    return this.http.put<ISeller>(`http://localhost:8080/sellers/${seller.id}`, seller);
  }

  deleteSeller(seller: ISeller){
    return this.http.delete<void>(`http://localhost:8080/sellers/${seller.id}`);
  }
}
