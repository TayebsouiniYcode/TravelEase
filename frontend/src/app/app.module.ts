import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { PathLocationStrategy, LocationStrategy } from '@angular/common'; // routing after build

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './layouts/header/header.component';
import { LoginComponent } from './pages/login/login.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HotelsComponent } from './pages/hotels/hotels.component';
import { AppRoutingModule } from './app-routing.module';

import { CreateHotelComponent } from './pages/create-hotel/create-hotel.component';
import { DetailsHotelComponent } from './pages/details-hotel/details-hotel.component';
import { AddroomComponent } from './pages/addroom/addroom.component';
import { DetailsRoomComponent } from './pages/details-room/details-room.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { RoomComponent } from './pages/room/room.component';
import { UtilisateursComponent } from './pages/utilisateurs/utilisateurs.component';
import { MyreservationsComponent } from './pages/myreservations/myreservations.component';
import { InterceptorInterceptor } from './interceptor/interceptor.interceptor';
import { ProprietaireComponent } from './pages/proprietaire/proprietaire.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    DashboardComponent,
    HotelsComponent,
    CreateHotelComponent,
    DetailsHotelComponent,
    AddroomComponent,
    DetailsRoomComponent,
    RegisterComponent,
    HomeComponent,
    RoomComponent,
    LoginComponent,
    UtilisateursComponent,
    ProprietaireComponent,
    MyreservationsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorInterceptor,
      multi: true
    },
    { provide: LocationStrategy, useClass: PathLocationStrategy } // after build solve problem of routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
