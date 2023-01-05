import { Address } from './address.model';

export class Hotel {
  id: any;
  name: string;
  approved!: boolean;
  addresseHotel!: Address;

  constructor() {
    this.id = null;
    this.name = "";
    this.approved= false;
    this.addresseHotel = new Address();
  }
}
