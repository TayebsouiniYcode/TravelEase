import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation.model';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  reserve(reservation: Reservation): Observable<any> {
    return this.http.post("http://localhost:8080/api/hotel/reservation", reservation);
  }

  getMyReservations(): Observable<any> {
    const headers_ = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem("token")}`
    })
    return this.http.get("http://localhost:8080/api/reservation/myreservations", { headers : headers_});
  }
}
