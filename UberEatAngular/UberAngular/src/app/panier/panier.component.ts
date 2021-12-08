import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { ConnectService } from '../connect/connect.service';
import { Article, Client } from '../model';
import { PanierService } from './panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

  panier:Array<Article>=new Array<Article>();
  client:Client=new Client();
  clicli:boolean;

  constructor(private connectService:ConnectService,private articleService:ArticleService,private panierService: PanierService) { 
    this.connected();
  }

  ngOnInit(): void {
  }

  findClient(){
    return this.client
  }

  connected(){
    if(this.connectService.utilisateur){
      this.panierService.loadClient();
      this.client=this.panierService.client;
      this.clicli= true
    }
    else{
      this.clicli= false
    }
  }

   showPanier():Array<Article>{
     return this.panierService.panier
   }

   delete(index:number){
    this.panierService.delete(index);
  }

  validerCommande(){
    this.panierService.validerCommande(this.panierService.panier)
  }
  
}
