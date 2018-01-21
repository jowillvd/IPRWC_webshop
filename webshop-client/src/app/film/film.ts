export class Film {
    constructor(
        public id?: number,
        public titel?: string,
        public release?: Date,
        public beschrijving?: string,
        public filmtrailer?: string,
        public posterurl?: string,
        public prijs?: number) {
    }
}
