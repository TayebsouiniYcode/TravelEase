import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string | null;

  constructor(@Inject(DOCUMENT) private document: Document, private auth: AuthService) {
    this.username = localStorage.getItem("username");
  }



  ngOnInit(): void {  }

  sidebarToggle(){
    this.document.body.classList.toggle('toggle-sidebar');
  }

  lougout() {
    this.auth.logout();
  }

}
