import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any>{
    return this.http.get("http://localhost:8080/api/admin/utilisateurs");
  }

  updateUtilisateur(data: any): Observable<any> {
    return this.http.put("http://localhost:8080/api/admin/utilisateur/apdate", data);
  }
}
