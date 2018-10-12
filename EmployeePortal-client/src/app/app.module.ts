import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { Http } from '@angular/Http';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { NewEmployeeComponent } from './new-employee/new-employee.component';
const appRoutes:Routes = [
  {path:'home',component:EmployeeComponent},
  {path:'*',component:EmployeeComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'new',component:NewEmployeeComponent},
];
@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    NewEmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
