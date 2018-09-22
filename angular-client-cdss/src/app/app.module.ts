import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { AlreadyLoggedInGuard } from './guards/already-logged-in.guard';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { OnlyLoggedInGuard } from './guards/only-logged-in.guard';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { TokenInterceptorService } from './service/token-interceptor.service';
import { DiagnoseComponent } from './components/diagnose/diagnose.component';


const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: 'login', component: AuthenticationComponent, canActivate: [AlreadyLoggedInGuard] },
  { path: 'home', component: HomeComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'diagnose', component: DiagnoseComponent, canActivate: [OnlyLoggedInGuard] }
];


@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HomeComponent,
    NavBarComponent,
    DiagnoseComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
    ),
  ],
  providers: [
    OnlyLoggedInGuard,
    AlreadyLoggedInGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
