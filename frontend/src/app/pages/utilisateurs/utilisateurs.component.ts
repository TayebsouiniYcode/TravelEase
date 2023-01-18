import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { UserUpdateDto } from 'src/app/dto/user-update-dto';
@Component({
  selector: 'app-utilisateurs',
  templateUrl: './utilisateurs.component.html',
  styleUrls: ['./utilisateurs.component.css']
})
export class UtilisateursComponent implements OnInit {

  users!: any;
  userUpdate!: any;
  userUpdateDto: UserUpdateDto = new UserUpdateDto();

  constructor(private tokenService: TokenService, private utilisateurService: UtilisateurService) {
    this.utilisateurService.getAllUsers().subscribe(
      (data) => {
        this.users = data;
        //TODO create model
      }
    )
  }

  ngOnInit(): void {
  }

  hasRole(roleName: string) : boolean | any{
    let roles = this.tokenService.getRoles();

    for (const authority in roles) {
      if (roles[authority].authority == roleName) {
        return true;
      }
    }
  }

  chargeModal(user: any) {
    this.userUpdateDto.firstname = user.firstname;
    this.userUpdateDto.lastname = user.lastname;
    this.userUpdateDto.role_name = user.roles[0].role_name;
    this.userUpdateDto.email = user.email;
  }

  saveChanges() {
    this.utilisateurService.updateUtilisateur(this.userUpdateDto).subscribe(
      (data) => {
        console.log(data);
      }
    );
  }

  deleteUser(user: any) {

  }
}
