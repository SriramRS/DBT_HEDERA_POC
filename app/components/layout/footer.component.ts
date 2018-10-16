import { Component,OnInit } from '@angular/core';  
import { Router }  from '@angular/router';
@Component ({  
   selector: 'footer-div',  
   templateUrl: 'footer.html',
  })  

export class AppFooter implements OnInit  { 
  user={} ;
  constructor(private _router: Router){} 
  ngOnInit(){
   
}
}