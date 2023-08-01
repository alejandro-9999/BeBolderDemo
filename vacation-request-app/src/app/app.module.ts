import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AnimateModule } from 'primeng/animate';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './components/auth/login/login.component';
// Importa los módulos de PrimeNG que necesites
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { DividerModule } from 'primeng/divider';
import { CheckboxModule } from 'primeng/checkbox';
import { RadioButtonModule } from 'primeng/radiobutton';
import { CalendarModule } from 'primeng/calendar';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { DropdownModule } from 'primeng/dropdown';
import { ProgressSpinnerModule } from 'primeng/progressspinner';
import { TableModule } from 'primeng/table';
import { OverlayPanelModule } from 'primeng/overlaypanel';

import { ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/auth/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterEmployeeComponent } from './components/employee/register-employee/register-employee.component';
import { RegisterTeamComponent } from './components/employee/register-team/register-team.component'; // Asegúrate de importar este módulo
import { MessagesModule } from 'primeng/messages';
import { DashboardComponent } from './components/layout/dashboard/dashboard.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { MenubarModule } from 'primeng/menubar';
import { CreateComponent } from './components/layout/vacation_request/create/create.component';
import { ListComponent } from './components/layout/vacation_request/list/list.component';
import { ApproveComponent } from './components/layout/vacation_request/approve/approve.component';
import { AddUserComponent } from './components/teams/add-user/add-user.component';
import { ListComponent as TeamListComponent} from './components/teams/list/list.component';
import { CreateComponent as CreateTeamComponent } from './components/teams/create/create.component';
import { TeamMembersModalComponent } from './components/layout/teams/team-members-modal/team-members-modal.component';
import { DialogService } from 'primeng/dynamicdialog';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { AddMemberModalComponent } from './components/layout/teams/add-member-modal/add-member-modal.component';
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent,
    RegisterEmployeeComponent,
    RegisterTeamComponent,
    DashboardComponent,
    NavbarComponent,
    CreateComponent,
    ListComponent,
    ApproveComponent,
    AddUserComponent,
    TeamListComponent,
    CreateTeamComponent,
    TeamMembersModalComponent,
    AddMemberModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    CardModule,
    InputTextModule,
    ButtonModule,
    PasswordModule,
    ReactiveFormsModule,
    DividerModule,
    AnimateModule,
    BrowserAnimationsModule,
    CheckboxModule,
    RadioButtonModule,
    CalendarModule,
    InputTextareaModule,
    DropdownModule,
    HttpClientModule,
    ProgressSpinnerModule,
    MessagesModule,
    MenubarModule,
    TableModule,
    DynamicDialogModule,
    OverlayPanelModule
  ],
  providers: [DialogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
