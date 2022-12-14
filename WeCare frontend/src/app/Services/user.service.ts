import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../Classes/login';
import { User } from '../Classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

       // registration
      createUser(user : User): Observable<any>{
        return this.http.post('http://localhost:8080/user/saveUser',user ); 
              
      }

      loginUser(login : Login){
        return this.http.post('http://localhost:8080/user/login',login ); 
      }

      // getProfile(){
      //   return this.http.get<User[]>('http://localhost:8080/user/usr/{userId}');
      // }

      public getUserProfile(id: any) : Observable<User>{
        return this.http.get<User>(`http://localhost:8080/user/usr/${id}`);
      }

      
      


      

   
  // getAll(): Observable<Tutorial[]> {
  //   return this.http.get<Tutorial[]>(baseUrl);
  // }

  // get(id: any): Observable<Tutorial> {
  //   return this.http.get(`${baseUrl}/${id}`);
  // }

  // create(data: any): Observable<any> {
  //   return this.http.post(baseUrl, data);
  // }

  // update(id: any, data: any): Observable<any> {
  //   return this.http.put(`${baseUrl}/${id}`, data);
  // }

  // delete(id: any): Observable<any> {
  //   return this.http.delete(`${baseUrl}/${id}`);
  // }

  // deleteAll(): Observable<any> {
  //   return this.http.delete(baseUrl);
  // }

  // findByTitle(title: any): Observable<Tutorial[]> {
  //   return this.http.get<Tutorial[]>(`${baseUrl}?title=${title}`);
  // }

}

