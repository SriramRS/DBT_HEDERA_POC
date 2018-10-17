import { Component, OnInit, transition,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { DataService } from '../../services/data.service';
import {MatTableDataSource} from '@angular/material';
declare var $: any;




@Component({
    selector: 'login-app',
    templateUrl: 'home.html',
    styleUrls: ['home.component.css'],

})

export class AppHome implements OnInit {
    constructor(private _router: Router, private _http: Http, private dataService: DataService) { }

    public rowSelected:number;
    ngOnInit() {

    }

}
