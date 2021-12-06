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

  
  articles : Array<Article> = new Array<Article>();
  articleUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService,private restaurantService:RestaurantService,private rechercheRestoService:RechercheRestoService) {
    this.articleUrl = this.appConfig.backEndUrl + "article/"
    this.load();

   }

   findAll(): Array<Article> {
    return this.articles ;
  }

  loadArticle(id:number):Observable<Array<Article>>{
  return this.http.get<Array<Article>>(this.appConfig.backEndUrl +"article/restaurantId/" + id)
  }


  findByType(type:string){
    this.http.get<Array<Article>>(this.articleUrl+ 'restaurantId/' + this.rechercheRestoService.idRestoVisible + '/' + type).subscribe(resp =>{
      return resp;
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
