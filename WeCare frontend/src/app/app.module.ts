import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { CoachLoginComponent } from './coach-login/coach-login.component';
import { CoachRegistrationComponent } from './coach-registration/coach-registration.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SuccessRegistrationComponent } from './success-registration/success-registration.component';
import { UserHomepComponent } from './user-homep/user-homep.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserProfilComponent } from './user-profil/user-profil.component';
import { UserBookComponent } from './user-book/user-book.component';
import { UserBookedComponent } from './user-booked/user-booked.component';
import { MyAppointmentComponent } from './my-appointment/my-appointment.component';
import { UserRebookComponent } from './user-rebook/user-rebook.component';
import { CoachProfilComponent } from './coach-profil/coach-profil.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserRegistrationComponent,
    UserLoginComponent,
    CoachLoginComponent,
    CoachRegistrationComponent,
    SuccessRegistrationComponent,
    UserHomepComponent,
    NavbarComponent,
    UserProfilComponent,
    UserBookComponent,
    UserBookedComponent,
    MyAppointmentComponent,
    UserRebookComponent,
    CoachProfilComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
