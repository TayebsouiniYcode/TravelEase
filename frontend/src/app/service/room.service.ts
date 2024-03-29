import { Injectable } from '@angular/core';
import { Room } from '../model/room.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FindRoomForm } from '../model/find-room-form.model';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }

  createRoom(idHotel: number, room: Room): Observable<any> {
    return this.http.post("http://localhost:8080/api/hotel/addroom/" + idHotel, room);
  }

  getAllRooms(): Observable<any> {
    return this.http.get("http://localhost:8080/api/room/rooms");
  }

  findDisponibleRooms(findRoomForm: FindRoomForm): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/room/disponible", findRoomForm);
  }

  getRoomById(idRoom: number): Observable<Room> {
    return this.http.get<Room>("http://localhost:8080/api/room/" + idRoom);
  }

  updateRoom(room: any): Observable<any> {
    return this.http.put("http://localhost:8080/api/room/update", room);
  }

  getReservationsByRoom(idRoom: number): Observable<any> {
    return this.http.get("http://localhost:8080/api/room/getreservations/" + idRoom);
  }
}
