
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './user/login/login.component';
import { FilmListComponent } from './film/list/list.component';
import { FilmDetailComponent } from './film/detail/detail.component';
import { BioscoopListComponent } from './bioscoop/list/list.component';
import { BioscoopDetailComponent } from './bioscoop/detail/detail.component';
import { ShopcartListComponent } from './shopcart/list/list.component';
import { MijnfilmsListComponent } from './mijnfilms/list/list.component';
import { MijnfilmsDetailComponent } from './mijnfilms/detail/detail.component';

export const routes: Routes =
[
    { path: '', component: HomeComponent },
    { path: 'registreren', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    {
        path: 'films',
        children: [
            { path: '', component: FilmListComponent },
            { path: ':id', component: FilmDetailComponent },
        ]
    },
    {
        path: 'bioscopen',
        children: [
            { path: '', component: BioscoopListComponent },
            { path: ':id', component: BioscoopDetailComponent }
        ]
    },
    {
        path: 'shoppingcart',
        children: [
            { path: '', component: ShopcartListComponent },
        ]
    },
    {
        path: 'mijnfilms',
        children: [
            { path: '', component: MijnfilmsListComponent },
            { path: ':id', component: MijnfilmsDetailComponent }
        ]
    }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class RoutesModule { }
