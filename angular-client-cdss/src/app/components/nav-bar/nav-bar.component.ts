import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../service/authentication.service';
import { Router } from '@angular/router';
import { LoggedUtils } from '../../utils/logged-utils';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,private roter:Router) { }

  ngOnInit() {
    console.log(LoggedUtils.getLoggedUser());
  }


  logout(){
    this.authenticationService.logout().subscribe(
      data => {
        // console.log(data);
        LoggedUtils.clearLocalStorage();
        this.roter.navigate(['/login']);
      }
    )
  }
}
