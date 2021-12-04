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

  userUrl: string;
  id:number;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService, private connectService: ConnectService,private router:Router) { 

    this.userUrl=this.appConfig.backEndUrl;
    if (this.connectService.utilisateur){
     this.id=this.connectService.utilisateur.id;
    }
  }

  findClient(id: number): Observable<Client>{
    return this.http.get<Client>(this.userUrl + "client/adresse/"+id)
  }

  findLivreur(id: number): Observable<Livreur>{
    return this.http.get<Livreur>(this.userUrl + "livreur/"+id)
  }

  findRestaurateur(id: number): Observable<Restaurateur>{
    return this.http.get<Restaurateur>(this.userUrl + "restaurateur/"+id)
  }

  createClient(client:Client) {
    if (this.connectService.utilisateur){
      this.http.put<Client>(this.userUrl + "client/"+client.id, client).subscribe(resp => {
        this.router.navigate(["/accueil"]);},
        err => console.log(err));
    }
    else{
    this.http.post<Client>(this.userUrl + "client", client).subscribe(resp => {
      this.router.navigate(["/accueil"]);},
      err => console.log(err));}
  }

  createRestaurateur(restaurateur:Restaurateur) {
    if (this.connectService.utilisateur){
      this.http.put<Restaurateur>(this.userUrl + "restaurateur/"+restaurateur.id, restaurateur).subscribe(resp => {
        this.router.navigate(["/accueil"]);},
        err => console.log(err));
    }
    else{
    this.http.post<Restaurateur>(this.userUrl + "restaurateur", restaurateur).subscribe(resp => {
      this.router.navigate(["/accueil"]);},
      err => console.log(err));
  }}

  createLivreur(livreur:Livreur) {
    if (this.connectService.utilisateur){
      this.http.put<Livreur>(this.userUrl + "livreur/"+livreur.id, livreur).subscribe(resp => {
        this.router.navigate(["/accueil"]);},
        err => console.log(err));
    }
    else{
    this.http.post<Livreur>(this.userUrl + "livreur", livreur).subscribe(resp => {
      this.router.navigate(["/accueil"]);},
      err => console.log(err));
  }}

}
