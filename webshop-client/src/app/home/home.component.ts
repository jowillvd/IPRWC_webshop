
import { Component } from '@angular/core';

import { AuthorizationService } from '../shared/authorization.service';

import { User } from '../user/user';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
})
export class HomeComponent {
    public authenticated = false;

    constructor(
        private authService: AuthorizationService,
        private router: Router) {
        authService.authorized$.subscribe(
            authorized => {
                this.updateAuthentication();
            }
        );

        this.updateAuthentication();
    }

    private updateAuthentication() {
        this.authenticated = this.authService.hasAuthorization();

        if (!this.authenticated) {
            return;
        }

        const user: User = this.authService.getAuthenticator();
    }

    public goHome() {
        this.router.navigate(['']);
    }

    public logout() {
        this.authService.deleteAuthorization();

        this.goHome();
    }
}
