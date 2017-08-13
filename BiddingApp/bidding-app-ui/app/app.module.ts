import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {AuthComponent} from'./auth/auth.component';
import {UserRegisterComponent} from './register/user.register.component';
import {appRoutes} from './routes';
import {AppHttpService} from './services/app.http.service';

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
        UserRegisterComponent
    ],
    providers:[
        AppHttpService
    ],
    bootstrap:[AppComponent]
})
export class AppModule{

}