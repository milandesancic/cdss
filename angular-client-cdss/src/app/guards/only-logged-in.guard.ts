import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoggedUtils } from '../utils/logged-utils';

@Injectable()
export class OnlyLoggedInGuard implements CanActivate {
  constructor(private router: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (!LoggedUtils.isEmpty()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}
