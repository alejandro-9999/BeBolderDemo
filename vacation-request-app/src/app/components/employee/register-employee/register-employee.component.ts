import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-employee',
  templateUrl: './register-employee.component.html',
  styleUrls: ['./register-employee.component.scss']
})
export class RegisterEmployeeComponent {

  documentTypes = [
    { name: "Cedula de ciudadania", code: "CC" },
    { name: "Cedula de extrangeria", code: "CE" },
    { name: "Tarjeta de identidad", code: "TI" }];

  employeeForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.employeeForm = this.formBuilder.group({
      document: ['', Validators.required],
      documentType: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNumber: ['', [Validators.required]],
      address: ['', Validators.required],
      dateOfEntry: ['', Validators.required],
      typeOfContract: ['Labor Contract', Validators.required]
    });
  }

  ngOnInit() {}

  onSubmit() {
    if (this.employeeForm.valid) {
      // Perform actions when the form is valid
      const formData = this.employeeForm.value;
      console.log(formData);
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
