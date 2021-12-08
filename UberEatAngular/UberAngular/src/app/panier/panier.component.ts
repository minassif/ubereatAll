import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { ConnectService } from '../connect/connect.service';
import { Article, Client } from '../model';
import { ClientService } from '../service_client/client.service';
import { PanierService } from './panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

  panier:Array<Article>=new Array<Article>();
  client:Client=new Client();
  clicli:boolean=false;

  constructor(public connectService:ConnectService,private articleService:ArticleService,private panierService: PanierService,private clientService:ClientService) { 
    if(this.connectService.utilisateur){
      this.loadClient();
    }
  }

  ngOnInit(): void {
  }

  findClient(){
    return this.client
  }
  loadClient(){
    this.clientService.findById(this.connectService.utilisateur.id).subscribe(resp =>{
      this.client=resp;
    },err => console.log(err))
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
