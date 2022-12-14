import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../Classes/booking';
import { BookingService } from '../Services/booking.service';

@Component({
  selector: 'app-user-book',
  templateUrl: './user-book.component.html',
  styleUrls: ['./user-book.component.css']
})
export class UserBookComponent implements OnInit {

  constructor(private bs : BookingService, private route: Router, private ar: ActivatedRoute) { }

  booking : Booking = new Booking();
  userid! : any;
  coachid : any;
mess! : boolean;



  ngOnInit(): void {
    // this.minmaxd();
    console.log(this.today ,this.lday);
    

  }

  today= new Date().toJSON().split('T')[0];
  curr = new Date();
  first = this.curr.getDate() + 7;
   lday= new Date(this.curr.setDate(this.first)).toJSON().split('T')[0];

  // date1:any;
  // date2:any;
  // mindate:any;
  // maxdate:any;
  // minmaxd(){
  //   this.date2 = new Date().toJSON().split('T')[0];
  //   this.date1 = new Date().toJSON().split('T')[0];

  //   this.mindate = this.date1;
  //   this.maxdate = this.date2;

  //   console.log(
  //     this.mindate,
  //     this.maxdate
  //   );
    

  // }

 
    

 public bookingAppointment(){
    this.userid = this.ar.snapshot.params['id'];
    this.coachid = this.ar.snapshot.params['cid'];
    
      this.bs.bookAppointment(this.booking,this.userid, this.coachid).subscribe(
        resp => this.handleSuccessfulresp(resp)      
      )
        
      // this.route.navigate(['user-booked'])
  } 

  handleSuccessfulresp(resp : any){
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
  

  // constructor(private us: UserService, private ar : ActivatedRoute) { }

  // ngOnInit(): void {
  //  this.getDetails();
  
  // }

  // public getDetails(){
  //   // this.id = this.ar.snapshot.params['id'];
  //   // // this.phones= new Phone();
  //   // this.ps.getPhoneById(this.id).subscribe(response =>{
  //   //   this.phone = response;
  //   // })

  //   this.id = this.ar.snapshot.params['id'];
    
  //   this.us.getUserProfile(this.id).subscribe(response =>{
  //     this.user = response;
  //   })
  // }
}
