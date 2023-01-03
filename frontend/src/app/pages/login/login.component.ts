import { Component, OnInit } from '@angular/core';
import { LoginForm } from '../../model/login-form.Model';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: LoginForm;

  constructor(private authService: AuthService ) { }

  ngOnInit(): void {
  }

  login() {
    console.log("username: " + this.loginForm.username + " password: " + this.loginForm.password);
    this.authService.login(this.loginForm).subscribe();
  }

}
