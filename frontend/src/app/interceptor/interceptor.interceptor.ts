import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class InterceptorInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log("this is interceptor");
    const token = localStorage.getItem("token");
    console.log(token);
    if (token) {
      const cloned  = request.clone({
        headers: request.headers.set("Authorization", `Bearer ${token}`)
      });
      return next.handle(cloned);
    }

    return next.handle(request);
  }
}
