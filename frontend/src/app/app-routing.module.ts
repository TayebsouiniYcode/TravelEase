import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HotelsComponent } from './pages/hotels/hotels.component';
import { CreateHotelComponent } from './pages/create-hotel/create-hotel.component';
import { DetailsHotelComponent } from './pages/details-hotel/details-hotel.component';

const routes: Routes = [
  { path: "dashboard" , component: DashboardComponent},
  { path: "hotels" , component: HotelsComponent},
  { path: "addhotel", component: CreateHotelComponent},
  { path: "detailshotel/:id", component: DetailsHotelComponent}
];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
