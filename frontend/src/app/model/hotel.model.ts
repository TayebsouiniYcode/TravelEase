import { Address } from './address.model';
import { Room } from './room.model';

export class Hotel {
  id: any;
  name: string;
  approved: boolean;
  addresseHotel: Address;
  rooms: Room[] = [];

  constructor() {
    this.id = null;
    this.name = "";
    this.approved= false;
    this.addresseHotel = new Address();
  }
}
