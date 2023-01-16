import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string | null;

  constructor(@Inject(DOCUMENT) private document: Document, private auth: AuthService, private tokenService: TokenService) {
    this.username = this.tokenService.getUsername();
  }



  ngOnInit(): void {  }

  sidebarToggle(){
    this.document.body.classList.toggle('toggle-sidebar');
  }

  lougout() {
    this.auth.logout();
  }

}
