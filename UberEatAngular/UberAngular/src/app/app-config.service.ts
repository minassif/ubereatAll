import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AppConfigService {

  backEndUrl: string = "http://localhost:8080/";

  constructor(private http: HttpClient) { }


  findAllTransport(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "transports");
  }

  findAllStatus(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "status");
  }
  findAllTypesRestos(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typesRestos");
  }

  findAllTypesPlats(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "typesPlats");
  }


}


