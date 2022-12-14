import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { User } from '../Classes/user';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-user-profil',
  templateUrl: './user-profil.component.html',
  styleUrls: ['./user-profil.component.css']
})
export class UserProfilComponent implements OnInit {

  user : User = new User();
id! : number;


  constructor(private us: UserService, private ar : ActivatedRoute) { }

  ngOnInit(): void {
   this.getDetails();
  
  }

  public getDetails(){
   

    this.id = this.ar.snapshot.params['id'];
    
    this.us.getUserProfile(this.id).subscribe(response =>{
      this.user = response;
    })
  }

  userid = this.ar.snapshot.params['id'];

}
