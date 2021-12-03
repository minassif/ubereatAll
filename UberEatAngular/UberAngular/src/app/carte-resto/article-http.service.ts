import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';

import { Article } from '../model';


@Injectable({
  providedIn: 'root'
})
export class ArticleHttpService {

  
  articles : Array<Article> = new Array<Article>();
  articleUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.articleUrl = this.appConfig.backEndUrl + "article/"
    this.load();

   }


   findAll(): Array<Article> {
    return this.articles ;
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
