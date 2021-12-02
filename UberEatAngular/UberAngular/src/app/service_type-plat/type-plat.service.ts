import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TypePlatService {

  typeplats : Array<TypePlat> = new Array<TypePlat>();

  constructor() { }

  findAll(): Array<TypePlat> {
    return this.typeplats;
  }

  findById(id: number): TypePlat {
    for (let typeplat of this.typeplats) {
      if (typeplat.id == id) {
        return typeplat;
      }
    }
    return null;
  }

  create(typeplat: TypePlat) {
    let max = 0;
    for (let current of this.typeplats) {
      if (max < current.id) {
        max = current.id;
      }
    }
    typeplat.id = ++max;

    this.typeplats.push(typeplat);
  }

  modify(typeplat: TypePlat) {
    let find: boolean = false;
    for (var indice = 0; indice < this.typeplats.length; indice++) {
      if (this.typeplats[indice].id == typeplat.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.typeplats[indice] = typeplat;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.typeplats.length; indice++) {
      if (this.typeplats[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.typeplats.splice(indice, 1);
    }
  }
}