import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { TypeResto } from '../model';

@Injectable({
  providedIn: 'root'
})
export class TypeRestoHttpService {

  typeRestos: Array<TypeResto> = new Array<TypeResto>();
  typeRestoUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.typeRestoUrl = this.appConfig.backEndUrl + "typeResto/"
    this.load();
  }

  findAll(): Array<TypeResto> {
    return this.typeRestos;
  }

  findById(id: number): Observable<TypeResto> {
    return this.http.get<TypeResto>(this.typeRestoUrl + id);
  }

  create(typeResto: TypeResto) {
    this.http.post<TypeResto>(this.typeRestoUrl, typeResto).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(typeResto: TypeResto) {
    this.http.put<TypeResto>(this.typeRestoUrl + typeResto.id, typeResto).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.typeRestoUrl+ id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<TypeResto>>(this.typeRestoUrl).subscribe(response => {
      this.typeRestos = response;
    }, error => console.log(error));
  }
}
