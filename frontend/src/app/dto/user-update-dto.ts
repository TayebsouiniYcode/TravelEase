export class UserUpdateDto {
  email: string;
  firstname: string;
  lastname: string;
  role_name: string;

  constructor() {
    this.email = "";
    this.firstname = "";
    this.lastname = "";
    this.role_name = "";
  }
}
