import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectService } from '../connect/connect.service';
import { Adresse, Client, Livreur, Restaurant, Restaurateur } from '../model';
import { InfosUserService } from './infos-user.service';

@Component({
  selector: 'app-infos-user',
  templateUrl: './infos-user.component.html',
  styleUrls: ['./infos-user.component.scss']
})
export class InfosUserComponent implements OnInit {

  statut: string;
  client: Client;
  restaurateur: Restaurateur;
  livreur: Livreur;
  constructor(private infosUserService:InfosUserService, private router:Router, private connectService:ConnectService) {
    if (connectService.utilisateur){
      if (connectService.utilisateur.statut=='client'){
      this.statut=connectService.utilisateur.statut ;
      this.editClient(connectService.utilisateur.id);
    }
    if (connectService.utilisateur.statut=='restaurateur'){
      this.statut=connectService.utilisateur.statut ;
      this.editRestaurateur(connectService.utilisateur.id);
    }
    if (connectService.utilisateur.statut=='livreur'){
      this.statut=connectService.utilisateur.statut ;
      this.editLivreur(connectService.utilisateur.id);
    }
  }

  else{
      this.client=new Client();
      this.client.adresse=new Adresse();
      this.restaurateur=new Restaurateur();
      this.livreur=new Livreur();
    }
    
   }

  ngOnInit(): void {
  }

  editClient(id: number) {
    this.infosUserService.findClient(id).subscribe(resp => {
      this.client = resp;
      if (!this.client.adresse) {
        this.client.adresse = new Adresse();
      }
    }, err => console.log(err));
  }

  editRestaurateur(id: number) {
    this.infosUserService.findRestaurateur(id).subscribe(resp => {
      this.restaurateur = resp;
      
    }, err => console.log(err));
  }
  
  editLivreur(id: number) {
    this.infosUserService.findLivreur(id).subscribe(resp => {
      this.livreur = resp;
      
    }, err => console.log(err));
  }
  
  saveClient(){
    this.client.statut=this.statut;
    this.infosUserService.createClient(this.client);
  }


  saveRestaurateur(){
    this.restaurateur.statut=this.statut;
    this.infosUserService.createRestaurateur(this.restaurateur);
  }

  saveLivreur(){
    this.livreur.statut=this.statut;
    this.infosUserService.createLivreur(this.livreur);
  }

}
