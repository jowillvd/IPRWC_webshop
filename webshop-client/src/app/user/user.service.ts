
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import { ApiService } from '../shared/api.service';
import { AuthorizationService } from '../shared/authorization.service';

import { User } from './user';
import { ShopcartService } from '../shopcart/shopcart.service';

@Injectable()
export class UserService {
    constructor(private api: ApiService,
        private authService: AuthorizationService,
        private shopcartService: ShopcartService,
        private router: Router) {

    }

    public getAll(): Observable<User[]> {
        return this.api.get<User[]>('gebruikers');
    }

    public register(user: User): void {
        const data = {
            voornaam: user.voornaam,
            achternaam: user.achternaam,
            geboortedatum: user.geboortedatum,
            email: user.email,
            wachtwoord: user.wachtwoord,
            rol: 'STANDAARD'
        };

        this.api.post<void>('gebruikers', data).subscribe(
            data => {
                this.router.navigate(['/login']);
            },
            error => {
                alert('Het registreren is mislukt');
            }
        );
    }

    public login(user: User, remember: boolean): void {
        this.authService.setAuthorization(user.email, user.wachtwoord);

        this.api.get<User>('gebruikers/me').subscribe(
            authenticator => {
                this.authService.storeAuthorization(authenticator, remember);
                this.goHome();
            },
            error => {
                alert('Het inloggen is mislukt');
            }
        );
    }

    public logout() {
        this.authService.deleteAuthorization();

        this.goHome();
    }

    private goHome() {
        this.router.navigate(['']);
    }
}
