import { Component, OnInit } from '@angular/core';
import { Gekocht } from '../gekocht';
import { MijnfilmsService } from '../mijnfilms.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mijnfilms-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class MijnfilmsListComponent implements OnInit {

    public items: Gekocht[] = [];

    constructor(
        private mijnfilmsService: MijnfilmsService,
        private router: Router
    ) {
    }

    private getGekochteList() {
        this.mijnfilmsService.getAll().subscribe(
            items => {
                this.items = items;
            },
            error => {
                this.router.navigate(['/login']);
            }
        );
    }

    ngOnInit() {
        this.getGekochteList();
    }

}
