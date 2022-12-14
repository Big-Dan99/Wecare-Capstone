import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coach } from '../Classes/coach';
import { CoachService } from '../Services/coach.service';

@Component({
  selector: 'app-coach-registration',
  templateUrl: './coach-registration.component.html',
  styleUrls: ['./coach-registration.component.css']
})
export class CoachRegistrationComponent implements OnInit {

  constructor(private  service : CoachService,private r : Router) { }

  ngOnInit(): void {
  }
  submitted = false;
  coach: Coach = new Coach();
  
  mob = "^[1-9]{1}[0-9]{9}$";
public saveCoach(){
  this.submitted = true;
  this.service.createUser(this.coach).subscribe(
    (response) => { 
      alert("Coach save succesfully");
      
     
      console.log(response);
      // this.r.navigate(['/success-registration']);
    },
    error => {
      this.handleErrorResponse(error);
        
    }
  )
}
Resp : any;

handleErrorResponse(error: any){
  this.Resp = error.error.text
  console.log(error.error);
  console.log(error.error.text);
  
}

nowlogin(){
  this.r.navigate(['/coach-login']);
}


}
