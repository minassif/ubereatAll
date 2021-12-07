import { Component, OnInit } from '@angular/core';
import { Commande } from '../model';
import { CommandesALivrerService } from './commandes-alivrer.service';

@Component({
  selector: 'app-commandes-alivrer',
  templateUrl: './commandes-alivrer.component.html',
  styleUrls: ['./commandes-alivrer.component.scss']
})
export class CommandesALivrerComponent implements OnInit {

  constructor(private commandesALivrerService:CommandesALivrerService) { }

  ngOnInit(): void {
  }

  list():Array<Commande>{
    return this.commandesALivrerService.findAllCommandes()
  }

  prendreCommande(commande:Commande){
    this.commandesALivrerService.prendreCommande(commande);
  }
}
