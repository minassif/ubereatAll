import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  clients : Array<Client> = new Array<Client>();
  clientUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.clientUrl = this.appConfig.backEndUrl + "client/"
    this.load();

   }


   findAll(): Array<Client> {
    return this.clients;
  }

  findById(id: number): Observable<Client> {
    return this.http.get<Client>(this.clientUrl + id);
  }

  create(client : Client) {
    this.http.post<Client>(this.clientUrl, client).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(client: Client) {
    this.http.put<Client>(this.clientUrl + client.id, client).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.clientUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Client>>(this.clientUrl).subscribe(response => {
      this.clients = response;
    }, error => console.log(error));
  }
}
