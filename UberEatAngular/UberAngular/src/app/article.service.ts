import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { ConnectService } from './connect/connect.service';

import { Article } from './model';
import { RechercheRestoService } from './recherche-resto/recherche-resto.service';
import { RestaurantService } from './service_restaurant/restaurant.service';


@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  entrees : Array<Article> = new Array<Article>();
  plats : Array<Article> = new Array<Article>();
  desserts : Array<Article> = new Array<Article>();
  boissons : Array<Article> = new Array<Article>();
  articles : Array<Article> = new Array<Article>();
  articleUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService,private restaurantService:RestaurantService,private rechercheRestoService:RechercheRestoService) {
    this.articleUrl = this.appConfig.backEndUrl + "article/"
    this.load();
    this.loadEntrees();
    this.loadPlats();
    this.loadDesserts();
    this.loadBoissons();

   }

   findAll(): Array<Article> {
    return this.articles ;
  }
  
  findEntrees(): Array<Article> {
    return this.entrees ;
  }
  findPlats(): Array<Article> {
    return this.plats ;
  }
  findDesserts(): Array<Article> {
    return this.desserts ;
  }
  findBoissons(): Array<Article> {
    return this.boissons ;
  }


  loadArticle(id:number){
  this.http.get<Array<Article>>(this.appConfig.backEndUrl +"article/restaurantId/" + id).subscribe(resp => {
    this.articles=resp;
  }, error => console.log(error));
  }


  loadEntrees(){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/Entree').subscribe(resp =>{
      this.entrees=resp;
    },err => console.log(err));
  }

  loadPlats(){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/Plat').subscribe(resp =>{
      this.plats=resp;
    },err => console.log(err));
  }

  loadDesserts(){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/Dessert').subscribe(resp =>{
      this.desserts=resp;
    },err => console.log(err));
  }

  loadBoissons(){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/Boisson').subscribe(resp =>{
      this.boissons=resp;
    },err => console.log(err));
  }
  

  findVegetarien(vegetarien:boolean){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/' + vegetarien).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findById(id: number): Observable<Article> {
    return this.http.get<Article>(this.articleUrl + id);
  }

  create(article : Article) {
    this.http.post<Article>(this.articleUrl, article).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(article: Article) {
    this.http.put<Article>(this.articleUrl + article.id, article).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.articleUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Article>>(this.articleUrl).subscribe(response => {
      this.articles = response;
    }, error => console.log(error));
  }
}
