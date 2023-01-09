import { Injectable } from '@angular/core';
import { LoginForm } from '../model/login-form.Model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDto } from '../model/user-dto.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = "http://localhost:8080/api/auth/login"
  constructor(private http: HttpClient) { }

  login(loginForm: LoginForm): Observable<any> {
    return this.http.post(this.baseUrl, loginForm);
  }

  register(userDto: UserDto): Observable<any>{
    return this.http.post("http://localhost:8080/api/auth/register", userDto);
  }
}
