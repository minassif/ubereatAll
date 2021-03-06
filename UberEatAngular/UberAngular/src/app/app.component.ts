import { Component, HostListener } from '@angular/core';
import { ConnectService } from './connect/connect.service';
import { Utilisateur } from './model';
import { PanierService } from './panier/panier.service';

//declare const window: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'UberAngular';
  navbartopColor:String;

  @HostListener("window:scroll", ['$event'])
  onWindowScroll(e:Event) {
    const number = this.getYPosition(e);
    if (number <20 ) {
      this.navbartopColor="#8e8b8a00";
    } else  {
      this.navbartopColor="#bda8a8cf";
    }
  }

  constructor(public ConnectService: ConnectService,public panierService:PanierService) {
  }


  deconnexion() {
    this.ConnectService.deconnexion();
  }

  getYPosition(e: Event): number {
    return window.pageYOffset;
  }

  
  
}
