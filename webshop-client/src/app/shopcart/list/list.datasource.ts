import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { Film } from '../../film/film';
import { ShopcartItem } from '../shopcartItem';


export class CartListDataSource extends DataSource<any> {
    constructor(private items: ShopcartItem[]) {
        super();
    }

    public connect(): Observable<ShopcartItem[]> {
        return Observable.of(this.items);
    }

    public disconnect() { }

}
