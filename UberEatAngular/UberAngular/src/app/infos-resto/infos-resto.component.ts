import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Adresse, Article, Restaurant } from '../model';
import { InfosRestoService } from './infos-resto.service';

@Component({
  selector: 'app-infos-resto',
  templateUrl: './infos-resto.component.html',
  styleUrls: ['./infos-resto.component.scss']
})
export class InfosRestoComponent implements OnInit {

  restaurant: Restaurant;
  type: Array<String> = new Array<String>();
  typePlat: Array<String> = new Array<String>();
  articles: Array<Article>;
  newArticle:Article=new Article();
  
  idArticles: Array<number> = new Array<number>();

  constructor(private infosRestoService:InfosRestoService, private appConfig: AppConfigService,private connectService: ConnectService) { 
    this.loadType();
    this.loadTypePlat();
    this.editRestaurant(connectService.utilisateur.id);
    
    
  }

  ngOnInit(): void {
  }
  list(){
    this.articles=this.restaurant.articles;
    return this.articles;
  }

  loadType() {
    this.appConfig.findAllTypesRestos().subscribe(resp => {
      this.type = resp;
    }, err => console.log(err));
  }

  loadTypePlat() {
    this.appConfig.findAllTypesPlats().subscribe(resp => {
      this.typePlat = resp;
    }, err => console.log(err));
  }

  editRestaurant(id: number) {
    this.infosRestoService.findRestaurant(id).subscribe(resp=> {
      this.restaurant = resp;
      if (!this.restaurant.adresse) {
        this.restaurant.adresse = new Adresse();
      }
      if (!this.restaurant.articles) {
        this.restaurant.articles = new Array<Article>();
      }
      this.infosRestoService.loadArticle(this.restaurant);
  
    }, err => console.log(err));
  }

  saveResto(){
    this.restaurant.articles=new Array<Article>();
    this.articles.forEach(article => {
      article.restaurant=new Restaurant(this.restaurant.id);
      this.infosRestoService.saveArticle(article);
      this.restaurant.articles.push(new Article(article.id));
    });
    this.infosRestoService.saveResto(this.restaurant);
  }

  addProduit(){
    this.articles.push(this.newArticle);
    this.newArticle=new Article();
  }

  supProduit(id:number){
    let find: boolean = false;
    this.infosRestoService.deleteArticle(id);
    for (var indice = 0; indice < this.articles.length; indice++) {
      if (this.articles[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.articles.splice(indice, 1);
    }
    

  }
  


  goToBottom(){
    window.scrollTo(0,document.body.scrollHeight);
  }

}
