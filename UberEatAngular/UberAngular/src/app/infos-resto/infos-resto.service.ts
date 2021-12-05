import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ConnectService } from '../connect/connect.service';
import { Restaurant } from '../model';

@Injectable({
  providedIn: 'root'
})
export class InfosRestoService {

  userUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private connectService: ConnectService,private router:Router) {
    this.userUrl=this.appConfig.backEndUrl+"restaurant/";
   }


  findRestaurant(id: number): Observable<Restaurant>{
    return this.http.get<Restaurant>(this.userUrl + "monResto/"+id)
  }

  saveResto(restaurant:Restaurant){
    this.http.put<Restaurant>(this.userUrl + restaurant.id, restaurant).subscribe(resp => {
      this.router.navigate(["/accueil"]);},
      err => console.log(err));
  }
}
