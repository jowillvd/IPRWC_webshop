import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MijnfilmsListComponent } from './list/list.component';
import { MijnfilmsDetailComponent } from './detail/detail.component';
import { MijnfilmsService } from './mijnfilms.service';
import { PublicModule } from '../public.module';

@NgModule({
    imports: [
        CommonModule,
        PublicModule
    ],
    declarations: [MijnfilmsListComponent, MijnfilmsDetailComponent],
    providers: [MijnfilmsService]
})
export class MijnfilmsModule { }
