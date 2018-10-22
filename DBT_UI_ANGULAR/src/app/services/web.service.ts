import { Injectable } from '@angular/core';
import { Http, Response, ResponseContentType, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { AppConstant } from '../../app/utils/app.constant';
import { TransferState } from '@angular/platform-browser';

@Injectable()
export class WebService {
    constructor(private _http: Http) { }

    login(request): Observable<any> {
        return this._http.post('/users/login', request, {})
            .map((response: Response) => <Response>response.json());
    }

    getJSON(): Observable<any> {
     return this._http.get("./assets/json/userDetails.json")
       .map((response: Response) => <Response>response.json());

    }

    uploadClaimFile(file) : Observable<any> {
      let formData:FormData = new FormData();
      formData.append("file", file);
      //formData.append("metadata",JSON.stringify(request));
      let headers = new Headers();
      headers.append('Accept', 'application/json');
      let options = new RequestOptions({ headers: headers });

      return this._http.post("http://52.41.165.29/autofinance/contract", formData, options)
        .map((response: Response) => <Response>response.json());

    }


    getClaimDetailById(transactionId) : Observable<any> {
       return this._http.get(AppConstant.BASE_URL + '/claim/transactionId/' + transactionId)
         .map((response: Response) => <Response>response.json());
    }

    createContract(request) : Observable<any> {
      return this._http.post("http://52.41.165.29/autofinance/contract", request, {})
        .map((response: Response) => <Response>response.json());
    }

    /* Retailer REST Calls*/
    getCustomerDetail(customerId) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/order/customerData/' + customerId)
        .map((response: Response) => <Response>response.json());
    }

    addSaleData(request) : Observable<any> {
      // let headers = new Headers();
      // headers.append('Content-Type', 'application/json');
      // let options = new RequestOptions({ headers: headers });
      return this._http.post(AppConstant.BASE_URL+'/order/putSaleOrder', request, {})
        .map((response: Response) => <Response>response);
    }

    getSaleOrderList() : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/order/saleOrderList/')
        .map((response: Response) => <Response>response.json());
    }

    //Manufacturer REST calculateSubAmt

    getTransactionsList(manfId) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/claim/saleOrderData/'+ manfId)
        .map((response: Response) => <Response>response.json());
    }

    getTransactionDataBySaleId(saleId) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/claim/viewSaleOrder/'+ saleId)
        .map((response: Response) => <Response>response.json());
    }

    getClaimsList(manfId) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/claim/claimOrder/'+ manfId)
        .map((response: Response) => <Response>response.json());
    }

    updateStatus(request) : Observable<any> {
      return this._http.post(AppConstant.BASE_URL+'/claim/updateClaim', request, {})
        .map((response: Response) => <Response>response);
    }

    getClaimDetail(claimID) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/claim/getClaimedData/'+ claimID)
        .map((response: Response) => <Response>response.json());
    }

    getAllClaims(status): Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/claim/viewAllClaims/'+ status)
        .map((response: Response) => <Response>response.json());
    }

    updateProcessClaim(request) : Observable<any> {
      return this._http.post(AppConstant.BASE_URL+'/claim/updateProcessClaim', request, {})
        .map((response: Response) => <Response>response);
    }

    getBalance(node) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/account/balance/'+ node)
        .map((response: Response) => <Response>response.json());
    }

    transfer(amount) : Observable<any> {
      return this._http.get(AppConstant.BASE_URL+'/account/transfer/'+ amount)
        .map((response: Response) => <Response>response);
    }




}
