import {Component, OnInit} from '@angular/core';
import { Router }  from '@angular/router';
import { Location } from '@angular/common';

import { DataService } from './services/data.service';

@Component ({
   selector: 'app',
   templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {
  constructor(private _router: Router,private location: Location,private dataService: DataService){}
  ngOnInit(){
    let user = sessionStorage.getItem("user");
    if (!user) {
      this._router.navigate(['/DBT/login']);
    }

   }
 }
