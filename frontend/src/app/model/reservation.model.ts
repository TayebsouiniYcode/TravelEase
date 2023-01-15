export class Reservation {
  public idRoom!: number;
  public dateDebut!: Date;
  public dateFin!: Date;

  constructor() {
    this.idRoom = 0;
    this.dateDebut = new Date();
    this.dateFin = new Date();
  }
}
