import { Component, OnInit, Type } from '@angular/core';
import { ArticleService } from '../article.service';
import { Article, Restaurant, TypeResto } from '../model';
import { RestaurantService } from '../service_restaurant/restaurant.service';

@Component({
  selector: 'app-recherche-resto',
  templateUrl: './recherche-resto.component.html',
  styleUrls: ['./recherche-resto.component.scss']
})
export class RechercheRestoComponent implements OnInit {

 
  open: boolean = false;
  livraison:boolean =false;
  emporter: boolean = false;
  type : number=null;
 // fastFood:number=null;
  stars:number=1;
  price:number=null;

  


/*
  lesscheap: boolean = false;
  cheap: boolean = false;
  lessexpensive:  boolean = false;
  expensive: boolean = false;
*/
  filtre: string;

  constructor(private restoService: RestaurantService) { }


  ngOnInit(): void {
  }

  list(): Array<Restaurant> {
    return this.restoService.findAll();
  }

  listTypes(): Array<TypeResto>{
    return this.restoService.types
  }

  search($event: any) {
    this.filtre = $event;
    this.restoService.search(this.filtre);
  }

  reloadType(t:number){
    this.setType(t);
    this.reload();
  }

  setType(t:number){
    this.type=t;
  }

  resetType(){
    this.type=null;
    this.reload();
  }
  reload() {
    if(!this.type){
      console.log(this.type);
    this.restoService.loadByAll(this.open,this.livraison,this.emporter,this.stars);
  }
  else{
    console.log(this.type);
    this.restoService.loadByAllBYType(this.open,this.livraison,this.emporter,this.stars,this.type);
  }
  }
/*
  listfilter(): Array<Restaurant>{
  return this.restoService.findByfilter(this.open, this.livraisongratuite, this.type);
  }
*/

  listOpen() {
    return this.restoService.findOpen();
  }

  listByCp(cp: string) {
    return this.restoService.findByCp(cp);

  }

  listOpenCp(cp: string) {
    return this.restoService.findOpenCp(cp);
  }


  listOpenCpExpensive(cp: string) {
    return this.restoService.findOpenCpExpensive(cp);
  }

  listOpenCpLessExpensive(cp: string) {
    return this.restoService.findOpenCpLessExpensive(cp);
  }


  listOpenCpLessCheap(cp: string) {
    return this.restoService.findOpenCpLessCheap(cp);
  }
  listOpenCpCheap(cp: string) {
    return this.restoService.findOpenCpCheap(cp);
  }

  resetRate(){
    this.stars=0;
  }
 
  Alltypes(){
    this.type=null;
  }

  fastfood(){
    console.log(this.type)
    this.type=TypeResto.FastFood;
    console.log(this.type)
  }

  italian(){
    this.type=TypeResto.Italienne;
  }
  
  asiatique(){
    this.type=TypeResto.Asiatique;
  }

  latino(){
    this.type=TypeResto.Latino;
  }

  halal(){
    this.type=TypeResto.Halal;
  }

  vegetariene(){
    this.type=TypeResto.Vegetarien;
  }
  francais(){
    this.type=TypeResto.Francais;
  }

listfilterAll():Array<Restaurant>{
 this.restoService.loadByAll(this.open,this.livraison,this.emporter,this.stars);
 return this.restoService.restaurants;
}


}
