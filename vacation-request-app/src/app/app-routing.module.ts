import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { RegisterEmployeeComponent } from './components/employee/register-employee/register-employee.component';
import { RegisterTeamComponent } from './components/employee/register-team/register-team.component';
import { ListComponent } from './components/layout/vacation_request/list/list.component';
import { ListComponent as TeamListComponent} from './components/teams/list/list.component';

import { ApproveComponent } from './components/layout/vacation_request/approve/approve.component';
import { DashboardComponent } from './components/layout/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'register/employee', component: RegisterEmployeeComponent},
  { path: 'register/team', component: RegisterTeamComponent},
  { path: 'vacation/request', component: ListComponent},
  { path: 'vacation/approval', component: ApproveComponent},
  { path: 'teams', component: TeamListComponent},
  { path: 'dashboard', component: DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
