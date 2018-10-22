import { Component, OnInit, HostBinding, transition } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { DataService } from '../../services/data.service';
import { WebService } from '../../services/web.service';
import { OverlayContainer} from '@angular/cdk/overlay';

@Component({
    selector: 'app-login',
    templateUrl: 'login.html',
    providers: [WebService]
})

export class AppLogin implements OnInit {
    constructor(private _router: Router, private _http: Http, private dataService: DataService,private webService: WebService,  public overlayContainer: OverlayContainer) { }
      @HostBinding('class') componentCssClass;
      error = {
      "userNamel":"",
      "passwordl":"",
      "chainType":""
      }
      user={
        "userNamel":"",
        "passwordl":"",
        "chainType":""
      }
     users:any=[];
     userDetails:any=[];
     userTypes:any = [];
     loginStatus:Boolean = false;
     isUserValid=true;
     blockchains = {};
    objectKeys(obj) {
       return Object.keys(obj);
    }

    ngOnInit() {
        this.dataService.user=null;
        this.webService.getJSON().subscribe(item => {
          this.userDetails = item;
            for(let item of this.userDetails) {
              this.userTypes.push(item.userType);
            }
            console.log(this.userTypes);
        });
    }

    login(): void {
      this.validateUser();
      if(this.isUserValid) {
          this.webService.getJSON().subscribe(item => {
            this.users = item;
            for(let item of this.users) {
                if(item.userName==this.user.userNamel && item.password==this.user.passwordl){
                  this.dataService.user={"userId":item.userName};
                  let key = 'user';
                  let valueJson = JSON.stringify({ "userNamel": item.userName, "passwordl":item.password ,"userType" : item.userType});

                  sessionStorage.setItem(key, valueJson);
                  this.loginStatus = true;
                  if(item.userType == "Manufacturer" ) {
                    this._router.navigate(['/DBT/Manufacturer']);
                  }
                  else if(item.userType == "Government") {
                    this._router.navigate(['/DBT/Government']);
                  }
                  else {
                    this._router.navigate(['/DBT/Retailer']);
                  }
                }
            }
            if(!this.loginStatus) {
              this.error.userNamel = "Invalid Credentials";
            }
        });
      }
    }



   validateUser() : void
   {

          if (!this.user.userNamel) {
            this.error.userNamel = "Please Enter UserName";
            this.isUserValid=false;
          };
          if (!this.user.passwordl) {
            this.error.passwordl = "Please Enter Password";
            this.isUserValid=false;
          };
          if(!this.user.chainType) {
            this.error.chainType = "Please Select ChainType";
            this.isUserValid=false;
          }
console.log(this.error.userNamel + ""+this.error.passwordl + "" + this.error.chainType );
    }
  }
