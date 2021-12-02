import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConnectDTO } from '../model';
import { ConnectService } from './connect.service';

@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.scss']
})
export class ConnectComponent implements OnInit {

  connectForm: ConnectDTO = new ConnectDTO();
  errorLogin: String;

  constructor(private connectService:ConnectService) { }

  ngOnInit(): void {
  }

  login() {
    this.connectService.connexion(this.connectForm).subscribe(resp => {
      this.connectService.utilisateur = resp;
      this.errorLogin = null;
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogin = "Identifiant incorrect !"
      }
    });
  }
}
