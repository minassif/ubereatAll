import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Restaurateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RestaurateurHttpService {
  
  restaurateurs : Array<Restaurateur> = new Array<Restaurateur>();
  restaurateurUrl : string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.restaurateurUrl  = this.appConfig.backEndUrl + "restaurateur/"
    this.load();

   }


   findAll(): Array<Restaurateur> {
    return this.restaurateurs;
  }

  findById(id: number): Observable<Restaurateur> {
    return this.http.get<Restaurateur>(this.restaurateurUrl  + id);
  }

  create(restaurateur: Restaurateur) {
    this.http.post<Restaurateur>(this.restaurateurUrl , restaurateur).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(restaurateur: Restaurateur) {
    this.http.put<Restaurateur>(this.restaurateurUrl  + restaurateur.id, restaurateur).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.restaurateurUrl  + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Restaurateur>>(this.restaurateurUrl ).subscribe(response => {
      this.restaurateurs = response;
    }, error => console.log(error));
  }

}
