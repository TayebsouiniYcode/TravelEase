import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel.model';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-details-hotel',
  templateUrl: './details-hotel.component.html',
  styleUrls: ['./details-hotel.component.css']
})
export class DetailsHotelComponent implements OnInit {

  hotel!: Hotel;
  idHotel?: number;
  numberOfRooms!: number;


  constructor(
    private activateRouter: ActivatedRoute,
    private hotelService: HotelService,
    private router: Router
  ) {
    this.idHotel = this.activateRouter.snapshot.params["id"] ;
    this.getHotelDetails(Number(this.idHotel));
   }

  ngOnInit(): void {

  }

  getHotelDetails(idHotel: number): any {
    return this.hotelService.getHotelDetails(idHotel).subscribe({
      next: (result) => {
        this.hotel = result;
      },
      error: (e) => console.error(e)
    });;
  }

  deleteHotel(): void {
    this.hotelService.deleteHotel(Number(this.idHotel)).subscribe(
      (data) => {
        console.log(data);
        this.router.navigate(['/dashboard']);
      }
    )
  }
}
