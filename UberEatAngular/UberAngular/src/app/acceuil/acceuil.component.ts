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
    let remove=this.restaurantService.findAllOrderByRate().length-3;
    this.restaurantService.findAllOrderByRate().splice(3,remove);
    return this.restaurantService.findAllOrderByRate()
  }



}
