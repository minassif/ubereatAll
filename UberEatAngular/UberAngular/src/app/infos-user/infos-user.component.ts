import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  constructor(private infosUserService:InfosUserService, private router:Router) {

    this.client=new Client();
    this.client.adresse=new Adresse();
    this.restaurateur=new Restaurateur();
    this.livreur=new Livreur();
   }

  ngOnInit(): void {
  }

  
  saveClient(){
    this.infosUserService.createClient(this.client);
  }


  saveRestaurateur(){
    this.infosUserService.createRestaurateur(this.restaurateur);
  }

  saveLivreur(){
    this.infosUserService.createLivreur(this.livreur);
  }

}
