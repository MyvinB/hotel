import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HotelService {
  ServiceEndpoint:string = "http://localhost:8080/api";
  constructor(private http: HttpClient) { }

  getList()
  {
    const url =this.ServiceEndpoint+"/list"; 
    return this.http.get(url);
  }
}
