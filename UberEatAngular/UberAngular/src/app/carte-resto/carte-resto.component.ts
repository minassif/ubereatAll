
import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';


import { Article } from '../model';
import { ArticleHttpService } from './article-http.service';

@Component({
  selector: 'app-carte-resto',
  templateUrl: './carte-resto.component.html',
  styleUrls: ['./carte-resto.component.scss']
})
export class CarteRestoComponent implements OnInit {

articleForm : Article =null;
typesPLats : Array<String> = new Array<String>();

constructor(private appConfig: AppConfigService, private articleService: ArticleHttpService){

}
  ngOnInit(): void {
  }

  list(): Array<Article> {
    return this.articleService.findAll()
  }


  loadTypesPlats(){
    this.appConfig.findAllTypesPlats().subscribe(resp =>{
      this.typesPLats=resp;
    },err =>console.log(err))
  }

add(){
  this.articleForm=new Article()
}



edit(id: number) {
  this.articleService.findById(id).subscribe(resp => {
    this.articleForm = resp;
  }, err => console.log(err));
}

save() {
  

  if (!this.articleForm.id) {
    this.articleService.create(this.articleForm);
  } else {
    this.articleService.modify(this.articleForm);
  }
  this.articleForm = null;
}

cancel() {
  this.articleForm = null;
}

delete(id: number) {
  this.articleService.deleteById(id);
}



}
