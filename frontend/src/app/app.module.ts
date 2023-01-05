import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

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

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    SidebarComponent,
    FooterComponent,
    DashboardComponent,
    HotelsComponent,
    CreateHotelComponent,
    DetailsHotelComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
