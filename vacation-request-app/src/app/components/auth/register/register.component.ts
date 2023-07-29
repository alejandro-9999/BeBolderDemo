import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/User/user.service';
import { Router } from '@angular/router'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  registrationForm: FormGroup;
  isLoading: boolean = false;
  messages: any[] = [];
  constructor(private formBuilder: FormBuilder, private userService:UserService,private router: Router) {
    this.registrationForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      confirmPassword: ['', Validators.required],
      userType: ['regularUser', Validators.required]
    },{ validator: this.passwordMatchValidator });
  }

  ngOnInit() {}

  onSubmit() {
    this.isLoading = true;
    this.messages = [];
    if (this.registrationForm.valid) {
      // Perform actions when the form is valid
      const formData = this.registrationForm.value;
      this.userService.saveUser(formData).subscribe(
        (response) => {
          this.isLoading = false;
          this.messages = [{ severity: 'success', summary: 'Success', detail: 'Completed Registration' }];
          localStorage.setItem('currentUser', JSON.stringify(response));
          this.router.navigate(['/register/employee']);
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
      // Perform actions when the form is invalid
      console.log('Invalid form. Please check the fields.');
    }
  }


  passwordMatchValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.get('password');
    const confirmPassword = control.get('confirmPassword');

    if (password && confirmPassword && password.value !== confirmPassword.value) {
      return { 'passwordMismatch': true };
    }

    return null;
  }


  get usernameControl(): FormControl {
    return this.registrationForm.get('username') as FormControl;
  }

  get passwordControl(): FormControl {
    return this.registrationForm.get('password') as FormControl;
  }

  get emailControl(): FormControl {
    return this.registrationForm.get('email') as FormControl;
  }

  get confirmPasswordControl(): FormControl {
    return this.registrationForm.get('confirmPassword') as FormControl;
  }
}
