import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../model';
import { InfosUserService } from './infos-user.service';

@Component({
  selector: 'app-infos-user',
  templateUrl: './infos-user.component.html',
  styleUrls: ['./infos-user.component.scss']
})
export class InfosUserComponent implements OnInit {

  statut: string;
  client: Client;
  constructor(private infosUserService:InfosUserService, private router:Router) { }

  ngOnInit(): void {
  }

  initClient(){
    this.client=new Client;
  }
  saveClient(){
    this.infosUserService.createClient(this.client)
  }
}
