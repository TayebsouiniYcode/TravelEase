import { Injectable } from '@angular/core';
import { Hotel } from '../model/hotel.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// const headers = new HttpHeaders({
//   'Content-Type': 'application/text',
//   'Authorization': `Bearer ${localStorage.getItem("token")}`
// });

@Injectable({
  providedIn: 'root'
})

export class HotelService {

  constructor(private http: HttpClient) { }

  // headers_object = new HttpHeaders().set("AUTHORIZATION", "Bearer " + localStorage.getItem("token"));

  create(hotel: Hotel): Observable<any>{
    // console.log(headers);
    // return this.http.post("http://localhost:8080/api/hotel/add", hotel, {headers: headers});
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
}
