import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Coach } from '../Classes/coach';
import { CoachService } from '../Services/coach.service';

@Component({
  selector: 'app-coach-profil',
  templateUrl: './coach-profil.component.html',
  styleUrls: ['./coach-profil.component.css']
})
export class CoachProfilComponent implements OnInit {

  coach : Coach = new Coach();
  id! : number;
  
  
    constructor(private cs: CoachService, private ar : ActivatedRoute) { }
  
    ngOnInit(): void {
     this.getDetails();
    
    }
  
    public getDetails(){
     
  
      this.id = this.ar.snapshot.params['id'];
      
      this.cs.getCoachProfile(this.id).subscribe(response =>{
        this.coach = response;
      })
    }

}
