import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Room } from 'src/app/model/room.model';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-details-room',
  templateUrl: './details-room.component.html',
  styleUrls: ['./details-room.component.css']
})
export class DetailsRoomComponent implements OnInit {

  room: Room = new Room;

  constructor(private route: ActivatedRoute, private roomService: RoomService) {
    let idRoom = Number(this.route.snapshot.params['id']);
    console.log(idRoom);
    this.getRoomById(idRoom);

   }

  ngOnInit(): void {
  }

  getRoomById(idRoom: number): void {
    this.roomService.getRoomById(idRoom).subscribe(
      (room) => {
        this.room = room;
      }
    )
  }

  saveChangesRoom() {
    this.roomService.updateRoom(this.room).subscribe(
      (room) => {
        console.log(room);
      }
    )
  }
}
