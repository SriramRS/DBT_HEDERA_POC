import { Component, OnInit, transition,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { DataService } from '../../services/data.service'
import { WebService } from '../../services/web.service';
import {FormBuilder, FormGroup, Validators,FormArray} from '@angular/forms';
import {MatInputModule} from '@angular/material';
import {MatStepperModule} from '@angular/material/stepper';
import { MatStepper } from '@angular/material';

@Component({
    selector: 'app-employee',
    templateUrl: 'employeeDetails.html',
    providers: [WebService]
})

export class EmployeeDetails  {
  isLinear = false;
  profileInfo=true;
  paymentInfo=false;
  basicInfo=true;
  remittanceinfo=false;
  contactInfo=false;
  Progressvalue=30;
  myVar=true;
  orderForm: FormGroup;
  items: FormArray;
  paymentMethods=[{paymentMethods:"abc"},{paymentMethods:"cde"}];
    constructor(private _formBuilder: FormBuilder,private _router: Router, private _http: Http, private dataService: DataService,private webService: WebService) { }
      error = {
        "message": "",
      }
    ngOnInit() {

      this.orderForm = this._formBuilder.group({
      items: this._formBuilder.array([ this.createItem() ])
  });

}

  BasicDetails():void
  {
    this.profileInfo=true;
    this.paymentInfo=false;
    this.basicInfo=false;
    this.remittanceinfo=true;
    this.contactInfo=false;
    this.Progressvalue=60;
    this.myVar=true;
  }

  createItem(): FormGroup {
  return this._formBuilder.group({
    paymentMethod: '',
    remittanceInstruction: '',
    minmaxAmount:'',
    paymentMethods: this._formBuilder.array([this.add()]),
    csp:''
  });

}
add():FormGroup{
  return this._formBuilder.group({
    payment:'abc'
  })
}

addItem(): void {
  this.items = this.orderForm.get('items') as FormArray;
  this.items.push(this.createItem());

}

delInput(index: number): void {
      this.items = this.orderForm.get('items') as FormArray;
      console.log(index);
        this.items.removeAt(index);
    }

  remittanceDetails():void
  {
    this.profileInfo=true;
    this.paymentInfo=false;
    this.basicInfo=false;
    this.remittanceinfo=false;
    this.contactInfo=true;
    this.Progressvalue=100;
    this.myVar=true;
  }
  contactdetails():void
  {
    this.profileInfo=false;
    this.paymentInfo=true;
    this.basicInfo=false;
    this.remittanceinfo=false;
    this.contactInfo=false;
    this.myVar=false;

  }


}
