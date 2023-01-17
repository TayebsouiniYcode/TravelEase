import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-myreservations',
  templateUrl: './myreservations.component.html',
  styleUrls: ['./myreservations.component.css']
})
export class MyreservationsComponent implements OnInit {

  myReservation!: any;

  constructor(private reservationService: ReservationService) {
    this.getMyReservations();
   }

  ngOnInit(): void {
  }

  getMyReservations() {
    this.reservationService.getMyReservations().subscribe(
      (res) => {
        this.myReservation = res;
        console.log(this.myReservation);
      }
    )
  }

}
