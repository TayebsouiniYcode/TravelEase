export class Room {
  id!: any;
  type!: string;
  description!: string;
  number!: number;
  price!: number;
  capacity!: number;

  constructor() {
    this.number = 0;
    this.type = " ";
  }
}
