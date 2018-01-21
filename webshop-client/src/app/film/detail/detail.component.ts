import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmService } from '../film.service';
import { Film } from '../film';
import { ShopcartService } from '../../shopcart/shopcart.service';
import { MijnfilmsService } from '../../mijnfilms/mijnfilms.service';

@Component({
    selector: 'app-film-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.css']
})
export class FilmDetailComponent implements OnInit {

    public film: Film = new Film();
    public mijnFilm = false;
    public inShopcart = false;

    constructor(
        private route: ActivatedRoute,
        private filmService: FilmService,
        private shopcartService: ShopcartService,
        private mijnfilmsService: MijnfilmsService
    ) {
    }

    public addToCart() {
        this.inShopcart = this.shopcartService.addItem(this.film);
    }

    ngOnInit() {
        this.filmService.get(Number(this.route.snapshot.paramMap.get('id'))).subscribe(
            film => {
                this.film = film;
                this.inShopcart = this.shopcartService.itemInShopcart(this.film);
            }
        );
        this.mijnfilmsService.contains(Number(this.route.snapshot.paramMap.get('id'))).subscribe(
            contains => {
                this.mijnFilm = contains;
            }
        );
    }

}
