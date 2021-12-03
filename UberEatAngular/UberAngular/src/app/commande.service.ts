import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Commande } from './model';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

 
  commandes : Array<Commande> = new Array<Commande>();
  commandeUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.commandeUrl = this.appConfig.backEndUrl + "commande/"
    this.load();

   }


   findAll(): Array<Commande> {
    return this.commandes ;
  }

  findById(id: number): Observable<Commande> {
    return this.http.get<Commande>(this.commandeUrl + id);
  }

  create(commande : Commande) {
    this.http.post<Commande>(this.commandeUrl, commande).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(commande: Commande) {
    this.http.put<Commande>(this.commandeUrl + commande.id, commande).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.commandeUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Commande>>(this.commandeUrl).subscribe(response => {
      this.commandes = response;
    }, error => console.log(error));
  }

}
