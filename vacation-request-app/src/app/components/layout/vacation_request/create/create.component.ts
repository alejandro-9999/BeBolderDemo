import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { VacationRequestService } from 'src/app/services/VacationRequest/vacation-request.service';

@Component({
  selector: 'app-create-vacation-request',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  vacationRequestForm: FormGroup;
  isLoading: boolean = false;
  messages: any[] = [];

  constructor(private formBuilder: FormBuilder, private vacationRequestService: VacationRequestService) {
    this.vacationRequestForm = this.formBuilder.group({
      startDate: [this.calculateStartDate(), Validators.required],
      endDate: ['', Validators.required],
    },
    {
      validators: [this.minVacationDaysValidator]
    }
    );
  }

  ngOnInit(): void {}

  onSubmit() {
    if (this.vacationRequestForm.valid) {
      // Realizar acciones cuando el formulario es válido
      const formData = this.vacationRequestForm.value;
      formData.employeeId = this.getCurrentEmployeeId();
      formData.days = this.calculateVacationDays(formData.startDate, formData.endDate);
      formData.status = "pending";

      this.vacationRequestService.createVacationRequest(formData).subscribe(
        (response) => {
          this.isLoading = false;
          this.messages = [{ severity: 'success', summary: 'Success', detail: 'Completed Registration' }];
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

      console.log(formData);
    } else {
      // Realizar acciones cuando el formulario es inválido
      console.log('Formulario inválido. Verifica los campos.');
    }
  }

  calculateStartDate(): string {
    // Obtener la fecha actual y agregar 15 días
    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() + 15);
    return currentDate.toISOString().substring(0, 10); // Convertir a formato YYYY-MM-DD
  }

  calculateVacationDays(startDate: string, endDate: string): number {
    // Calcular la cantidad de días entre las fechas de inicio y fin
    const start = new Date(startDate);
    const end = new Date(endDate);
    const timeDiff = Math.abs(end.getTime() - start.getTime());
    const days = Math.ceil(timeDiff / (1000 * 3600 * 24));
    return days + 1; // Sumar 1 para incluir el día de inicio en los días de vacaciones
  }

  getCurrentEmployeeId(): number {
    // Obtener el employeeId desde el localStorage (asegúrate de haberlo almacenado previamente)
    const currentEmployee = JSON.parse(localStorage?.getItem('currentEmployee')??'');
    return currentEmployee ? currentEmployee.employeeId : null;
  }

  get endDateControl(): FormControl {
    return this.vacationRequestForm.get('endDate') as FormControl;
  }

  minVacationDaysValidator(formGroup: FormGroup): { [s: string]: boolean } | null {
    const startDate =  new Date(formGroup.get('startDate')?.value);
    const endDate = new Date(formGroup.get('endDate')?.value);

    // Calcula la diferencia en días entre la fecha de inicio y la fecha de fin
    const timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
    const days = Math.ceil(timeDiff / (1000 * 3600 * 24));

    if (days < 6) {
      return { minVacationDays: true };
    }

    return null; // La validación es exitosa
  }

}
