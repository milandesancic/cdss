import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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
import { PatientComponent } from './components/patient/patient.component';
import { QueryComponent } from './components/query/query.component';
import { ReportComponent } from './components/report/report.component';
import { ReportDetailsComponent } from './components/report-details/report-details.component';
import { SymptomQueryComponent } from './components/symptom-query/symptom-query.component';
import { DiseaseQueryComponent } from './components/disease-query/disease-query.component';



const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: 'login', component: AuthenticationComponent, canActivate: [AlreadyLoggedInGuard] },
  { path: 'home', component: HomeComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'diagnose', component: DiagnoseComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'patient', component: PatientComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'query', component: QueryComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'report', component: ReportComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'query/symptoms', component: SymptomQueryComponent, canActivate: [OnlyLoggedInGuard] },
  { path: 'query/disease', component: DiseaseQueryComponent, canActivate: [OnlyLoggedInGuard] }
];


@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HomeComponent,
    NavBarComponent,
    DiagnoseComponent,
    PatientComponent,
    QueryComponent,
    ReportComponent,
    ReportDetailsComponent,
    SymptomQueryComponent,
    DiseaseQueryComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
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
