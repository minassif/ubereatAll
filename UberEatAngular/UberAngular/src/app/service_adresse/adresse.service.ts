import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdresseService {
  adresses: Array<Adresse> = new Array<Adresse>();

  constructor() { }

  findAll(): Array<Adresse> {
    return this.adresses;
  }

  findById(id: number): Adresse {
    for (let adresse of this.adresses) {
      if (adresse.id == id) {
        return adresse;
      }
    }
    return null;
  }

  create(adresse: Adresse) {
    let max = 0;
    for (let current of this.adresses) {
      if (max < current.id) {
        max = current.id;
      }
    }
    adresse.id = ++max;

    this.adresses.push(adresse);
  }

  modify(adresse: Adresse) {
    let find: boolean = false;
    for (var indice = 0; indice < this.adresses.length; indice++) {
      if (this.adresses[indice].id == adresse.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.adresses[indice] = adresse;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.adresses.length; indice++) {
      if (this.adresses[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.adresses.splice(indice, 1);
    }
  }
}
