import { Component, OnInit } from '@angular/core';
import { ArticleHttpService } from '../article-http.service';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
  selector: 'app-carte-resto',
  templateUrl: './carte-resto.component.html',
  styleUrls: ['./carte-resto.component.scss']
})
export class CarteRestoComponent implements OnInit {

  constructor(private articleService:ArticleHttpService) { }

  ngOnInit(): void {
  }

}
