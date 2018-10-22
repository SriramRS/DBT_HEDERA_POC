import { Component, OnInit, Inject, ViewChild, HostBinding, ElementRef } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { WebService } from '../../services/web.service';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { OverlayContainer} from '@angular/cdk/overlay';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-beneficiary',
  templateUrl: './beneficiary.component.html',
  styleUrls: ['./beneficiary.component.css'],
  providers: [WebService]
})
export class BeneficiaryComponent implements OnInit {

  user: { userdescriptionl: string, userType : string} = { userdescriptionl: "" , userType:""};
  displayedColumns = ['customerId', 'fartzName', 'qty', 'totalPrice','subAmt'];
  showSpinner:boolean = false;
  dataSource = new MatTableDataSource<SaleData>(SaleDataList);
  showGrid:boolean = true;
  showForm:boolean = false;
  generateOTP:boolean = true;
  showOTP:boolean = false;
  @ViewChild(MatPaginator)
  set paginator(value: MatPaginator) {
    this.dataSource.paginator = value;
  }

  saleData = <SaleData> {};
  customer = <Customer>{};


  constructor(public dialog: MatDialog,private _router: Router, private _http: Http, private webService: WebService, public overlayContainer: OverlayContainer, public snackBar: MatSnackBar) { }


  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    if (!this.user) {
      this._router.navigate(['/DBT/login']);
    }
    console.log(this.dataSource);
  }

  loadPage() {
    this.showSpinner= true;
    setInterval(() => {this.showSpinner= false;}, 1000);
  }

  getCustomerDetail() {
    this.showSpinner=true;
    this.webService.getCustomerDetail(this.customer.customerId).subscribe(item => {
      Object.assign(this.customer, item);
      this.generateOTP=false;
      this.showOTP=true;
      this.showSpinner=false;
      console.log("Hi");
    });
  }

  addSaleData() {
    this.showSpinner=true;
    this.saleData.customer = this.customer;
    this.saleData.retName = "Retailer1";
    this.saleData.retId = "RET1";
    this.saleData.manfId = "MANF1";
    console.log(this.saleData);
    this.webService.addSaleData(this.saleData).subscribe(item => {

      this.showForm=false;
      this.generateOTP=true;
      this.showGrid=true;
      this.showSpinner=false;
      this.customer.customerId = "";
    })
  }

  getSaleOrderList() {

    this.webService.getSaleOrderList().subscribe(item => {
      SaleDataList = item;
      this.dataSource = new MatTableDataSource<SaleData>(SaleDataList);
    })
  }

  calculateSubAmt() {
    this.saleData.subAmount = 100;
  }

  generateOTPMethod() {
    this.showOTP=false;
    this.showForm=true;
    this.showGrid=false;
    this.loadPage();
    console.log("Hi");
  }

}

export interface Customer {
  customerId: string;
  customerNm: string;
  contactNumber: string;
  location: string;
  landArea: string;
}

export interface SaleData {
  saleOrderId: string;
  invoiceNo: string;
  retName: string;
  retId: string;
  customer: Customer;
  isAuth: boolean;
  otp: string;
  fartzName: string;
  manfId: string;
  manfName: string;
  qty: number;
  totalPrice: number;
  subAmount: number;
}

var SaleDataList: SaleData[] = [];
// const ELEMENT_DATA: Element[] = [
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'},
//   {transactionID: "0000XXXXXXXXXXXXXXXXXXX", description: 'Hydrogen', user: "1.0079", status: 'H'}
// ];
