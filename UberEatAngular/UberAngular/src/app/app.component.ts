import { Component } from '@angular/core';
import { ConnectService } from './connect/connect.service';
import { Utilisateur } from './model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'UberAngular';

  constructor(public ConnectService: ConnectService) {
  }


  deconnexion() {
    this.ConnectService.deconnexion();
  }
}
