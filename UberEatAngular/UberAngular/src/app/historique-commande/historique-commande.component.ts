import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectService } from '../connect/connect.service';
import { Article, Commande } from '../model';
import { PanierService } from '../panier/panier.service';
import { HistoriqueCommandeService } from './historique-commande.service';

@Component({
  selector: 'app-historique-commande',
  templateUrl: './historique-commande.component.html',
  styleUrls: ['./historique-commande.component.scss']
})
export class HistoriqueCommandeComponent implements OnInit {

  //commandes:Array<Commande>;
  //articles:Array<Article>;
  statut:String;

  constructor(private historiqueCommandeService:HistoriqueCommandeService, private router:Router, public connectService:ConnectService) {
    if (connectService.utilisateur){
      if (connectService.utilisateur.statut==='client'){
        this.statut="client";
        this.historiqueCommandeService.loadClient() ;
      }
    if (connectService.utilisateur.statut==='restaurateur'){
      this.statut="restaurateur";
      this.historiqueCommandeService.loadRestaurateur() ;
      }
    if (connectService.utilisateur.statut==='livreur'){
      this.historiqueCommandeService.loadLivreur() ;
      this.statut="livreur";
      }
      
      
  }
  else{
    this.router.navigate(["/connect"]);
    }
    
   }
  

  ngOnInit(): void {
  }

  list(){
    return this.historiqueCommandeService.findCommandes();
  }

  setEnPrep(commande:Commande){
    commande.status='Preparation';
    this.historiqueCommandeService.saveCommande(commande);

  }

  setLivraison(commande:Commande){
    commande.status='Livraison';
    this.historiqueCommandeService.saveCommande(commande);
  }

  setLivree(commande:Commande){
    commande.status='livree';
    this.historiqueCommandeService.saveCommande(commande);
  }
  //loadArticleCommande(i:number){
    //this.historiqueCommandeService.loadArticle(i) ;
    //this.articles=this.historiqueCommandeService.articles;
    //return this.articles;
 // }

 detail(i:number){
  var div = document.getElementById(i.toString());
  if (div.style.display !== 'block') {
      div.style.display = 'block';
  }
  else {
      div.style.display = 'none';
 }
}
}
