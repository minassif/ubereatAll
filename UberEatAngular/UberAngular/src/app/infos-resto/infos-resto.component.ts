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
  
    }, err => console.log(err));
  }

  saveResto(){
    this.restaurant.articles=this.articles;
    this.infosRestoService.saveResto(this.restaurant);
  }

  addProduit(){
    this.articles.push(this.newArticle);
    this.newArticle=new Article();
  }


  goToBottom(){
    window.scrollTo(0,document.body.scrollHeight);
  }

}
