import { Component, OnInit, ElementRef } from '@angular/core';
import { HotelService } from 'src/app/service/hotel.service';
import { Hotel } from 'src/app/model/hotel.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  noApprovedHotels: Hotel[] = [];

  constructor(private elementRef: ElementRef, private hotelService: HotelService, private router: Router) {
    this.getNoApprovedHotel();
  }

  ngOnInit(): void {
    console.log("this is dashboard ts");
    console.log(localStorage.getItem("token"));
    var s = document.createElement("script");
    s.type = "text/javascript";
    s.src = "../assets/js/main.js";
    this.elementRef.nativeElement.appendChild(s);
  }

  getNoApprovedHotel(){
    this.hotelService.getNoApprovedHotel().subscribe(
      (hotelList) => {
        this.noApprovedHotels = hotelList;
        console.log(this.noApprovedHotels);
      }
    )
  }

  approveHotel(id: number) {
    this.hotelService.approveHotelById(id).subscribe(
      (hotelApproved) => {
        console.log(hotelApproved);
        if (hotelApproved.approved == true) {
          this.noApprovedHotels.forEach(h => {
            if (h.id == hotelApproved.id) {
              let index = this.noApprovedHotels.indexOf (h);
              this.noApprovedHotels.splice(index, 1);
            }
          });
        }
      }
    )
  }


}
