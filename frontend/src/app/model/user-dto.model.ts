export class UserDto {
  firstname: string;
  lastname: string;
  phone: string;
  email: string;
  username: string;
  password: string;

  constructor() {
    this.firstname = '';
    this.lastname = '';
    this.phone = '';
    this.email = '';
    this.username = '';
    this.password = '';
  }
}
