import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../Classes/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http : HttpClient) { }

  // public createPhone(phone: Phone): Observable<Object>{
  //   return this.http.post(`${this.Url}`, phone);
  // }


  // const myheader = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
  // let body = new HttpParams();
  // body = body.set('username', slot);
  // body = body.set('password', PASSWORD);
  // http
  //   .post('/api', body, {
  //     headers: myheader),
  //   })
  //   .subscribe();

  public bookAppointment( booking : Booking, userid: any, coachid : any) : Observable<Object>{
    let param = new HttpParams();
    param = param.set('slot', booking.slot);
    param = param.set('appointmentDate', booking.appointmentDate);

    return this.http.post(`http://localhost:8080/book/users/${userid}/booking/${coachid}`, param, {responseType: 'json'});
  }


  public rebookAppointment( booking : Booking, bookid: any) : Observable<Object>{
    let param = new HttpParams();
    param = param.set('slot', booking.slot);
    param = param.set('appointmentDate', booking.appointmentDate);

    return this.http.put(`http://localhost:8080/book/reschedule/${bookid}`, param, {responseType: 'json'});
  }
  
  
  public deleteAppointment(bid: any): Observable<Booking> {
    return this.http.delete<Booking>(`http://localhost:8080/book/delete/${bid}`);
  }

  // public deletePhone(id: number) : Observable<Phone>{
  //   return this.http.delete<Phone>(`${this.Url}/${id}`);
  // }


  // public showAppointment(id: any) : Observable<Booking>{
  //   return this.http.get<Booking>(`http://localhost:8080/user/usr/appointments/${id}`);
  // }

  getAllAppointment(id : any){

    return this.http.get<Booking[]>(`http://localhost:8080/user/usr/appointments/${id}`);
      
  }
  // /booking/{coachId}

  getAllSchedule(id : any){

    return this.http.get<Booking[]>(`http://localhost:8080/coaches/booking/${id}`);
      
  }

}
