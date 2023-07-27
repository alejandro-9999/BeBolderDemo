import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://127.0.0.1:8080';

  constructor(private http: HttpClient) { }

  saveUser(formData: any): Observable<any>{
    const endpoint = `${this.apiUrl}/${formData.userType}/save`;
    return this.http.post(endpoint, formData);
  }

}
