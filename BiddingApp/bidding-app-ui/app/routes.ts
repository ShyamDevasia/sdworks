import {Routes} from '@angular/router';
import {AuthComponent} from './auth/auth.component';
import {UserRegisterComponent} from './register/user.register.component';

export const appRoutes:Routes = [
    {path:'login', component:AuthComponent},
    {path:'register', component:UserRegisterComponent},
    {path:'', redirectTo:"/login", pathMatch:'full'},
];
