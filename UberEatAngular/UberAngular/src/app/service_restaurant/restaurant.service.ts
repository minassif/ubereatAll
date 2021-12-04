import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  restaurants: Array<Restaurant> = new Array<Restaurant>();
  restaurantsByRate: Array<Restaurant> = new Array<Restaurant>();
  restaurantUrl: string;

  constructor(private http:HttpClient , private appConfig:AppConfigService ) { 
    this.restaurantUrl=this.appConfig.backEndUrl + "restaurant/"
    this.load();
    this.loadByRate();
  }

  findAll(): Array<Restaurant> {
    return this.restaurants;
  }

  findAllOrderByRate():Array<Restaurant>{
    return this.restaurantsByRate;
  }
  
  findByType(type:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/typeResto' + '/' + type).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findOpen(){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open').subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findByCp(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/cp'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findOpenCp(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open/cp'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findOpenCpExpensive(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open/cp/expensive'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findOpenCpLessExpensive(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open/cp/lessexpensive'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }
  findOpenCpLessCheap(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open/cp/lesscheap'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
  }

  findOpenCpCheap(cp:string){
    this.http.get<Array<Restaurant>>(this.restaurantUrl+'/open/cp/cheap'+"/"+cp).subscribe(resp =>{
      return resp;
    },err => console.log(err));
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
}