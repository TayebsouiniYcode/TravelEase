import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginForm } from './login-form.model';


@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private loginURL = "http://localhost:8080/api/v1/auth/login";

  constructor(private http: HttpClient) { }

  authenticate(loginForm: LoginForm): Observable<any>{
    console.log("TRFDGFFD");
    return this.http.post(this.loginURL , loginForm);
  }
}
