import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<any>{
    const endpoint = `employee/${id}`;
    return this.http.get(endpoint);
  }

  getAllEmployees(): Observable<any[]>{
    return this.http.get<any[]>(`${this.apiUrl}/employee/all`);
  }

  addTeam(teamId: number, employeeId:number): Observable<any>{
    return this.http.post(`${this.apiUrl}/team/${teamId}/members/${employeeId}`,[]);
  }

  saveEmployee(formData: any): Observable<any>{
    const endpoint = `${this.apiUrl}/employee/save`;
    return this.http.post(endpoint, formData);
  }

}
