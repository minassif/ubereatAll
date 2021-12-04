import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client, ConnectDTO } from '../model';
import { ConnectService } from './connect.service';

@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.scss']
})
export class ConnectComponent implements OnInit {

  connectForm: ConnectDTO = new ConnectDTO();
  errorLogin: String;

  constructor(private connectService:ConnectService, private router:Router) { }

  ngOnInit(): void {
  }

  login() {
    this.connectService.connexion(this.connectForm).subscribe(resp => {
      this.connectService.utilisateur = resp;
      this.errorLogin = null;
      if(resp.statut=="client"){
        this.router.navigate(["/rechercheResto"]);
      }
      else if(resp.statut=="restaurateur"){
        this.router.navigate(["/restaurateur"]);
      }
      else if(resp.statut=="livreur"){
        this.router.navigate(["/livreur"]);
      }
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogin = "Identifiant incorrect !"
      }
    });
  }


}
