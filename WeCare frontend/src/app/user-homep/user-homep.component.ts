import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Coach } from '../Classes/coach';
import { User } from '../Classes/user';
import { CoachService } from '../Services/coach.service';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-user-homep',
  templateUrl: './user-homep.component.html',
  styleUrls: ['./user-homep.component.css']
})
export class UserHomepComponent implements OnInit {
  user : User[] =[];
 
id! : any;
cid! : any;
  constructor(private service: CoachService, private route : Router, private ar : ActivatedRoute) {}

  coaches! : Coach[];
  specialite! : any;
  ngOnInit(): void {
    this.allCoaches();
  }


allCoaches(){
    this.service.getAllCoach().subscribe(resp => {
      this.coaches = resp;
    }) 
  }

  Search(){
      if(this.specialite ==""){ 
        this.ngOnInit();
      }else{
        this.coaches=this.coaches.filter(cs => {
          return cs.speciality.toLocaleLowerCase().match(this.specialite.toLocaleLowerCase());
        })
      }
    }

 
   getuserprofile(){
    this.id = this.ar.snapshot.params['id'];
  this.route.navigate(['/user-profil', this.id])
}

bookuserappointment(cid : any){
  this.id = this.ar.snapshot.params['id'];
this.route.navigate(['/user-book', this.id, cid])
}

myAppointment(){
  this.id = this.ar.snapshot.params['id'];
  this.route.navigate(['/my-appointment', this.id])
}
userid= this.ar.snapshot.params['id'];
  

  // employees : any[];
  // fullName: string;

 

  // ngOnInit(): void {
  //   this.myEmployee();
  // }
  // myEmployee(){
  //   this.emp.getAllEmployee().subscribe(data => {
  //     this.employees = data.employees;
  //     console.log(this.employees);
  //   })
  // }
  // Search(){
  //   if(this.fullName ==""){ 
  //     this.ngOnInit();
  //   }else{
  //     this.employees=this.employees.filter(df => {
  //       return df.fullName.toLocaleLowerCase().match(this.fullName.toLocaleLowerCase());
  //     })
  //   }
  // }
}
