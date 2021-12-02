import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TypeRestoService {

  typerestos : Array<TypeResto> = new Array<TypeResto>();

  constructor() { }

  findAll(): Array<TypeResto> {
    return this.typerestos;
  }

  findById(id: number): TypeResto {
    for (let typeresto of this.typerestos) {
      if (typeresto.id == id) {
        return typeresto;
      }
    }
    return null;
  }

  create(typeresto: TypeResto) {
    let max = 0;
    for (let current of this.typerestos) {
      if (max < current.id) {
        max = current.id;
      }
    }
    typeresto.id = ++max;

    this.typerestos.push(typeresto);
  }

  modify(typeresto: TypeResto) {
    let find: boolean = false;
    for (var indice = 0; indice < this.typerestos.length; indice++) {
      if (this.typerestos[indice].id == typeresto.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.typerestos[indice] = typeresto;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.typerestos.length; indice++) {
      if (this.typerestos[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.typerestos.splice(indice, 1);
    }
  }
}