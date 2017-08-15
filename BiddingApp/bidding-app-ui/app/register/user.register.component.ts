import {Component} from '@angular/core';
import {AppHttpService} from '../services/app.http.service';
import {Router} from '@angular/router';

@Component({
    selector:'user-register',
    templateUrl:'app/register/user.register.component.html'
})
export class UserRegisterComponent{
    constructor(private appHttpService:AppHttpService, private router:Router){}

    register(data){
        console.log(data);
        this.appHttpService.registerUser(data).subscribe((res)=>{
            if(res && res.flag){
                this.router.navigate(['/login']);
            }
        });
    }
}