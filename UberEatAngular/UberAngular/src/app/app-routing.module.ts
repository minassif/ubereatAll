import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { CarteRestoComponent } from './carte-resto/carte-resto.component';
import { ConnectComponent } from './connect/connect.component';
import { PanierComponent } from './panier/panier.component';
import { RechercheRestoComponent } from './recherche-resto/recherche-resto.component';

const routes: Routes = [
  { path: "accueil", component: AcceuilComponent },
  { path: "carteResto", component: CarteRestoComponent },
  { path: "rechercheResto", component: RechercheRestoComponent },
  { path: "connect", component: ConnectComponent },
  { path: "panier", component: PanierComponent },
  { path: "", redirectTo: '/accueil', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
