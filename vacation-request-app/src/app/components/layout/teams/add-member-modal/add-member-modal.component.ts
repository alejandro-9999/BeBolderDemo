import { EmployeeService } from 'src/app/services/Employee/employee.service';
import { Component, Input, OnInit } from '@angular/core';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { TeamService } from 'src/app/services/Team/team.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-member-modal',
  templateUrl: './add-member-modal.component.html',
  styleUrls: ['./add-member-modal.component.scss']
})
export class AddMemberModalComponent implements OnInit {


  @Input() teamId: number = 0 ;

  employees: any[] = []; // Cambia el tipo de datos por el que uses para los empleados

  addMemberForm: FormGroup;

  constructor(
    public ref: DynamicDialogRef,
    private formBuilder: FormBuilder,
    private employeService: EmployeeService,
    public config: DynamicDialogConfig
  ) {
    this.addMemberForm = this.formBuilder.group({
      selectedEmployeeId: new FormControl('', Validators.required)
    });
  }

  ngOnInit(): void {
    this.teamId = this.config.data?.teamId??0;
    this.loadEmployees();
  }

  loadEmployees() {
    // Utiliza el TeamService para obtener la lista de empleados
    this.employeService.getAllEmployees().subscribe(
      (data) => {
        this.employees = data;
      },
      (error) => {
        console.error('Error fetching employees:', error);
      }
    );
  }

  addMemberToTeam() {
    if (this.addMemberForm.invalid) {
      return;
    }
    const selectedEmployeeId = this.addMemberForm.get('selectedEmployeeId')?.value;
    // Utiliza el TeamService para agregar un miembro al equipo
    this.employeService.addTeam(this.teamId, selectedEmployeeId?.employeeId??0).subscribe(
      (data) => {
        // Notificar al componente ListComponent que se ha agregado un miembro
        this.ref.close(data);
      },
      (error) => {
        console.error('Error adding member to team:', error);
      }
    );
  }

  employeeOptionLabelTemplate(employee: any) : string {
    return `${employee.firstName} ${employee.lastName}`;
  }

  cancel() {
    this.ref.close();
  }
}
