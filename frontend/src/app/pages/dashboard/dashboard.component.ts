import { Component, OnInit, ElementRef } from '@angular/core';
import { HotelService } from 'src/app/service/hotel.service';
import { Hotel } from 'src/app/model/hotel.model';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  noApprovedHotels: Hotel[] = [];
  statistiquesList!: any;
  myReservation!: any;

  constructor(private elementRef: ElementRef,
    private hotelService: HotelService,
    private router: Router,
    private tokenService: TokenService,) {
    this.getStatistiques();
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

  getStatistiques() {
    this.hotelService.getStatistiques().subscribe(
      (statistiques) => {
        this.statistiquesList = statistiques;
        this.statistiquesList.numberOfReservation = 0;
        this.statistiquesList.numberOfRooms = 0;
      }
    )
  }

  hasRole(roleName: string) : boolean | any{
    let roles = this.tokenService.getRoles();

    for (const authority in roles) {
      if (roles[authority].authority == roleName) {
        return true;
      }
    }
  }
}
