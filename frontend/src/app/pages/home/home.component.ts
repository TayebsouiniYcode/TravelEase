import { Component, OnInit } from '@angular/core';
import { FindRoomForm } from 'src/app/model/find-room-form.model';
import { RoomService } from 'src/app/service/room.service';
import { Room } from 'src/app/model/room.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  findRoomForm: FindRoomForm;

  isAuthenticate: boolean = false;

  roomList!: Room[];

  constructor(private roomService: RoomService, private router: Router) {
    this.checkAuthentication();
    this.getAllRooms();
    this.findRoomForm = new FindRoomForm();
    this.findRoomForm.type = "single";
    this.findRoomForm.city = "marrakech";

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

  checkAuthentication() {
    let token = localStorage.getItem("token");
    if (token) {
      this.isAuthenticate = true;
    }
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
