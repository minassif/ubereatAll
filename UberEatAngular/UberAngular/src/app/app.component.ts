import { Component, HostListener } from '@angular/core';
import { ConnectService } from './connect/connect.service';
import { Utilisateur } from './model';

declare const window: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'UberAngular';
  navbartopColor:String;

  constructor(public ConnectService: ConnectService) {
  }


  deconnexion() {
    this.ConnectService.deconnexion();
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    //const number = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    if (document.documentElement.scrollTop <10 ) {
      this.navbartopColor="8e8b8a00";
    } else  {
      this.navbartopColor="grey";
    }

  }
}
