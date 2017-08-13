import {Component} from '@angular/core';
import {AppHttpService} from '../services/app.http.service';

@Component({
    selector:'auth-page',
    templateUrl:'app/auth/auth.component.html'
})
export class AuthComponent{

    constructor(private appHttpService:AppHttpService){}

    login(data){
        console.log(data);
        this.appHttpService.doLogin(data).subscribe();
    }
}