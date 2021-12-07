import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Article, Client, Commande, Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class HistoriqueCommandeService {
  
  url:String;
  commandes:Array<Commande>;
  restaurant:Restaurant;
  articles:Array<Article>;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService,public connectService:ConnectService, private router:Router) {
    
    this.url=this.appConfig.backEndUrl+"commande/";
    
  
  }
  
  
  
  loadClient() {
    this.http.get<Array<Commande>>(this.url+"client/"+this.connectService.utilisateur.id).subscribe(response => {
      this.commandes = response;
      console.log(this.commandes);
    }, error => console.log(error));
  }
  
  loadLivreur() {
    this.http.get<Array<Commande>>(this.url+"livreur/"+this.connectService.utilisateur.id).subscribe(response => {
      this.commandes = response;
    }, error => console.log(error));
  }
  
  loadRestaurateur() {
    this.http.get<Restaurant>(this.appConfig.backEndUrl+"restaurant/monResto/"+this.connectService.utilisateur.id).subscribe(response => {
      this.restaurant = response;
      this.loadRestaurant();
      
    }, error => console.log(error));
    
  }
  
  loadRestaurant(){
    console.log(this.restaurant);
    this.http.get<Array<Commande>>(this.url+"restaurant/"+this.restaurant.id).subscribe(response => {
      this.commandes = response;
    }, error => console.log(error));
  }
  
  loadArticle(id:number) {
    this.http.get<Array<Article>>(this.appConfig.backEndUrl+"article/commandeId/"+id).subscribe(response => {
      this.articles = response;
    }, error => console.log(error));
  }
  
  findCommandes():Array<Commande>{
    return this.commandes;
  }
}
