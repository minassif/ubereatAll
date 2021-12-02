import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ConnectDTO, Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ConnectService {

  utilisateurUrl: string;
  utilisateur: Utilisateur;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.utilisateurUrl = this.appConfig.backEndUrl + "utilisateur/"
  }

  connexion(connect: ConnectDTO): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(this.utilisateurUrl + "connect", connect);
  }

  deconnexion() {
    this.utilisateur = null;
  }
}
