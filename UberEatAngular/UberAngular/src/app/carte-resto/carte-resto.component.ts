import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
  selector: 'app-carte-resto',
  templateUrl: './carte-resto.component.html',
  styleUrls: ['./carte-resto.component.scss']
})
export class CarteRestoComponent implements OnInit {

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
