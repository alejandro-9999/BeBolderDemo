import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-team',
  templateUrl: './register-team.component.html',
  styleUrls: ['./register-team.component.scss']
})
export class RegisterTeamComponent {
  addTeamForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.addTeamForm = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.addTeamForm.valid) {
      // Realizar acciones cuando el formulario es válido
      const formData = this.addTeamForm.value;
      console.log(formData);
    } else {
      // Realizar acciones cuando el formulario es inválido
      console.log('Formulario inválido. Verifica los campos.');
    }
  }

  get nameControl():FormControl{
    return this.addTeamForm.get('name') as FormControl;
  }

}
