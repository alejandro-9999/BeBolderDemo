import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VacationRequestService {

  private apiUrl = 'http://localhost:8081/vacation_requests';

  constructor(private http: HttpClient) {}


  createVacationRequest(vacationRequestData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/save`, vacationRequestData);
  }

}
