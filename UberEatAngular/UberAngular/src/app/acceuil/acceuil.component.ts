import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.scss']
})
export class AcceuilComponent implements OnInit {

  
  slides:any=[[]];



  constructor(private restaurantService:RestaurantService) { }

  ngOnInit(): void {
    this.slides=this.chunk(this.listBestRates());
  }


  listBestRates():Array<Restaurant>{
    this.restaurantService.findAllOrderByRate().splice(2,(this.restaurantService.findAllOrderByRate().length-1));
    return this.restaurantService.findAllOrderByRate()
  }

chunk(arr:Array<Restaurant>) {
  let R= [];
  for (let i=0, len=arr.length; i<len; i+=3) {
    R.push(arr.slice(i, i+3));
  }
  return R;
}

}
