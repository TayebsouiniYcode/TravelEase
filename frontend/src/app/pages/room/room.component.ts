import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Room } from 'src/app/model/room.model';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  idRoom: number;
  room!: Room;

  constructor(private route: ActivatedRoute, private roomService: RoomService) {
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
      }
    )
  }

}
