import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SymptomService {

  constructor(private http:HttpClient) { }


  getAll(){
    return this.http.get('/api/symptoms');
  }

  getByDisease(id:number){
    return this.http.get(`/api/symptoms/get_by_disease/${id}`);
  }
}
