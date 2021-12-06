import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { ConnectService } from '../connect/connect.service';
import { Article } from '../model';
import { PanierService } from './panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

  panier:Array<Article>=new Array<Article>();

  constructor(private connectService:ConnectService,private articleService:ArticleService,private panierService: PanierService) { }

  ngOnInit(): void {
  }

  // showPanier():Array<Article>{
  //   return this.panierService.panier
  // }

  validerCommande(){
    
  }
  
}
