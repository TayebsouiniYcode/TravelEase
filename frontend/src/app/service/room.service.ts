import { Injectable } from '@angular/core';
import { Room } from '../model/room.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }

  createRoom(idHotel: number, room: Room): Observable<any> {
    return this.http.post("http://localhost:8080/api/hotel/addroom/" + idHotel, room);
  }
}
