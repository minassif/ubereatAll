import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Article, Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class InfosRestoService {

  userUrl: string;
  articles:Array<number>=new Array<number>();

  constructor(private http: HttpClient, private appConfig: AppConfigService, private connectService: ConnectService,private router:Router) {
    this.userUrl=this.appConfig.backEndUrl+"restaurant/";
    
   }


  findRestaurant(id: number): Observable<Restaurant>{
    return this.http.get<Restaurant>(this.userUrl + "monResto/"+id)
  }

  saveResto(restaurant:Restaurant){
    this.http.put<Restaurant>(this.userUrl + restaurant.id, restaurant).subscribe(resp => {
      this.router.navigate(["/accueil"]);},
      err => console.log(err));
  }

  loadArticle(restaurant:Restaurant){
    this.http.get<Array<Article>>(this.appConfig.backEndUrl +"article/restaurantId/" + restaurant.id,).subscribe(resp => {
      resp.forEach(article => {
        this.articles.push(article.id);
      });;},
      err => console.log(err));

  }

  saveArticle(article:Article){
    if (this.articles.indexOf(article.id) >-1){
      this.http.put<Article>(this.appConfig.backEndUrl +"article/" + article.id, article).subscribe(resp => {
        console.log("article sauvegardé");},
        err => console.log(err));
    }
    else{
      this.http.post<Article>(this.appConfig.backEndUrl +"article/", article).subscribe(resp => {
        console.log("article créé");},
        err => console.log(err));

    }
    
  }
}
