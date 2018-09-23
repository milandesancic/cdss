import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiseaseService {

  constructor(private http:HttpClient) { }

  getAll(){
    return this.http.get('/api/diseases');
  }

  getBySymptoms(data){
    return this.http.post('/api/diseases/get_by_symptoms',data);
  }

  getPossibleDisease(id,reqData){
    return this.http.post(`/api/diseases/get_by_symptoms/${id}`,reqData);
  }

  makeDiagnose(id,reqData){
    return this.http.post(`/api/doctor/patient/${id}`,reqData);
  }
}
