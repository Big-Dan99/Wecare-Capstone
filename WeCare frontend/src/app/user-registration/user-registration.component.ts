import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../Classes/user';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  submitted = false;

  constructor(private  service : UserService,private r : Router) { }

  ngOnInit(): void {
  }


  user: User = new User();
  
 
public saveUser(){
  this.submitted = true;
  this.service.createUser(this.user).subscribe(
    (response) => { 
      alert("User save succesfully");
      
     
      console.log(response);
      // this.r.navigate(['/success-registration']);
    },
    error => {
      this.handleErrorResponse(error);
        
    }
  )
}
Resp : any;
mob = "^[1-9]{1}[0-9]{9}$";
pin= "^[1-9]{1}[0-9]{5}$";
mail="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
handleErrorResponse(error: any){
  this.Resp = error.error.text
  console.log(error.error);
  console.log(error.error.text);
  
}

nowlogin(){
  this.r.navigate(['/user-login']);
}



}
