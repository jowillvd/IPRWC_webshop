import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilmService } from '../film.service';
import { Film } from '../film';

@Component({
  selector: 'app-film-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class FilmListComponent implements OnInit {

    public films: Film[] = [];

    constructor(private filmService: FilmService) {
    }

    private getFilmsList() {
        this.filmService.getAll().subscribe(
            films => {
                this.films = films;
            },
            error => {

            }
        );
    }

    ngOnInit() {
        this.getFilmsList();
    }

}
