
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RoutesModule } from './routes.module';
import { PublicModule } from './public.module';

import { SharedModule } from './shared/shared.module';
import { HomeModule } from './home/home.module';
import { UserModule } from './user/user.module';

import { AppComponent } from './app.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FilmModule } from './film/film.module';
import { BioscoopModule } from './bioscoop/bioscoop.module';
import { ShopcartModule } from './shopcart/shopcart.module';
import { MijnfilmsModule } from './mijnfilms/mijnfilms.module';

@NgModule({
  imports: [
    BrowserModule,
    RoutesModule,
    PublicModule,
    SharedModule,
    HomeModule,
    UserModule,
    FilmModule,
    ShopcartModule,
    BioscoopModule,
    MijnfilmsModule
  ],
  exports: [ PublicModule ],
  declarations: [ AppComponent ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
