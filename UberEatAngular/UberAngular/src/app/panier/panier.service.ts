import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router} from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Article, Client, Commande } from '../model';
import { ClientService } from '../service_client/client.service';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  commande:Commande=new Commande();
  panier:Array<Article>=new Array<Article>();
  prixPanier:number=0;
  client:Client=new Client();

  constructor(private http: HttpClient,private appConfig:AppConfigService, private router:Router,private connectService:ConnectService,private clientService:ClientService) { 
    this.loadClient();
  }

  show():Array<Article>{
    return this.panier
  }

  add(article:Article){
    this.setPrix(article.prix);
    this.panier.push(article)
  }

  delete(index:number){
    this.setPrix(-this.panier[index].prix);
    this.panier.splice(index,1);
  }

  setPrix(prixArticle:number){
    this.prixPanier+=prixArticle;
  }

  validerCommande(panier:Array<Article>){
    this.commande.prix=this.prixPanier;
    this.commande.articles=this.panier;
    this.commande.client=this.client;
    this.commande.restaurant=this.panier[0].restaurant;
    this.commande.status='Enregistre';
    this.saveCommande(this.commande);
    this.commande=null;
    this.panier=null;
    this.prixPanier=0;
  }

  saveCommande(commande : Commande) {
    this.http.post<Commande>(this.appConfig.backEndUrl+'commande/', commande).subscribe(resp => {
      this.router.navigate(['/mesCommandes']);
    }, error => console.log(error));
  }

  loadClient(){
    this.clientService.findById(this.connectService.utilisateur.id).subscribe(resp =>{
      this.client=resp;
    },err => console.log(err))
  }

  
}
