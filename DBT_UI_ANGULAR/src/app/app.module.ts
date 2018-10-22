import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import {MatToolbarModule,MatTabsModule,MatButtonModule,MatCardModule,MatTableModule,MatExpansionModule,MatStepperModule,MatPaginatorModule,MatFormFieldModule,MatRadioModule,MatCheckboxModule,MatMenuModule,MatIconModule, } from '@angular/material';
import { NgDatepickerModule } from 'ng2-datepicker';
import {NgxPaginationModule} from 'ngx-pagination';
import {MAT_DIALOG_DATA} from '@angular/material';
import {Component, Inject} from '@angular/core';
import {MatInputModule} from '@angular/material';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { MatStepper } from '@angular/material';
import {ProgressBarModule} from "angular-progress-bar";
import { WebService } from './services/web.service';
import { DataService } from './services/data.service';
import { HomeService } from './components/layout/home.service';
import { AppComponent } from './app.component';
import { AppHeader } from './components/layout/header.component';
import { AppFooter } from './components/layout/footer.component';
import { AppLogin } from './components/user/login.component';

import { MatDatepickerModule ,MatNativeDateModule} from "@angular/material";
import {MatSelectModule} from '@angular/material/select';
import {MatDialog, MatDialogRef} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';

// import { DialogComponentForDealer } from './components/dealer/dialog.component';

import { OverlayModule} from '@angular/cdk/overlay';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { GovernmentComponent } from './components/government/government.component';
import { ManufacturerComponent } from './components/manufacturer/manufacturer.component';
import { BeneficiaryComponent } from './components/beneficiary/beneficiary.component';

const appRoutes: Routes = [
  { path: 'DBT/login', component: AppLogin },
  { path: 'DBT/Manufacturer', component: ManufacturerComponent },
  { path: 'DBT/Retailer', component: BeneficiaryComponent },
  { path: 'DBT/Government', component: GovernmentComponent }

];

@NgModule({
  declarations: [
    AppComponent,AppHeader,AppFooter,AppLogin, GovernmentComponent, ManufacturerComponent, BeneficiaryComponent
  ],
  imports: [
    BrowserModule, MatDatepickerModule,MatNativeDateModule,MatSelectModule, MatDialogModule, MatProgressSpinnerModule, MatSnackBarModule,
    RouterModule.forRoot(appRoutes), FormsModule, HttpModule,HttpClientModule,NgDatepickerModule,MatToolbarModule,MatTabsModule,BrowserAnimationsModule,MatButtonModule,MatCardModule,MatTableModule,MatExpansionModule,MatStepperModule,ReactiveFormsModule,MatPaginatorModule,NgxPaginationModule,MatFormFieldModule,MatRadioModule,MatCheckboxModule,MatMenuModule,MatIconModule, MatInputModule,MatStepperModule,MatProgressBarModule,ProgressBarModule,OverlayModule],
  providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy }, DataService, WebService, HomeService],
  bootstrap: [AppComponent],
  entryComponents: []
  /*entryComponents: [DialogOverviewExampleDialog, DialogComponentForDealer, DialogComponentForOem]*/
})
export class AppModule { }
