import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Classes/booking';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-success-registration',
  templateUrl: './success-registration.component.html',
  styleUrls: ['./success-registration.component.css']
})
export class SuccessRegistrationComponent implements OnInit {

  constructor(private bs : BookingService, private ar : ActivatedRoute, private route : Router) { }

  books! : Booking[];
  id! : any;
  ngOnInit(): void {
    this.showAppointment();
  }

  showAppointment(){
    this.id = this.ar.snapshot.params['id'];

    this.bs.getAllSchedule(this.id).subscribe(resp => {
      this.books = resp;
    }) 
  }

  
  // display = this.books.length>0;
  // display! : boolean;
  // handleResp(resp : any){
  //   if(resp == null){
  //     this.display=true;
  //   }else{
  //     this.display=false;
  //   }
  // }

  // reload(){
  //   window.location.reload();
  // }
  // reload = window.location.reload();
  
  getcoachprofile(){
    this.id = this.ar.snapshot.params['id'];
  this.route.navigate(['/coach-profil', this.id])
}
coachid = this.ar.snapshot.params['id'];

}
