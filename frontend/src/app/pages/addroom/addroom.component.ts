import { Component, OnInit } from '@angular/core';
import { Room } from 'src/app/model/room.model';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from 'src/app/service/room.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addroom',
  templateUrl: './addroom.component.html',
  styleUrls: ['./addroom.component.css']
})
export class AddroomComponent implements OnInit {

  room!: Room;

  constructor(private route : ActivatedRoute, private roomService: RoomService, private router: Router) {
    this.room = new Room();
   }

  ngOnInit(): void { }

  createRoomByHotel() {
    let idHotel = Number (this.route.snapshot.params['id']);
    this.roomService.createRoom(idHotel, this.room).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/detailshotel/' + idHotel]);
      }
    );
  }
}
