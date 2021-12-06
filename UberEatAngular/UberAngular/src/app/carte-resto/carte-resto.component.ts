import { Component, OnInit } from '@angular/core';
import { Article } from '../model';
import { ArticleService } from '../article.service';
import { PanierService } from '../panier/panier.service';

@Component({
  selector: 'app-carte-resto',
  templateUrl: './carte-resto.component.html',
  styleUrls: ['./carte-resto.component.scss']
})
export class CarteRestoComponent implements OnInit {

  articles: Array<Article> = new Array<Article>();

  constructor(private articleService:ArticleService,private panierService:PanierService) { }

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

  listPanier():Array<Article>{
    return this.panierService.show()
  }

  addPanier(article:Article){
    this.panierService.add(article);
  }

  removePanier(article:Article){
    let find: boolean = false;
    for (var indice = 0; indice < this.panierService.panier.length; indice++) {
      if (this.panierService.panier[indice].id == article.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.panierService.panier.splice(indice, 1);
  }}
}
