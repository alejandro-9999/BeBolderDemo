import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-vacation-request',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent {
  vacationRequestForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.vacationRequestForm = this.formBuilder.group({
      days: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      employeeId: ['', Validators.required]
    });
  }

  ngOnInit() {
    // Set initial values for the form, if required
    this.setFormInitialValues();
  }

  onSubmit() {
    if (this.vacationRequestForm.valid) {
      // Realizar acciones cuando el formulario es válido
      const formData = this.vacationRequestForm.value;
      console.log(formData);
      // Aquí puedes enviar la solicitud de vacaciones al servidor o realizar otras acciones necesarias.
    } else {
      // Realizar acciones cuando el formulario es inválido
      console.log('Formulario inválido. Verifica los campos.');
    }
  }

  private setFormInitialValues() {
    const today = new Date();
    const endDate = new Date(today.getTime() + 15 * 24 * 60 * 60 * 1000); // 15 days from today

    this.vacationRequestForm.patchValue({
      days: 15,
      startDate: this.formatDate(today),
      endDate: this.formatDate(endDate),
      employeeId: 2
    });
  }

  private formatDate(date: Date): string {
    // Format date to 'YYYY-MM-DD' (e.g., '2023-01-01')
    const year = date.getFullYear();
    const month = this.addLeadingZero(date.getMonth() + 1);
    const day = this.addLeadingZero(date.getDate());
    return `${year}-${month}-${day}`;
  }

  private addLeadingZero(value: number): string {
    return value < 10 ? `0${value}` : `${value}`;
  }

  get daysControl() {
    return this.vacationRequestForm.get('days');
  }

  get startDateControl() {
    return this.vacationRequestForm.get('startDate');
  }

  get endDateControl() {
    return this.vacationRequestForm.get('endDate');
  }

  get employeeIdControl() {
    return this.vacationRequestForm.get('employeeId');
  }
}
