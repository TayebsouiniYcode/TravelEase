import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HotelsComponent } from './pages/hotels/hotels.component';
import { CreateHotelComponent } from './pages/create-hotel/create-hotel.component';
import { DetailsHotelComponent } from './pages/details-hotel/details-hotel.component';
import { AddroomComponent } from './pages/addroom/addroom.component';
import { DetailsRoomComponent } from './pages/details-room/details-room.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { RoomComponent } from './pages/room/room.component';

import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: "dashboard" , component: DashboardComponent, canActivate: [AuthGuard]},
  { path: "addhotel", component: CreateHotelComponent, canActivate: [AuthGuard]},
  { path: "detailshotel/:id", component: DetailsHotelComponent, canActivate: [AuthGuard]},
  { path: "addroom/:id", component: AddroomComponent, canActivate: [AuthGuard]},
  { path: "room/:id", component: RoomComponent, canActivate: [AuthGuard]},
  { path: "hotels" , component: HotelsComponent, canActivate: [AuthGuard]},
  { path: "detailsroom/:id", component: DetailsRoomComponent, canActivate: [AuthGuard]},
];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
