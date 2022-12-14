import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../Classes/coach';
import { Login } from '../Classes/login';

@Injectable({
  providedIn: 'root'
})
export class CoachService {

  constructor(private http: HttpClient) { }

  // registration coach
  createUser(coach : Coach): Observable<any>{
    return this.http.post('http://localhost:8080/coaches/saveCoach', coach );         
  }

  // Login coach
  loginUser(login : Login){
    return this.http.post('http://localhost:8080/coaches/login',login ); 
  }

  // get list coach
  getAllCoach(){

    return this.http.get<Coach[]>('http://localhost:8080/coaches/allcoach');
      
  }

  public getCoachProfile(id: any) : Observable<Coach>{
    return this.http.get<Coach>(`http://localhost:8080/coaches/coach/${id}`);
  }

  // getAll(): Observable<Tutorial[]> {
  //   return this.http.get<Tutorial[]>(baseUrl);
  // }

}
