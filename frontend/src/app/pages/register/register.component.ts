import { Component, OnInit } from '@angular/core';
import { UserDto } from 'src/app/model/user-dto.model';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userDto : UserDto;

  constructor(private auth: AuthService, private router: Router) {
    this.userDto = new UserDto();
  }

  ngOnInit(): void {
  }

  register() {
    this.auth.register(this.userDto).subscribe(
      (data) => {
        console.log(data);
        if (data != null) {
          this.router.navigate(['/login']);
        }
      }
    )
  }
}
