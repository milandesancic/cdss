import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {

  loginForm;
  private username: string;
  private password: string;

  constructor(private authenticationService: AuthenticationService,private router:Router) {
    this.username = '';
    this.password = '';
   }

  ngOnInit() {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
      password: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)]))
    });
  }


  authenticate() {
    const credentials = this.loginForm.value;
    console.log(credentials);
    this.authenticationService.authenticateUser(credentials).subscribe(
      data=>{
        console.log(JSON.stringify(data));
        localStorage.setItem('loggedUser',JSON.stringify(data)),
          this.router.navigate(['/home']);
      },
      error=>{
        alert("Pogresna lozinka ili korisnicko ime");
      }
    )
  }


}
