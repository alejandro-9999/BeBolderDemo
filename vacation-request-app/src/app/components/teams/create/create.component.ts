import { UserService } from 'src/app/services/User/user.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { TeamService } from 'src/app/services/Team/team.service';

@Component({
  selector: 'app-create-team',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  addTeamForm: FormGroup;
  supervisors: any[] = [];
  isLoading: boolean = false;
  messages: any[] = [];

  constructor(private formBuilder: FormBuilder, private userService: UserService,private teamService: TeamService) {
    this.addTeamForm = this.formBuilder.group({
      name: ['', Validators.required],
      supervisor: ['', Validators.required],
    });
  }

  ngOnInit(){
    this.loadSupervisors();
  }

  loadSupervisors(){
    this.userService.getUsers('supervisor').subscribe(users => {
      this.supervisors = users;
    },err => console.log(err) );
  }



  onSubmit() {
    this.isLoading = true;
    this.messages = [];
    if (this.addTeamForm.valid) {
      // Realizar acciones cuando el formulario es válido
      const formData = this.addTeamForm.value;
      this.teamService.createTeam(formData).subscribe(
        (response) => {
          this.isLoading = false;
          this.messages = [{ severity: 'success', summary: 'Success', detail: 'Team Created' }];
          this.teamService.teamCreated.emit();
        },
        (error) => {
          this.isLoading = false;
          console.log(error.error.message);
          this.messages = [{ severity: 'error', summary: 'Error', detail: error.error.message }];
        },
        () => {
          this.isLoading = false;
        }
      );
    } else {
      // Realizar acciones cuando el formulario es inválido
      console.log('Formulario inválido. Verifica los campos.');
    }
  }

  get nameControl():FormControl{
    return this.addTeamForm.get('name') as FormControl;
  }
}
