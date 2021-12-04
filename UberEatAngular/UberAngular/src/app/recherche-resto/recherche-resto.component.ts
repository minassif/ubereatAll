import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { Article, Restaurant } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-recherche-resto',
  templateUrl: './recherche-resto.component.html',
  styleUrls: ['./recherche-resto.component.scss']
})
export class RechercheRestoComponent implements OnInit {


  filtre: string;

  constructor(private restoService: RestaurantService) { }


  ngOnInit(): void {
  }

  list(): Array<Restaurant> {
    return this.restoService.findAll();
  }

  search($event: any) {
    this.filtre = $event;
    this.restoService.search(this.filtre);
  }

  listRestoByType(type: string) {
    return this.restoService.findByType(type);
  }

  listOpen() {
    return this.restoService.findOpen();
  }

  listByCp(cp: string) {
    return this.restoService.findByCp(cp);

  }

  listOpenCp(cp: string) {
    return this.restoService.findOpenCp(cp);
  }


  listOpenCpExpensive(cp: string) {
    return this.restoService.findOpenCpExpensive(cp);
  }

  listOpenCpLessExpensive(cp: string) {
    return this.restoService.findOpenCpLessExpensive(cp);
  }


  listOpenCpLessCheap(cp: string) {
    return this.restoService.findOpenCpLessCheap(cp);
  }
  listOpenCpCheap(cp: string) {
    return this.restoService.findOpenCpCheap(cp);
  }

}
