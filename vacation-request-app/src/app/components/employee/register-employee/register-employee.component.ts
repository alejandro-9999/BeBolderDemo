import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/Employee/employee.service';

@Component({
  selector: 'app-register-employee',
  templateUrl: './register-employee.component.html',
  styleUrls: ['./register-employee.component.scss']
})
export class RegisterEmployeeComponent {

  isLoading: boolean = false;
  messages: any[] = [];
  user: number;

  documentTypes = [
    { name: "Cedula de ciudadania", code: "CC" },
    { name: "Cedula de extrangeria", code: "CE" },
    { name: "Tarjeta de identidad", code: "TI" }];

  employeeForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService, private router: Router) {
    this.employeeForm = this.formBuilder.group({
      user: [''],
      document: ['', Validators.required],
      documentType: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNumber: ['', [Validators.required]],
      address: ['', Validators.required],
      dateOfEntry: ['', Validators.required],
      typeOfContract: ['Labor Contract', Validators.required]
    });
    const currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');
    this.user = parseInt(currentUser.userId || '0', 10);
    this.employeeForm.get('user')?.setValue(this.user);
  }

  ngOnInit() {}

  onSubmit() {

    this.isLoading = true;
    this.messages = [];

    if (this.employeeForm.valid) {
      const formData = this.employeeForm.value;
      this.employeeService.saveEmployee(formData).subscribe(
        (response) => {
          this.isLoading = false;
          this.messages = [{ severity: 'success', summary: 'Success', detail: 'Completed Registration' }];
          localStorage.setItem('currentEmployee', JSON.stringify(response));
          this.router.navigate(['/dashboard']);
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

  get documentControl(): FormControl {
    return this.employeeForm.get('document') as FormControl;
  }

  get documentTypeControl(): FormControl {
    return this.employeeForm.get('documentType') as FormControl;
  }

  get firstNameControl(): FormControl {
    return this.employeeForm.get('firstName') as FormControl;
  }

  get lastNameControl(): FormControl {
    return this.employeeForm.get('lastName') as FormControl;
  }

  get phoneNumberControl(): FormControl {
    return this.employeeForm.get('phoneNumber') as FormControl;
  }

  get addressControl(): FormControl {
    return this.employeeForm.get('address') as FormControl;
  }

  get dateOfEntryControl(): FormControl {
    return this.employeeForm.get('dateOfEntry') as FormControl;
  }

  get typeOfContractControl(): FormControl {
    return this.employeeForm.get('typeOfContract') as FormControl;
  }
}
