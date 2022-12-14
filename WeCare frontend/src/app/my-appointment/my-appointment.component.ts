import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Classes/booking';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-my-appointment',
  templateUrl: './my-appointment.component.html',
  styleUrls: ['./my-appointment.component.css']
})
export class MyAppointmentComponent implements OnInit {

  constructor(private bs : BookingService, private ar : ActivatedRoute, private route : Router) { }

  books! : Booking[];
  id! : any;
  ngOnInit(): void {
    this.showAppointment();
  }

  showAppointment(){
    this.id = this.ar.snapshot.params['id'];

    this.bs.getAllAppointment(this.id).subscribe(resp => {
      this.books = resp;
    }) 
  }

  rescheduleAppointment(bid : any){
    this.id = this.ar.snapshot.params['id'];
  this.route.navigate(['/user-rebook', bid, this.id])
  }

  public deleteAppointment(bid: any){
    
    this.bs.deleteAppointment(bid).subscribe((response) => {
      console.log(response);
    })

    this.reload();
  }

  forsure = false;
  delapp(){
      this.forsure =true;
  }

  reload(){
    window.location.reload();
  }

  getuserprofile(){
    this.id = this.ar.snapshot.params['id'];
  this.route.navigate(['/user-profil', this.id])
}

userid = this.ar.snapshot.params['id'];
}
