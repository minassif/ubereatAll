import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurant } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Injectable({
  providedIn: 'root'
})
export class RechercheRestoService {

  idRestoVisible:number ;
  
  constructor() { }

  setResto(id:number){
    this.idRestoVisible=id;
  }


}
