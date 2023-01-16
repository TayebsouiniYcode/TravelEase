import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from './service/token.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TravelEase';
  // logedIn!: boolean;


  constructor(public  _router: Router) {
    // let username = localStorage.getItem("username");
    // if (username) {
    //   this.logedIn = true;
    // } else {
    //   this.logedIn = false;
    // }
  }


}
