import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Restaurant, TypeResto } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  types:Array<TypeResto>=[TypeResto.FastFood,TypeResto.Italienne,TypeResto.Asiatique,TypeResto.Latino,TypeResto.Halal,TypeResto.Vegetarien,TypeResto.Francais];

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
    this.findOpen();
    this.findLivraisonGratuite();
    this.findLivraisonGratuiteOpen();
    this.loadByRate();
    this.findByTypeFastfood();
    this.findByTypeItl();
    this.findByTypeAsi();
    this.findByTypeLat();
    this.findByTypeHal();
    this.findByTypeVeg();
    this.findByTypeFr();

  }

  findAll(): Array<Restaurant> {
    return this.restaurants;
  }


  search(filtre: string) {
    if (filtre) {
      this.http.get<Array<Restaurant>>(this.restaurantUrl + "search/" + filtre).subscribe(response => {
        this.restaurants = response;
      }, error => console.log(error));
    } else {
      this.load();
    }
  }

  

  findByfilter(open: boolean, livraisongratuite: boolean, type: number): Array<Restaurant> {

    //this.restaurants.filter(resto => {})
    if (!type) {
      if (open == true && livraisongratuite == false)
        return this.restaurantsOpen;
      else if (open == false && livraisongratuite == true)
        return this.restaurantslivraisonGratuite;
      else if (open == true && livraisongratuite == true)
        return this.restaurantslivraisonGratuiteOpen;
      else
        return this.restaurants
    }
    else if (type == 1) {
      return this.restaurantByTypeFastFood;
    }
    else if (type == 2) {
      return this.restaurantByTypeItl;
    }
    else if (type == 3) {
      return this.restaurantByTypeAsia;
    }
    else if (type == 4) {
      return this.restaurantByTypeLat;
    }
    else if (type == 5) {
      return this.restaurantByTypeHal;
    }
    else if (type == 6) {
      return this.restaurantByTypeVeg;
    }
    else {
      return this.restaurantByTypeFr;

    }

  }


  findByTypeFastfood() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/1').subscribe(resp => {
      this.restaurantByTypeFastFood = resp;
    }, err => console.log(err));
  }



  findByTypeItl() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/2').subscribe(resp => {
      this.restaurantByTypeItl = resp;
    }, err => console.log(err));
  }



  findByTypeAsi() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/3').subscribe(resp => {
      this.restaurantByTypeAsia = resp;
    }, err => console.log(err));
  }


  findByTypeLat() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/4').subscribe(resp => {
      this.restaurantByTypeLat = resp;
    }, err => console.log(err));
  }


  findByTypeHal() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/5').subscribe(resp => {
      this.restaurantByTypeHal = resp;
    }, err => console.log(err));
  }

  findByTypeVeg() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/6').subscribe(resp => {
      this.restaurantByTypeVeg = resp;
    }, err => console.log(err));
  }

  findByTypeFr() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'typeResto/7').subscribe(resp => {
      this.restaurantByTypeFr = resp;
    }, err => console.log(err));
  }



  findOpen() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'open').subscribe(resp => {
      this.restaurantsOpen = resp;
    }, err => console.log(err));
  }

  findLivraisonGratuite() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'livraisongratuite').subscribe(resp => {
      this.restaurantslivraisonGratuite = resp;
    }, err => console.log(err));
  }
  findLivraisonGratuiteOpen() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + 'livraisongratuite/open').subscribe(resp => {
      this.restaurantslivraisonGratuiteOpen = resp;
    }, err => console.log(err));
  }

  findAllOrderByRate(): Array<Restaurant> {
    return this.restaurantsByRate;
  }


  findByCp(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/cp' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
  }

  findOpenCp(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/open/cp' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
  }

  findOpenCpExpensive(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/open/cp/expensive' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
  }

  findOpenCpLessExpensive(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/open/cp/lessexpensive' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
  }
  findOpenCpLessCheap(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/open/cp/lesscheap' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
  }

  findOpenCpCheap(cp: string) {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/open/cp/cheap' + "/" + cp).subscribe(resp => {
      return resp;
    }, err => console.log(err));
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

  loadByRate() {
    this.http.get<Array<Restaurant>>(this.restaurantUrl + '/orderByRate').subscribe(response => {
      this.restaurantsByRate = response;
    }, error => console.log(error));
  }


  loadByAll(open: boolean, livraison: boolean, emporter: boolean, stars:number) {

      this.http.get<Array<Restaurant>>(this.restaurantUrl + open+'/'+livraison+'/'+emporter+'/'+stars).subscribe(response => {
        this.restaurants = response;
      }, error => console.log(error));


  }

  loadByAllBYType(open: boolean, livraison: boolean, emporter: boolean, stars:number,type:TypeResto): void{
    this.http.get<Array<Restaurant>>(this.restaurantUrl + open+'/'+livraison+'/'+emporter+'/'+stars+'/'+type).subscribe(response => {
      this.restaurants = response;
    }, error => console.log(error));
  }


}