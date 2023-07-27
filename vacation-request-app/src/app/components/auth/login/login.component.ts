import { Component } from '@angular/core';
import {FormBuilder,FormControl,FormGroup,Validators} from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
    loginForm: FormGroup;
    constructor(private formBuilder: FormBuilder){
      this.loginForm = this.formBuilder.group({
        username: ['',Validators.required],
        password: ['',Validators.required]
      });
    }

    onSubmit() {
      if (this.loginForm.valid) {
        // Realizar acciones cuando el formulario es válido
        const formData = this.loginForm.value;
        console.log(formData);
      } else {
        console.log(this.loginForm.getError('username'));
        // Realizar acciones cuando el formulario es inválido
        console.log('Formulario inválido. Verifica los campos.');
      }
    }

    get userNameControl(): FormControl{
      return this.loginForm.get("username") as FormControl;
    }

    get passwordControl(): FormControl{
      return this.loginForm.get("password") as FormControl;
    }

}
