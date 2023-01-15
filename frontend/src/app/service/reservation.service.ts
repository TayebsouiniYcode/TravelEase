import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation.model';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  reserve(reservation: Reservation): Observable<any> {
    return this.http.post("http://localhost:8080/api/hotel/reservation", reservation);
  }
}
