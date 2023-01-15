import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Room } from 'src/app/model/room.model';
import { RoomService } from 'src/app/service/room.service';
import { Reservation } from 'src/app/model/reservation.model';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  idRoom: number;
  room!: Room;
  reservation: Reservation = new Reservation();

  constructor(private route: ActivatedRoute, private roomService: RoomService, private reservationService: ReservationService) {
    this.idRoom = Number(this.route.snapshot.params['id']);
    this.getRoomById(this.idRoom);
    console.log(this.room);
   }

  ngOnInit(): void {
  }

  getRoomById(idRoom: number) {
    this.roomService.getRoomById(idRoom).subscribe(
      (room) => {
        this.room = room;
        console.log(this.room);
      }
    )
  }

  reserve() {
    this.reservation.idRoom = this.idRoom;
    this.reservationService.reserve(this.reservation).subscribe(
      (reservation_) => {
        console.log(reservation_)
      }
    )
  }
}
