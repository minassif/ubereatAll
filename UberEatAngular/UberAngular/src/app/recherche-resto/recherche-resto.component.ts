import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Article } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-recherche-resto',
  templateUrl: './recherche-resto.component.html',
  styleUrls: ['./recherche-resto.component.scss']
})
export class RechercheRestoComponent implements OnInit {



  constructor(private restoService : RestaurantService) { }
 

  ngOnInit(): void {
  }
  
  listRestoByType(type:string){
    return this.restoService.findByType(type);
  }
  
  listOpen(){
    return this.restoService.findOpen();
  }

  listByCp(cp:string){
    return this.restoService.findByCp(cp);

  }

}
