import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WebService } from '../../services/web.service';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'header-div',
  templateUrl: 'header.html',
  providers: [WebService]
})

export class AppHeader implements OnInit {
  user: { userNamel: string; } = { userNamel: "" };
  constructor(private _router: Router, private webService: WebService, private dataService: DataService) { }
  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    // this.user = this.dataService.user;
    // if (!this.user) {
    //   this._router.navigate(['/login']);
    // }
  }
  logout(): void {
    sessionStorage['user'] = null;
    this._router.navigate(['/DBT/login']);

  }
}
