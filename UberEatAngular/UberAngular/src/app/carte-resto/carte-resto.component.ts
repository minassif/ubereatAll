import { Component, OnInit } from '@angular/core';
import { ArticleHttpService } from '../article-http.service';
import { Article } from '../model';
import { ArticleService } from '../article.service';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
  selector: 'app-carte-resto',
  templateUrl: './carte-resto.component.html',
  styleUrls: ['./carte-resto.component.scss']
})
export class CarteRestoComponent implements OnInit {

  article: Array<Article> = new Array<Article>();

  constructor(private articleService:ArticleHttpService) { }

  ngOnInit(): void {
  }
  
  listArticleByType(type:string){
    return this.articleService.findByType(type);
  }

  list(): Array<Article> {
    return this.articleService.findAll();
  }
  listArticleVege(vege:boolean){
    return this.articleService.findVegetarien(vege);
  }
}
