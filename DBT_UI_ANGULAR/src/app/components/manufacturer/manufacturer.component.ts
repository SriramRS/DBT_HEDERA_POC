import { Component, OnInit, Inject, ViewChild, HostBinding, ElementRef } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { WebService } from '../../services/web.service';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { OverlayContainer} from '@angular/cdk/overlay';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-manufacturer',
  templateUrl: './manufacturer.component.html',
  styleUrls: ['./manufacturer.component.css'],
  providers: [WebService]
})
export class ManufacturerComponent implements OnInit {
  user: { userdescriptionl: string, userType : string} = { userdescriptionl: "" , userType:""};
  // displayedColumns = ['transactionID', 'description', 'user', 'status'];
  displayedColumns = ['claimID', 'manufactName', 'manufactID','totalSubAmt','status'];
  displayedColumns1 = ['saleOrdId', 'fartzName', 'qty', 'totalPrice','subAmount'];
  showSpinner:boolean = false;
  dataSource = new MatTableDataSource<Claim>(Claim_Data);
  dataSource1 = new MatTableDataSource<SaleData>(Sale_Data);
  showGrid:boolean = true;
  showForm:boolean = false;
  nodeBalance:number;

  @ViewChild(MatPaginator)
  set paginator(value: MatPaginator) {
    this.dataSource.paginator = value;
  }

  claimData = <Claim> {};
  customer = <Customer> {};
  saleData = <SaleData> {};

  constructor(public dialog: MatDialog,private _router: Router, private _http: Http, private webService: WebService, public overlayContainer: OverlayContainer, public snackBar: MatSnackBar) { }


  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    if (!this.user) {
      this._router.navigate(['/DBT/login']);
    }
    this.getTransactionsList();
    this.getClaimsList();
  }

  getTransactionsList() {
    this.showSpinner = true;
    this.webService.getTransactionsList("MANF1").subscribe(item => {
      Sale_Data = item;
      this.showSpinner = false;
      this.dataSource1 = new MatTableDataSource<SaleData>(Sale_Data);
    })
  }

  getClaimsList() {
    this.showSpinner = true;
      this.webService.getAllClaims("ACCEPTED").subscribe(item => {
        Claim_Data = item;
        this.showSpinner = false;
        this.dataSource = new MatTableDataSource<Claim>(Claim_Data);
      });
  }

  getTransactionDataBySaleId(saleId) {
  //  var saleId:number = parseInt(this.saleData.saleOrdId);
  this.showSpinner = true;
    this.webService.getTransactionDataBySaleId(saleId).subscribe(item => {
      Object.assign(this.saleData, item);
      console.log(this.saleData);
      this.customer = this.saleData.customer;
      console.log(this.customer);
      this.showGrid=false;
      this.showForm=true;
      this.showSpinner = false;
    })
  }
  acceptClaim() {
    this.showSpinner = true;
    this.saleData.status = "ACCEPTED";
    this.webService.updateStatus(this.saleData).subscribe(item => {
      this.showForm=false;
      this.showGrid=true;
      this.showSpinner = false;
      this.getClaimsList();
    })
  }

  rejectClaim() {
    this.showSpinner = true;
    this.saleData.status = "REJECTED";
    this.webService.updateStatus(this.saleData).subscribe(item => {
      this.showForm=false;
      this.showGrid=true;
      this.showSpinner = false;
      this.getClaimsList();
    })
  }
  // getCustomerDetail() {
  //   this.showSpinner=true;
  //   this.webService.getCustomerDetail(this.customer.customerId).subscribe(item => {
  //     Object.assign(this.customer, item);
  //     this.showSpinner=false;
  //     console.log("Hi");
  //   });
  // }

  getBalance() {
    this.webService.getBalance('manufacture').subscribe(item => {
      this.nodeBalance = item;
    });
  }



}//ENd Class

export interface Customer {
  customerId: string;
  customerNm: string;
  contactNumber: string;
  location: string;
  landArea: string;
}

  export interface SaleData {
    saleOrdId: string;
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
    status: string;
  }

  export interface Claim {
     claimID: number;
     manufactName: string;
     manufactID: string;
     totalSubAmt: string;
     status: string;
  }

  var Sale_Data: SaleData[] =[];
  var Claim_Data: Claim[]= [];
