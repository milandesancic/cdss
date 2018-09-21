import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }

  authenticateUser(credentials)
  {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post('/api/users/login', credentials, { headers : headers });
  }
}
