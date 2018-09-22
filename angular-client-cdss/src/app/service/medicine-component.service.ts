import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicineComponentService {

  constructor(private http:HttpClient) { }


  getAll(){
    return this.http.get('/api/medicine_components');
  }
}
