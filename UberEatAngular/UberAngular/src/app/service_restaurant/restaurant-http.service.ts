import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Restaurant} from './model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantHttpService {

  reataurants : Array<Restaurant> = new Array<Restaurant>();
  restaurantUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.restaurantUrl = this.appConfig.backEndUrl + "restaurant/"
    this.load();

   }


   findAll(): Array<Restaurant> {
    return this.reataurants ;
  }

  findById(id: number): Observable<Restaurant> {
    return this.http.get<Restaurant>(this.restaurantUrl + id);
  }

  create(retaurant : Restaurant) {
    this.http.post<Restaurant>(this.restaurantUrl, retaurant).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(retaurant: Restaurant) {
    this.http.put<Restaurant>(this.restaurantUrl + retaurant.id, retaurant).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.restaurantUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl).subscribe(response => {
      this.reataurants = response;
    }, error => console.log(error));
  }


}
