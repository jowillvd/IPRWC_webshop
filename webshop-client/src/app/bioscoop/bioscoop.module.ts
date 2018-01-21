import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BioscoopListComponent } from './list/list.component';
import { BioscoopDetailComponent } from './detail/detail.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [BioscoopListComponent, BioscoopDetailComponent]
})
export class BioscoopModule { }
