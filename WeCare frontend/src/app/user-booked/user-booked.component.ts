import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-booked',
  templateUrl: './user-booked.component.html',
  styleUrls: ['./user-booked.component.css']
})
export class UserBookedComponent implements OnInit {

  id! : any;
  constructor(private ar: ActivatedRoute, private route : Router) { }

  ngOnInit(): void {
  }

  goBack(){
    this.id = this.ar.snapshot.params['id'];

    this.route.navigate(['user-homep', this.id]);
  }

}
