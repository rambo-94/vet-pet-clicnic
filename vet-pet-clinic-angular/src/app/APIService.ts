import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';



const apiUrl1 = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})

export class APIService {


  constructor(public client: HttpClient) {
   }

  public getVets(): Observable<any> {

    return this.client.get(apiUrl1 + 'vets');
   }

  public getAllOwners(): Observable<any> {

    return this.client.get(apiUrl1 + 'owners');

   }
}
