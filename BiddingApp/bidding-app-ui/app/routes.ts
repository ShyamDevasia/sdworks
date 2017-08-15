import {Routes} from '@angular/router';
import {AuthComponent} from './auth/auth.component';
import {UserRegisterComponent} from './register/user.register.component';
import  {AuthInitResolver} from './auth/auth-init.resolver';
import {BidLandingComponent} from './bid/bid-landing.component';

export const appRoutes:Routes = [
    {path:'login', component:AuthComponent, resolve:{init:AuthInitResolver}},
    {path:'register', component:UserRegisterComponent},
    {path:'bidnow', component:BidLandingComponent},
    {path:'', redirectTo:"/login", pathMatch:'full'},
];
