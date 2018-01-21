import { Component, OnInit } from '@angular/core';
import { ShopcartService } from '../shopcart.service';
import { Shopcart } from '../shopcart';
import { Film } from '../../film/film';
import { CartListDataSource } from './list.datasource';
import { Router } from '@angular/router';
import { AuthorizationService } from '../../shared/authorization.service';
import { MijnfilmsService } from '../../mijnfilms/mijnfilms.service';

@Component({
  selector: 'app-shopcart-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ShopcartListComponent implements OnInit {
    public shopcart: Shopcart;
    displayedColumns = ['posterurl', 'titel', 'prijs'];
    dataSource: CartListDataSource;
    authenticated = false;

    constructor(
        private shopcartService: ShopcartService,
        private router: Router,
        private authService: AuthorizationService,
        private mijnfilmsService: MijnfilmsService
    ) {
        this.shopcart = shopcartService.getShopcart();
        this.dataSource = new CartListDataSource(this.shopcart.items);
        this.authenticated = authService.hasAuthorization();
        authService.authorized$.subscribe(
            authorized => {
                this.authenticated = authorized;
            }
        );
    }

    public emptyShopcart() {
        if (confirm('Weet je zekker dat je je aankoop wilt annuleren?')) {
            this.shopcartService.removeShopcart();
            this.router.navigate(['/']);
        }
    }

    public buyItems() {
        if (this.authenticated) {
            if (confirm('Is het "betalen" zogenaamd gelukt?')) {
                this.mijnfilmsService.set(this.shopcart.items);
                this.shopcartService.removeShopcart();
            }
        } else {
            this.router.navigate(['/login']);
        }
    }

    ngOnInit() {
    }

}
