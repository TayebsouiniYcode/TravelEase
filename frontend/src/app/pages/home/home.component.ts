import { Component, OnInit } from '@angular/core';
import { FindRoomForm } from 'src/app/model/find-room-form.model';
import { RoomService } from 'src/app/service/room.service';
import { Room } from 'src/app/model/room.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  findRoomForm: FindRoomForm;

  roomList!: Room[];

  constructor(private roomService: RoomService) {
    this.findRoomForm = new FindRoomForm();
    this.getAllRooms();
   }

  ngOnInit(): void { }

  getAllRooms() {
    this.roomService.getAllRooms().subscribe(
      (roomList) => {
        this.roomList =  roomList;
      }
    );
  }

  findRooms() {
    this.roomService.findDisponibleRooms(this.findRoomForm).subscribe(
      (foundedRoom) => {
        this.roomList = foundedRoom;
      }
    );
  }

}
