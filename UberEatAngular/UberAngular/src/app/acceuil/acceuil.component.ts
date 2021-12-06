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
    this.restaurantService.findAllOrderByRate().splice(2,(this.restaurantService.findAllOrderByRate().length-1));
    return this.restaurantService.findAllOrderByRate()
  }



}
