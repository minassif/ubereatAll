import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Restaurant} from '../model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  //types:Array<TypeResto>=[TypeResto.FastFood,TypeResto.Italienne,TypeResto.Asiatique,TypeResto.Latino,TypeResto.Halal,TypeResto.Vegetarien,TypeResto.Francais];

  types: Array<string> = new Array<string>();
  restaurants: Array<Restaurant> = new Array<Restaurant>();
  restaurantsOpen: Array<Restaurant> = new Array<Restaurant>();
  restaurantslivraisonGratuite: Array<Restaurant> = new Array<Restaurant>();
  restaurantslivraisonGratuiteOpen: Array<Restaurant> = new Array<Restaurant>();
  restaurantsByRate: Array<Restaurant> = new Array<Restaurant>();
  restaurantUrl: string;
  restaurantByTypeFastFood: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeItl: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeAsia: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeLat: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeHal: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeVeg: Array<Restaurant> = new Array<Restaurant>();
  restaurantByTypeFr: Array<Restaurant> = new Array<Restaurant>();
  retsurantByboolean: Array<Restaurant> = new Array<Restaurant>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.restaurantUrl = this.appConfig.backEndUrl + "restaurant/"
    this.load();
    this.loadTypes();

  }

  findAll(): Array<Restaurant> {
    return this.restaurants;
  }

  findAllType(): Array<string> {
    return this.types;
  }

  loadTypes() {
    this.appConfig.findAllTypesRestos().subscribe(resp => {
      this.types = resp
    }, err => console.log(err))
  }


  
  loadAllByTypes(open: boolean, livraison: boolean, emporter: boolean, stars: number, type: string,prixmin:number,prixmax:number) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + open + '/' + livraison + '/' + emporter + '/' + stars + '/' + type+'/'+prixmin+'/'+prixmax).subscribe(response => {
      this.restaurants = response;
    }, error => console.log(error));

  }
 


  loadAll(open: boolean, livraison: boolean, emporter: boolean, stars: number,prixmin:number,prixmax: number) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + open + '/' + livraison + '/' + emporter + '/' + stars +'/'+prixmin+'/'+prixmax).subscribe(response => {
      this.restaurants = response;
    }, error => console.log(error));
  }


  findAllOrderByRate(): Array<Restaurant> {
    return this.restaurantsByRate;
  }



  findById(id: number): Restaurant {
    for (let restaurant of this.restaurants) {
      if (restaurant.id == id) {
        return restaurant;
      }
    }
    return null;
  }

  create(restaurant: Restaurant) {
    let max = 0;
    for (let current of this.restaurants) {
      if (max < current.id) {
        max = current.id;
      }
    }
    restaurant.id = ++max;

    this.restaurants.push(restaurant);
  }

  modify(restaurant: Restaurant) {
    let find: boolean = false;
    for (var indice = 0; indice < this.restaurants.length; indice++) {
      if (this.restaurants[indice].id == restaurant.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.restaurants[indice] = restaurant;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.restaurants.length; indice++) {
      if (this.restaurants[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.restaurants.splice(indice, 1);
    }
  }


  load() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl).subscribe(response => {
      this.restaurants = response;
    }, error => console.log(error));
  }


}


