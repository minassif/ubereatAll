import { Component, OnInit, Type } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ArticleService } from '../article.service';
import { Article, Restaurant } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-recherche-resto',
  templateUrl: './recherche-resto.component.html',
  styleUrls: ['./recherche-resto.component.scss']
})
export class RechercheRestoComponent implements OnInit {


  open: boolean = true;
  livraison: boolean = true;
  emporter: boolean = true;
  type: string = null;
  // type : TypeResto =null;
  // fastFood:number=null;
  stars: number = 1;
  price: number = null;
  prixmin: number = 0;
  prixmax: number = 100;

  types: Array<string> = new Array<string>();




  /*
    lesscheap: boolean = false;
    cheap: boolean = false;
    lessexpensive:  boolean = false;
    expensive: boolean = false;
  */
  filtre: string;
  ouvert: boolean=true;

  constructor(private restoService: RestaurantService, private appConfigService: AppConfigService) { }


  ngOnInit(): void {
  }

  setType(type: string) {
    this.type = type;
    this.reload();
  }

  list(): Array<Restaurant> {
    if(this.ouvert){
      return this.restoService.findOpen();
    }
    else{
    return this.restoService.findAll();
    }
  }

  listTypeResto(): Array<string> {
    return this.restoService.findAllType()
  }

  superiorAt(pricerange:number,max:number):boolean{
    if (pricerange>max){
      return true
    }
    else{
      return false
    }
  }

  inferiorAt(pricerange:number,max:number):boolean{
    if (pricerange>max){
      return false
    }
    else{
      return true
    }
  }

  reload() {
    if (!this.type)
      this.restoService.loadAll(this.open, this.livraison, this.emporter, this.stars, this.prixmin, this.prixmax);
    else {

      this.restoService.loadAllByTypes(this.open, this.livraison, this.emporter, this.stars, this.type, this.prixmin, this.prixmax);
    }
  }

  resetRate() {
    this.stars = 0;
    this.prixmax = 100;
    this.prixmin=0;
    this.reload();
  }

  Alltypes() {
    this.type = null;
   // this.stars = 0;
  //this.prixmax = 100;
  //this.prixmin=0;
    this.reload();
  }


}
