import { Injectable } from '@angular/core';

const token = localStorage.getItem("token");

@Injectable({
  providedIn: 'root'
})
export class TokenService {


  constructor() { }

  getUsername() {
    if (token) {
        let jsonToken = JSON.parse(atob(token.split('.')[1]));
        return jsonToken.sub;
    }
  }

  getExprirationDate(): any {
    if (token) {
        let jsonToken_ = JSON.parse(atob(token.split('.')[1]));
        let dateExpr = new Date();
        dateExpr.setUTCSeconds(jsonToken_.exp)
        return dateExpr;
    }
  }

  getRoles() {
    if (token) {
      let jsonToken_ = JSON.parse(atob(token.split('.')[1]));
      return jsonToken_.authorities;
    }
  }


}
