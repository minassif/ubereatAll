import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppConfigService } from './app-config.service';
import { ConnectComponent } from './connect/connect.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { RechercheRestoComponent } from './recherche-resto/recherche-resto.component';
import { CarteRestoComponent } from './carte-resto/carte-resto.component';
import { PanierComponent } from './panier/panier.component';
import { ConnectService } from './connect/connect.service';
import { AcceuilService } from './acceuil/acceuil.service';
import { RechercheRestoService } from './recherche-resto/recherche-resto.service';
import { CarteRestoService } from './carte-resto/carte-resto.service';

@NgModule({
  declarations: [
    AppComponent,
    ConnectComponent,
    AcceuilComponent,
    RechercheRestoComponent,
    CarteRestoComponent,
    PanierComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AppConfigService,ConnectService,AcceuilService,RechercheRestoService,CarteRestoService],
  bootstrap: [AppComponent]
})

export class AppModule { }
