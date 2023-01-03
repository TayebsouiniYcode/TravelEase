import { Component, OnInit } from '@angular/core';
import { LoginForm } from './login-form.model';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: LoginForm = new LoginForm();

  constructor( private loginService: LoginService ) { }

  ngOnInit() {
    // TODO document why this method 'ngOnInit' is empty

  }

  login() {
    console.log(this.loginForm.username + " password : "  + this.loginForm.password);
    this.loginService.authenticate(this.loginForm);
  }
}
