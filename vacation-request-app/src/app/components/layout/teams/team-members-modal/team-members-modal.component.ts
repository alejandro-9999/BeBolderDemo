import { Component, Input, OnInit } from '@angular/core';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@Component({
  selector: 'app-team-members-modal',
  templateUrl: './team-members-modal.component.html',
  styleUrls: ['./team-members-modal.component.scss']
})
export class TeamMembersModalComponent implements OnInit{
  @Input() members: any[] = [];

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig) {}

  ngOnInit(): void {
    this.members = this.config.data;
  }

  employeeOptionLabelTemplate(employee: any) : string {
    return `${employee.firstName} ${employee.lastName}`;
  }
}
