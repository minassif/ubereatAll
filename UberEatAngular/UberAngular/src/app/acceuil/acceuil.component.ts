import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from '../model';
import { RechercheRestoService } from '../recherche-resto/recherche-resto.service';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.scss']
})
export class AcceuilComponent implements OnInit {

  
 



  constructor(private restaurantService:RestaurantService,private rechercheRestoService:RechercheRestoService, private router:Router) { }

  ngOnInit(): void {
  }

  setResto(id:number){
    this.rechercheRestoService.idRestoVisible=id;
    this.router.navigate(['/carteResto']);
  }

  listBestRates():Array<Restaurant>{
    let remove=this.restaurantService.findAllOrderByRate().length-3;
    this.restaurantService.findAllOrderByRate().splice(3,remove);
    return this.restaurantService.findAllOrderByRate()
  }



}
