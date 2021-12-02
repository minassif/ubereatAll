import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { TypePlat } from '../model';

@Injectable({
  providedIn: 'root'
})
export class TypePlatHttpService {

  typePlats: Array<TypePlat> = new Array<TypePlat>();
  typePLatUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.typePLatUrl = this.appConfig.backEndUrl + "typePlat/"
    this.load();
  }

  findAll(): Array<TypePlat> {
    return this.typePlats;
  }

  findById(id: number): Observable<TypePlat> {
    return this.http.get<TypePlat>(this.typePLatUrl + id);
  }

  create(typePlat: TypePlat) {
    this.http.post<TypePlat>(this.typePLatUrl, typePlat).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(typePlat: TypePlat) {
    this.http.put<TypePlat>(this.typePLatUrl + typePlat.id, typePlat).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.typePLatUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<TypePlat>>(this.typePLatUrl).subscribe(response => {
      this.typePlats = response;
    }, error => console.log(error));
  }
}
