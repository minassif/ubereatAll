import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  restaurants: Array<Restaurant> = new Array<Restaurant>();

  constructor() { }

  findAll(): Array<Restaurant> {
    return this.restaurants;
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
}