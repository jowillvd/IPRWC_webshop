import { Film } from '../film/film';
import { ShopcartItem } from './shopcartItem';

export class Shopcart {
    public items: ShopcartItem[] = new Array<ShopcartItem>();
    public totalItems: Number = 0;
    public totalPrice: Number = 0.00;

    public loadShopCart(cart: Shopcart) {
        this.items = cart.items;
    }
}
