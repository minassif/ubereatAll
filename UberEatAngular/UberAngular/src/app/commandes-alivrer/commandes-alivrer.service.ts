import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Commande, Livreur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CommandesALivrerService {

  commandesALivrer:Array<Commande>=new Array<Commande>();
  commandesUrl:string;
  livreurUrl:string;
  livreur:Livreur;

  constructor(private appConfig:AppConfigService, private http:HttpClient, private connectService:ConnectService,private router:Router) { 
    this.commandesUrl=this.appConfig.backEndUrl + 'commande/aLivrer';
    this.livreurUrl=this.appConfig.backEndUrl + 'livreur';
    this.load();
    this.loadLivreur();
  }


  findAllCommandes():Array<Commande>{
    return this.commandesALivrer
  }

  findLivreur(){
    return this.livreur
  }

  load(){
    this.http.get<Array<Commande>>(this.commandesUrl).subscribe(resp => {
      this.commandesALivrer=resp;
    },err => console.log(err))
  }

  loadLivreur() {
    this.http.get<Livreur>(this.livreurUrl+this.connectService.utilisateur.id).subscribe(response => {
      this.livreur = response;
    }, error => console.log(error));
  }

  prendreCommande(commande:Commande){
    commande.livreur=this.livreur;
    this.saveCommande(commande);
  }

  saveCommande(commande : Commande) {
    this.http.put<Commande>(this.appConfig.backEndUrl+'commande'+commande.id, commande).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
}
