import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
    private hotelService: HotelService
  ) {


    //this.getHotelDetails(Number(this.idHotel));
    //this.numberOfRooms = this.hotel.rooms.length;
   }

  ngOnInit(): void {
    this.idHotel = this.activateRouter.snapshot.params["id"] ;
    console.log(this.getHotelDetails(Number(this.idHotel)));
  }

  getHotelDetails(idHotel: number): any {
    return this.hotelService.getHotelDetails(idHotel).subscribe({
      next: (result) => {
        console.log(result);
        this.hotel = result;
      },
      error: (e) => console.error(e)
    });;
  }

  vide(): void { }
}
