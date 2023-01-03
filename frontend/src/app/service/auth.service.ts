import { Injectable } from '@angular/core';
import { LoginForm } from '../model/login-form.Model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  login(loginForm: LoginForm): string {

    return " ";
  }
}
