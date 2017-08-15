import {Component, OnInit} from '@angular/core';
import {AppHttpService} from '../services/app.http.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
    selector:'auth-page',
    templateUrl:'app/auth/auth.component.html'
})
export class AuthComponent implements OnInit{
    init:any;
    constructor(private appHttpService:AppHttpService, private activatedRoute:ActivatedRoute,
            private router:Router){}

    ngOnInit(){
        this.init = this.activatedRoute.snapshot.data['init'];
    }

    login(data){
        console.log(data);
        this.appHttpService.doLogin(data).subscribe((res) =>{
            if(res && res.flag){
                this.router.navigate(['/bidnow']);
            }
        });
    }
}