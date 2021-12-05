import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Adresse, Restaurant } from '../model';
import { InfosRestoService } from './infos-resto.service';

@Component({
  selector: 'app-infos-resto',
  templateUrl: './infos-resto.component.html',
  styleUrls: ['./infos-resto.component.scss']
})
export class InfosRestoComponent implements OnInit {

  restaurant: Restaurant;
  type: Array<String> = new Array<String>();

  constructor(private infosRestoService:InfosRestoService, private appConfig: AppConfigService,private connectService: ConnectService) { 
    this.loadType();
    this.editRestaurant(connectService.utilisateur.id);
  }

  ngOnInit(): void {
  }

  loadType() {
    this.appConfig.findAllTypesRestos().subscribe(resp => {
      this.type = resp;
    }, err => console.log(err));
  }

  editRestaurant(id: number) {
    this.infosRestoService.findRestaurant(id).subscribe(resp=> {
      this.restaurant = resp;
      if (!this.restaurant.adresse) {
        this.restaurant.adresse = new Adresse();
      }
    }, err => console.log(err));
  }

  saveResto(){
    this.infosRestoService.saveResto(this.restaurant);
  }

}
