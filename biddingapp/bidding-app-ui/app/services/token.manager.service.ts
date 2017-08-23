import {Injectable} from '@angular/core';

@Injectable()
export class TokenManagerService{

    private  userToken : string;

    storeToken(token:string){
        localStorage.setItem("userToken",token);
    }

    getToken(){
        return localStorage.getItem("userToken");
    }
}