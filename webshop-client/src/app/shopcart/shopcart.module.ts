import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopcartListComponent } from './list/list.component';
import { ShopcartService } from './shopcart.service';
import { PublicModule } from '../public.module';

@NgModule({
  imports: [
    CommonModule,
    PublicModule
  ],
  declarations: [ShopcartListComponent],
  providers: [ ShopcartService ]
})
export class ShopcartModule { }
