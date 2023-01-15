import { Component, OnInit } from '@angular/core';
import { LoginForm } from '../../model/login-form.Model';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';
import { UserLogedInDto } from 'src/app/model/user-loged-in-dto.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: LoginForm = new LoginForm();
  userLogedInDto: UserLogedInDto = new UserLogedInDto();
  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.userLogin).subscribe(
      (data) => {
        this.userLogedInDto = data;
        console.log(this.userLogedInDto);
        localStorage.clear();
        localStorage.setItem("token", this.userLogedInDto.token);
        localStorage.setItem("username", this.userLogedInDto.username);
        localStorage.setItem("roles", JSON.stringify(this.userLogedInDto.roles));
        this.router.navigate(["/dashboard"]);
      }
    );
  }
}
