import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private apiUrl = 'http://localhost:8080/team';

  constructor(private http: HttpClient) {};

  teamCreated = new EventEmitter();

  getAllTeams(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

  createTeam(teamData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/save`, teamData);
  }
}
