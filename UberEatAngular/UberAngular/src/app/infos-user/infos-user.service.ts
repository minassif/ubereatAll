import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Client } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InfosUserService {

  statut: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, public ConnectService: ConnectService) { 
    if (ConnectService.utilisateur){
     if (ConnectService.utilisateur.statut ==='client'){
       this.statut='client';
      }
     else if (ConnectService.utilisateur.statut ==='restaurateur'){
       this.statut='restaurateur';
      }
     else if (ConnectService.utilisateur.statut ==='livreur'){
        this.statut='livreur';
      }
    }
  }

  createClient(client:Client): Observable<Client> {
    return this.http.post<Client>(this.http + "client", client);
  }

}
