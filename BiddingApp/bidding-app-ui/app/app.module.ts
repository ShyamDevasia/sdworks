import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {AuthComponent} from'./auth/auth.component';
import {UserRegisterComponent} from './register/user.register.component';
import {BidLandingComponent} from './bid/bid-landing.component';
import {appRoutes} from './routes';
import {AppHttpService} from './services/app.http.service';
import  {AuthInitResolver} from './auth/auth-init.resolver';


@NgModule({
    imports:[
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(appRoutes),
    ],
    declarations:[
        AppComponent,
        AuthComponent,
        UserRegisterComponent,
        BidLandingComponent
    ],
    providers:[
        AppHttpService,
        AuthInitResolver
    ],
    bootstrap:[AppComponent]
})
export class AppModule{

}