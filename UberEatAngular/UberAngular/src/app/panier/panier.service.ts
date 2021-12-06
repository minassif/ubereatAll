import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  panier:Array<Article>=null;

  constructor(private http: HttpClient) { }

  add(article:Article){
    this.panier.push(article)
  }
}
