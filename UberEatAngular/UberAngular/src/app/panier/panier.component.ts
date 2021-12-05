import { Component, OnInit } from '@angular/core';
import { ConnectService } from '../connect/connect.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

  constructor(private connectService:ConnectService) { }

  ngOnInit(): void {
  }

  

}
