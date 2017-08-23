import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Subject, Observable} from 'rxjs/Rx';
import  {TokenManagerService} from './token.manager.service';

interface IAuthData{
    flag:boolean,
    message:string
}
 
@Injectable()
export class AppHttpService{
    constructor(private http:Http, private tokenManager:TokenManagerService){}

    headers = new Headers({
        'Content-Type':'application/json'
    });
    options = new RequestOptions({headers:this.headers});

    secure():Observable<any>{
        var token = "Bearer "+this.tokenManager.getToken();
        this.headers.set('authorization', token);
        return this.http.post("http://localhost:8080/secure","",this.options).map((response:Response) =>
              {
               return response.json();
        }).catch(this.errorHandler);
    }

    doLogin(data):Observable<IAuthData>{
        return this.http.post("http://localhost:8080/auth/login", data, this.options).map((response:Response) =>
              {
               this.tokenManager.storeToken(response.json().message);
               return <IAuthData>response.json();
        }).catch(this.errorHandler);
    }

    registerUser(data):Observable<IAuthData>{
       
        return this.http.post("http://localhost:8080/auth/register", data, this.options).map((response:Response) =>
              {
               return <IAuthData>response.json();
        }).catch(this.errorHandler);
    }

    errorHandler(error:Response){
        return Observable.throw(error.statusText);
    }
}