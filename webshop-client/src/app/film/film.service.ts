import { Injectable } from '@angular/core';
import { ApiService } from '../shared/api.service';
import { AuthorizationService } from '../shared/authorization.service';
import { Router } from '@angular/router';
import { Film } from './film';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class FilmService {

    constructor(private api: ApiService,
        private authService: AuthorizationService,
        private router: Router) {
    }

    public getAll(): Observable<Film[]> {
        return this.api.get<Film[]>('films');
    }

    public get(id: number): Observable<Film> {
        return this.api.get<Film>('films/' + id);
    }

}
