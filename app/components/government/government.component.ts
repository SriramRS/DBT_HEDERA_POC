import { Component, OnInit, Inject, ViewChild, HostBinding, ElementRef } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { WebService } from '../../services/web.service';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { OverlayContainer} from '@angular/cdk/overlay';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-government',
  templateUrl: './government.component.html',
  styleUrls: ['./government.component.css'],
  providers: [WebService]
})
export class GovernmentComponent implements OnInit {

  user: { userdescriptionl: string, userType : string} = { userdescriptionl: "" , userType:""};
  displayedColumns = ['claimID', 'manufactName', 'manufactID', 'totalSubAmt', 'status'];
  displayedColumns1 = ['claimID', 'manufactName', 'manufactID', 'totalSubAmt', 'status'];

  showSpinner:boolean = false;
  dataSource = new MatTableDataSource<Claim>(CLAIM_DATA);
  dataSource1 = new MatTableDataSource<Claim>(CLAIM_DATA1);
  showGrid:boolean = true;
  showForm:boolean = false;
  fileObject = {"attachmentFileName":"","attachmentFile":null};
  file:File;
  fileList =[];
  nodeBalance:number;
  @ViewChild(MatPaginator)
  set paginator(value: MatPaginator) {
    this.dataSource.paginator = value;
  }

  constructor(public dialog: MatDialog,private _router: Router, private _http: Http, private webService: WebService, public overlayContainer: OverlayContainer, public snackBar: MatSnackBar) { }
  claimData = <Claim> {};

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    if (!this.user) {
      this._router.navigate(['/DBT/login']);
    }
    console.log(this.dataSource);
    this.getAllProcessedClaims();
    this.getAllPendingClaims();

  }//End OnInit

  // public selectFile(file): void {
  //   this.fileObject.attachmentFileName = file.name ;
  //   //this.fileObject.attachmentFile = this.getByteArray(file);
  //   this.file = file;
  //   console.log(this.fileObject);
  // }//End selectFile
  //
  // public uploadClaimFile():void {
  //   this.webService.uploadClaimFile(this.file).subscribe(result => {
  //     console.log(result);
  //   }, function(error){
  //     this.showSpinner = false;
  //   });
  // }//End uploadClaimFile method

  getClaimDetail(claimID) {
    this.webService.getClaimDetail(claimID).subscribe(item => {
      Object.assign(this.claimData,item);
      this.showGrid = false;
      this.showForm = true;
    });
  }

  getAllProcessedClaims() {
    this.webService.getAllClaims("Processed").subscribe(item => {
      CLAIM_DATA = item;
      this.dataSource = new MatTableDataSource<Claim>(CLAIM_DATA);
    });
  }

  getAllPendingClaims() {
    this.webService.getAllClaims("ACCEPTED").subscribe(item => {
      CLAIM_DATA1 = item;
      this.dataSource1 = new MatTableDataSource<Claim>(CLAIM_DATA1);
    });
  }

  getBalance() {
    this.webService.getBalance('government').subscribe(item => {
      this.nodeBalance = item;
    });
  }

  transfer() {
    this.webService.transfer(this.claimData.totalSubAmt).subscribe(item => {
      var nodeBalance = item;
    });
    this.claimData.status = "Processed";
    this.webService.updateProcessClaim(this.claimData).subscribe(item => {
      this.showGrid = true;
      this.showForm = false;
    })
  }

}


export interface Claim {
   claimID: string;
   manufactName: string;
   manufactID: string;
   totalSubAmt: string;
   status: string;
}

var CLAIM_DATA: Claim[] = [];

var CLAIM_DATA1: Claim[] = [];
