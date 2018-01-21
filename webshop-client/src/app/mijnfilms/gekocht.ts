import { User } from '../user/user';
import { Film } from '../film/film';

export class Gekocht {
    constructor(
        public id?: number,
        public gebruiker?: User,
        public film?: Film) {
    }
}
