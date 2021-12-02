import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurateurService {

  restaurateurs : Array<Restaurateur> = new Array<Restaurateur>();

  constructor() { }

  findAll(): Array<Restaurateur> {
    return this.restaurateurs;
  }

  findById(id: number): Restaurateur {
    for (let restaurateur of this.restaurateurs) {
      if (restaurateur.id == id) {
        return restaurateur;
      }
    }
    return null;
  }

  create(restaurateur: Restaurateur) {
    let max = 0;
    for (let current of this.restaurateurs) {
      if (max < current.id) {
        max = current.id;
      }
    }
    restaurateur.id = ++max;

    this.restaurateurs.push(restaurateur);
  }

  modify(restaurateur: Restaurateur) {
    let find: boolean = false;
    for (var indice = 0; indice < this.restaurateurs.length; indice++) {
      if (this.restaurateurs[indice].id == restaurateur.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.restaurateurs[indice] = restaurateur;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.restaurateurs.length; indice++) {
      if (this.restaurateurs[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.restaurateurs.splice(indice, 1);
    }
  }
}