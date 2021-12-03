import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Article } from '../model';

@Component({
  selector: 'app-recherche-resto',
  templateUrl: './recherche-resto.component.html',
  styleUrls: ['./recherche-resto.component.scss']
})
export class RechercheRestoComponent implements OnInit {

  constructor(private articleService:ArticleService) { }

  ngOnInit(): void {
  }

  listArticleByType(type:string){
    return this.articleService.findByType(type);
  }

  listArticleVege(vege:boolean){
    return this.articleService.findVegetarien(vege);
  }

}
