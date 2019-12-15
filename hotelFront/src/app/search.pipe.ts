import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: "arrayFilter"
})
export class SearchPipe implements PipeTransform {

  transform(value:any[],searchString:string ){

    if(!searchString){
     
      return value  
    }

    return value.filter(it=>{   
        const groupName = it.name.toLowerCase().includes(searchString.toLowerCase())
        const region=it.neighbourhood_group.toLowerCase().includes(searchString.toLowerCase());
        return (groupName  );      
    }) 
 }


}
