import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../Classes/login';
import { CoachService } from '../Services/coach.service';

@Component({
  selector: 'app-coach-login',
  templateUrl: './coach-login.component.html',
  styleUrls: ['./coach-login.component.css']
})
export class CoachLoginComponent implements OnInit {

  constructor(private route: Router, private service: CoachService) { }

  ngOnInit(): void {
  }

  login: Login = new Login();
  error:any; 
  isValid! : boolean;

  public loginCoach() {
    
      this.service.loginUser(this.login).subscribe(
        resp => this.handleSuccessfulResponse(resp, this.login.id)      
        
      )
    }
    handleSuccessfulResponse(resp: any ,  id : any){
      // resp = true;
      if(resp == true){
        this.isValid= true;
        this.route.navigate(['success-registration', id]);
        console.log(resp);
        console.log("credential is valid"); 
      }else{
        this.isValid = false;
        console.log(resp);
        console.log(resp.message);
        console.log("false credential ");       
      }
     
    }
}
