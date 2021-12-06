import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  panier:Array<Article>=new Array<Article>();

  constructor(private http: HttpClient) { }

  add(article:Article){
    this.panier.push(article)
  }

  delete(index:number){
    this.panier.splice(index,1);
  }

  validerCommande(panier:Array<Article>){
    
  }
}
