import { Injectable } from '@angular/core';
import { Http, Response, ResponseContentType, RequestOptions, Headers, HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppConstant } from '../../../app/utils/app.constant';

import { environment } from '../../../environments/environment';

@Injectable()
export class HomeService {
    constructor(private _http: Http) { }


    login(loginData: any) {
        return this._http.post('/users/login', loginData, {})
            .map((response: Response) => <Response>response)
            .do(data => console.log(data));
    }


}
