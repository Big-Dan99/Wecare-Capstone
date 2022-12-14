import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Classes/booking';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-user-rebook',
  templateUrl: './user-rebook.component.html',
  styleUrls: ['./user-rebook.component.css']
})
export class UserRebookComponent implements OnInit {

  constructor(private bs : BookingService, private route: Router, private ar: ActivatedRoute) { }

  booking : Booking = new Booking();
  bookid! : any;
  userid : any;
  mess! : boolean;



  ngOnInit(): void {

  }

  today= new Date().toJSON().split('T')[0];
  curr = new Date();
  first = this.curr.getDate() + 7;
   lday= new Date(this.curr.setDate(this.first)).toJSON().split('T')[0];

 public rebookingAppointment(){
    this.bookid = this.ar.snapshot.params['bid'];
    
      this.bs.rebookAppointment(this.booking,this.bookid).subscribe(
        resp => this.handleSuccessfulresp(resp)      
      )
      // this.route.navigate(['user-booked'])
  }

  handleSuccessfulresp(resp : any){
    this.userid = this.ar.snapshot.params['id'];
    if(resp == true){
      this.route.navigate(['/user-booked', this.userid]);
      // this.mess = true;
      console.log(resp);
      console.log("valid");
      
    }else{
      
      console.log(resp);
      console.log("invalid appointment");
      this.mess = false;

    }

}
}
