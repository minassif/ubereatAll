import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.scss']
})
export class AcceuilComponent implements OnInit {

  constructor(private restaurantService:RestaurantService) { }

  ngOnInit(): void {
  }


  listBestRates():Array<Restaurant>{
    let bestRates:Array<Restaurant> = new Array<Restaurant>();
    for(let i=0; i=1;i++){
      bestRates.push(this.restaurantService.findAllOrderByRate()[i])
    }
    return bestRates;
  }

}
