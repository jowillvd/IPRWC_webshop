import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmListComponent } from './list/list.component';
import { FilmDetailComponent } from './detail/detail.component';
import { PublicModule } from '../public.module';
import { FilmService } from './film.service';
import { MijnfilmsService } from '../mijnfilms/mijnfilms.service';

@NgModule({
    imports: [ PublicModule, CommonModule ],
    declarations: [FilmListComponent, FilmDetailComponent],
    providers: [ FilmService ]
})
export class FilmModule { }
