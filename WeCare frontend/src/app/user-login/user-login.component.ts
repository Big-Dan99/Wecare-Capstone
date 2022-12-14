import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Login } from '../Classes/login';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private route: Router, private service: UserService) { }

  ngOnInit(): void {
  }

  login: Login = new Login();
  error: any;
  isValid! : boolean;

  public loginUser() {
    
      this.service.loginUser(this.login).subscribe(
        resp => this.handleSuccessfulResponse(resp, this.login.id)      
      )
    }
    handleSuccessfulResponse(resp: any, id : any){
      // resp = true;

      if(resp == true){
        this.route.navigate(['user-homep', id]);
        this.isValid= true;
        console.log(resp);
        console.log("credential is valid"); 
        
      }else{
        this.isValid = false;
        console.log(resp);       
        console.log(resp.message);
        console.log("false credential ");    
      }
     
    }

    // recupid(id : any){
    //   this.route.navigate(['/user-homep', id])
    // }


  }

  // username: string="";
  // password: string="";
  // isValid : boolean;
  // // error="username or password invalid ";
  

  // constructor( private route: Router) {}

  // ngOnInit(): void {
  // }
  // login(){
  //   if(this.username == "Big" && this.password=="Dan"){
  //     this.isValid = false;
  //     this.route.navigate(['home'])
  //   }else{
      
  //     this.isValid=true ;
  //   }
  // }

  // <div class="card-body bg-info">
  //           <div class="card-body bg-primary "  style="margin-left: 40px; width: 18rem; height: 150px; margin-top: -60px;">
  //               <h5 class="card-title">Welcome !!!</h5>
  //           </div><br><br>
  //           <p *ngIf="isValid" style="color: red;"> mdp ou nom d'utilisateur incorrect{{error}}</p>
  //           <label for="">Username</label><br>
  //           <input type="text" name="username" [(ngModel)]="username" class="form-control"  placeholder="Enter your username" id=""><br>
  //           <label for="">Password</label><br>
  //           <input type="password" class="form-control" name="password" [(ngModel)]="password" placeholder="Enter your password" id=""><br>
  //           <button (click)="login()" class="btn btn-primary">Login</button>


