import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  clients: Array<Client> = new Array<Client>();

  constructor() { }

  findAll(): Array<Client> {
    return this.clients;
  }

  findById(id: number): Client {
    for (let client of this.clients) {
      if (client.id == id) {
        return client;
      }
    }
    return null;
  }

  create(client: Client) {
    let max = 0;
    for (let current of this.clients) {
      if (max < current.id) {
        max = current.id;
      }
    }
    client.id = ++max;

    this.clients.push(client);
  }

  modify(client: Client) {
    let find: boolean = false;
    for (var indice = 0; indice < this.clients.length; indice++) {
      if (this.clients[indice].id == client.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.clients[indice] = client;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.clients.length; indice++) {
      if (this.clients[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.clients.splice(indice, 1);
    }
  }
}
