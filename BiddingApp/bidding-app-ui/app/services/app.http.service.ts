import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Subject, Observable} from 'rxjs/Rx';

interface IAuthData{
    flag:string,
    message:string
}
 
@Injectable()
export class AppHttpService{
    constructor(private http:Http){}

    headers = new Headers({
        'Content-Type':'application/json'
    });
    options = new RequestOptions({headers:this.headers});

    doLogin(data):Observable<IAuthData>{
        return this.http.post("/services/bidding/login", data, this.options).map((response:Response) =>
              {
               return <IAuthData>response.json();
        }).catch(this.errorHandler);
    }

    registerUser(data):Observable<IAuthData>{
       
        return this.http.post("/services/bidding/register", data, this.options).map((response:Response) =>
              {
               return <IAuthData>response.json();
        }).catch(this.errorHandler);
    }

    errorHandler(error:Response){
        return Observable.throw(error.statusText);
    }
}