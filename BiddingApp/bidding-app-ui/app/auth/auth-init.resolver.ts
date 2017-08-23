import {Injectable} from "@angular/core";
import {Resolve} from "@angular/router";
import {AppHttpService} from "../services/app.http.service";

@Injectable()
export class AuthInitResolver implements Resolve<any>{

    constructor(private httpService:AppHttpService){}

    resolve(){
        return this.httpService.secure().subscribe();
    }

}
