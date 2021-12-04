import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Client, Livreur, Restaurateur } from '../model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class InfosUserService {

  statut: string;
  userUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, public ConnectService: ConnectService,private router:Router) { 

    this.userUrl=this.appConfig.backEndUrl;

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

  createClient(client:Client) {
    this.http.post<Client>(this.userUrl + "client", client).subscribe(resp => {
      this.router.navigate(["/rechercheResto"]);},
      err => console.log(err));
  }

  createRestaurateur(restaurateur:Restaurateur) {
    this.http.post<Restaurateur>(this.userUrl + "restaurateur", restaurateur).subscribe(resp => {
      this.router.navigate(["/"]);},
      err => console.log(err));
  }

  createLivreur(livreur:Livreur) {
    this.http.post<Livreur>(this.userUrl + "livreur", livreur).subscribe(resp => {
      this.router.navigate(["/"]);},
      err => console.log(err));
  }

}
