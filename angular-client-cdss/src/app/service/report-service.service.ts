import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportServiceService {

  private reportData;

  constructor(private http:HttpClient) {
    // this.reportData = {};
   }

  getReport(url:string){
    return this.http.get(url);
  }

  getPatientWithChronic(){
    return this.http.get('/api/patients/with_chronic');
  }

  getPatientsAddicts(){
    return this.http.get('/api/patients/addicts');
  }

  getPatientsWithWeakImmunity(){
    return this.http.get('/api/patients/weak_immunity');
  }

  public getReportData(){
    return this.reportData;
  }

  public clearReportData(){
    this.reportData = {};
  }
}
