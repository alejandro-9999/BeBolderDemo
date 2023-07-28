import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  saveUser(id: number): Observable<any>{
    const endpoint = `employee/${id}`;
    return this.http.get(endpoint);
  }

}
