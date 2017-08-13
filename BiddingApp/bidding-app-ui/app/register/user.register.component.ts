import {Component} from '@angular/core';
import {AppHttpService} from '../services/app.http.service';

@Component({
    selector:'user-register',
    templateUrl:'app/register/user.register.component.html'
})
export class UserRegisterComponent{
    constructor(private appHttpService:AppHttpService){}

    register(data){
        console.log(data);
        this.appHttpService.registerUser(data).subscribe();
    }
}