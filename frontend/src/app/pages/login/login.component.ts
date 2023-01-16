import { Component, OnInit } from '@angular/core';
import { LoginForm } from '../../model/login-form.Model';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { UserLogedInDto } from 'src/app/model/user-loged-in-dto.model';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: LoginForm = new LoginForm();
  role!: string | null;

  constructor(private authService: AuthService, private router: Router, private tokenService: TokenService) {
    const token = localStorage.getItem("token");

    if (token) {
      // TODO Check if admin or proprietaire or client
      this.router.navigate(['/dashboard']);
    }
  }

  ngOnInit(): void {}

  login() {
    console.log("this is login component");
    this.authService.login(this.userLogin).subscribe(
      (token_) => {
        if (token_) {
          localStorage.clear();
          console.log(token_);
          localStorage.setItem("token", token_);
          this.router.navigate(['/dashboard']);
        } else {
          console.log("token is null");
        }
  });
}
}
