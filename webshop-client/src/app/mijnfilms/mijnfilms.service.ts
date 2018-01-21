import { Injectable } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { AuthorizationService } from '../shared/authorization.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Gekocht } from './gekocht';
import { ShopcartItem } from '../shopcart/shopcartItem';

@Injectable()
export class MijnfilmsService {

    constructor(private api: ApiService,
        private authService: AuthorizationService,
        public router: Router) {
    }

    public getAll(): Observable<Gekocht[]> {
        return this.api.get<Gekocht[]>('filmsgekocht');
    }

    public get(id: number): Observable<Gekocht> {
        return this.api.get<Gekocht>('filmsgekocht/' + id);
    }

    public contains(filmId: number): Observable<boolean> {
        return this.api.get<boolean>('filmsgekocht/contains/' + filmId);
    }

    public set(items: ShopcartItem[]) {
        items.forEach(item => {
            this.api.post<void>('filmsgekocht', item).subscribe(
                data => {
                    console.log('toegevoegd');
                },
                error => {
                    console.log('Er is iets misgegaan');
                },
                () => {
                    this.router.navigate(['/mijnfilms']);
                }
            );
        });
    }

}
