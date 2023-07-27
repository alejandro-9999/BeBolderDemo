import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { RegisterEmployeeComponent } from './components/employee/register-employee/register-employee.component';
import { RegisterTeamComponent } from './components/employee/register-team/register-team.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'register/employee', component: RegisterEmployeeComponent},
  { path: 'register/team', component: RegisterTeamComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
