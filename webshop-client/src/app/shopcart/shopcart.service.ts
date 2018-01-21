import { Injectable } from '@angular/core';
import { ShopcartItem } from './shopcartItem';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { User } from '../user/user';
import { Film } from '../film/film';
import { Shopcart } from './shopcart';
import { AuthorizationService } from '../shared/authorization.service';

@Injectable()
export class ShopcartService {
    private cartItems: BehaviorSubject<Shopcart> = new BehaviorSubject(new Shopcart);
    private shopcart: Shopcart = new Shopcart();
    private user: User = new User();

    constructor(private authService: AuthorizationService) {
        this.cartItems.subscribe(_ => this.shopcart = _);
        this.restoreShopcart();
    }

    public restoreShopcart() {
        let shopcartString = sessionStorage.getItem('shopcart');

        if (shopcartString === null) {
            shopcartString = localStorage.getItem('shopcart');
        }

        if (shopcartString !== null) {
            const shopcart = JSON.parse(shopcartString);

            this.shopcart.items = shopcart['items'];
            this.calculateTotal();
            this.cartItems.next(this.shopcart);
        }
    }

    public removeShopcart() {
        this.shopcart.items = [];
        this.calculateTotal();
        this.cartItems.next(this.shopcart);
        localStorage.removeItem('shopcart');
    }

    public setShopcart() {
        const shopcartString = JSON.stringify(this.shopcart);
        localStorage.setItem('shopcart', shopcartString);
    }

    public itemInShopcart(film: Film) {
        for (let i = 0; i < this.shopcart.items.length; i++) {
            if (this.shopcart.items[i].film.id === film.id) {
                return true;
            }
        }
        return false;
    }

    public addItem(film: Film) {
        let bool = this.itemInShopcart(film);
        if (!bool) {
            this.shopcart.items.push(new ShopcartItem(film));
            this.calculateTotal();
            this.setShopcart();
            bool = true;
            this.cartItems.next(this.shopcart);
            alert('Film is toegevoegd aan je winkelwagen!');
        }
        return bool;
    }

    public calculateTotal() {
        this.shopcart.totalItems = this.shopcart.items.length;
        this.shopcart.totalPrice = this.shopcart.items
                                        .map((item) => item.film.prijs)
                                        .reduce((previous, current) => previous + current, 0);
    }

    public getShopcart() {
        return this.shopcart;
    }
}
