import { Injectable } from '@angular/core';
import { Hotel } from '../model/hotel.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})

export class HotelService {

  constructor(private http: HttpClient) { }

  create(hotel: Hotel): Observable<any>{
    return this.http.post("http://localhost:8080/api/hotel/add", hotel);
  }

  getAllHotels(): Observable<any> {
    return this.http.get("http://localhost:8080/api/hotel/hotels");
  }

  getHotelDetails(idHotel: number): Observable<any> {
    return this.http.get("http://localhost:8080/api/hotel/" + idHotel);
  }

  getNoApprovedHotel(): Observable<any> {
    return this.http.get("http://localhost:8080/api/hotel/toapprove");
  }

  approveHotelById(id: number): Observable<any> {
    return this.http.put("http://localhost:8080/api/hotel/approve/" + id, null);
  }

  getStatistiques(): Observable<any> {
    return this.http.get("http://localhost:8080/api/admin/statistique");
  }

  deleteHotel(idHotel: number): Observable<any> {
    return this.http.delete("http://localhost:8080/api/hotel/delete/" + idHotel);
  }
}
