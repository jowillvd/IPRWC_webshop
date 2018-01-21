import { Component, OnInit } from '@angular/core';
import { Gekocht } from '../gekocht';
import { MijnfilmsService } from '../mijnfilms.service';
import { Router, ActivatedRoute } from '@angular/router/';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
    selector: 'app-mijnfilms-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.css']
})
export class MijnfilmsDetailComponent implements OnInit {

    gekocht: Gekocht = null;
    filmUrl: SafeResourceUrl = this.sanitizer.bypassSecurityTrustResourceUrl('https://www.youtube.com/embed/');

    constructor(
        private mijnfilmsService: MijnfilmsService,
        private router: Router,
        private route: ActivatedRoute,
        public sanitizer: DomSanitizer
    ) {
    }

    private getGekochtItem() {
        this.mijnfilmsService.get(Number(this.route.snapshot.paramMap.get('id'))).subscribe(
            item => {
                this.gekocht = item;
                this.filmUrl =
                    this.sanitizer.bypassSecurityTrustResourceUrl('https://www.youtube.com/embed/' + this.gekocht.film.filmtrailer);
            },
            error => {
                this.router.navigate(['/login']);
            }
        );
    }

    ngOnInit() {
        this.getGekochtItem();
    }

}
