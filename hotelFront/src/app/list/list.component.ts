import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  list:any=[];
  region:any[];
  searchString:String;
  constructor(private hotelService:HotelService) { 

    this.hotelService.getList().subscribe(
      data=>{
      this.list=data;
      
      }
    )
  
  }

  ngOnInit() {
    
  }


  onSortLow(){
    this.list.sort((a: any, b: any) => {
      if (a.price < b.price) {
        return -1;
      } else if (a.price > b.price) {
        return 1;
      } else {
        return 0;
      }
    });
  }

  onSortHigh(){
    this.list.sort((a: any, b: any) => {
      if (a.price < b.price) {
        return 1;
      } else if (a.price > b.price) {
        return -1;
      } else {
        return 0;
      }
    });
    
  }
  onFilter(region){
    this.list=this.list.filter(element => {
      return element.neighbourhood_group === "North Region";
     
    });

  }

 
}


