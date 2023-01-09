export class FindRoomForm {
  city: string;
  dateDebut: Date;
  dateFin: Date;
  type: string;
  capacity: number;

  constructor() {
    this.city = '';
    this.dateDebut = new Date();
    this.dateFin = new Date();
    this.type = "";
    this.capacity = 0;
  }
}
