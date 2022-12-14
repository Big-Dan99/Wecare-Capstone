import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor( private r : Router) { }

  ngOnInit(): void {
  }

  userProfil(id:number){
    this.r.navigate(['/user-profil', id])
  }

}
