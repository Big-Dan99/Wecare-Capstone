import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoachLoginComponent } from './coach-login/coach-login.component';
import { CoachProfilComponent } from './coach-profil/coach-profil.component';
import { CoachRegistrationComponent } from './coach-registration/coach-registration.component';
import { HomeComponent } from './home/home.component';
import { MyAppointmentComponent } from './my-appointment/my-appointment.component';
import { SuccessRegistrationComponent } from './success-registration/success-registration.component';
import { UserBookComponent } from './user-book/user-book.component';
import { UserBookedComponent } from './user-booked/user-booked.component';
import { UserHomepComponent } from './user-homep/user-homep.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserProfilComponent } from './user-profil/user-profil.component';
import { UserRebookComponent } from './user-rebook/user-rebook.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
  {path: 'home',component: HomeComponent },
  {path: 'success-registration/:id',component:  SuccessRegistrationComponent},
  {path: 'coach-login',component:  CoachLoginComponent},
  {path: 'coach-registration',component:  CoachRegistrationComponent},
  {path: 'user-login',component:  UserLoginComponent},
  {path: 'user-booked/:id',component:  UserBookedComponent},
  {path: 'my-appointment/:id',component:  MyAppointmentComponent},
  {path: 'user-profil/:id',component:  UserProfilComponent},
  {path: 'coach-profil/:id',component:  CoachProfilComponent},
  {path: 'user-homep/:id',component:  UserHomepComponent},
  {path: 'user-rebook/:bid/:id',component:  UserRebookComponent},
  {path: 'user-book/:id/:cid',component:  UserBookComponent},
  {path: 'user-registration',component:  UserRegistrationComponent},
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'**', redirectTo:'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// import { NgModule } from '@angular/core';
// import { RouterModule, Routes } from '@angular/router';
// import { WelcomeComponent } from './welcome/welcome.component';

// const routes: Routes = [
//   {path: 'welcome',component: WelcomeComponent },
//   {path:'', redirectTo:'welcome', pathMatch:'full'},
//   {path:'**', redirectTo:'welcome'}
// ];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
