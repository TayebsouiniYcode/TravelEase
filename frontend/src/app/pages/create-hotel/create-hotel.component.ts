import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../model/hotel.model';
import { HotelService } from '../../service/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-hotel',
  templateUrl: './create-hotel.component.html',
  styleUrls: ['./create-hotel.component.css']
})
export class CreateHotelComponent implements OnInit {

  hotel: Hotel = new Hotel();


  constructor(private hotelService: HotelService, private router: Router) {
  }

  ngOnInit(): void {
  }

  create(): void {
    console.log(this.hotel.name);
    this.hotelService.create(this.hotel).subscribe({
      next: (result) => {
        console.log(result);
        this.router.navigate(['/hotels'])
      },
      error: (e) => console.error(e)
    });
  }

}
