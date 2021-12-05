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
import { SidebarComponent } from './sidebar/sidebar.component';
import { ArticleService } from './article.service';
import { CommandeService } from './commande.service';
import { InfosUserComponent } from './infos-user/infos-user.component';
import { InfosRestoComponent } from './infos-resto/infos-resto.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnectComponent,
    AcceuilComponent,
    RechercheRestoComponent,
    CarteRestoComponent,
    PanierComponent,
    SidebarComponent,
    InfosUserComponent,
    InfosRestoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AppConfigService,ConnectService,AcceuilService,RechercheRestoService,CarteRestoService,ArticleService,CommandeService],
  bootstrap: [AppComponent]
})

export class AppModule { }
