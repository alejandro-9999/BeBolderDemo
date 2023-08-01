import { Component, OnInit } from '@angular/core';
import { TeamService } from 'src/app/services/Team/team.service';
import { DialogService } from 'primeng/dynamicdialog';
import { TeamMembersModalComponent } from '../../layout/teams/team-members-modal/team-members-modal.component';
import { AddMemberModalComponent } from '../../layout/teams/add-member-modal/add-member-modal.component';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit{
  teams: any[] = []; // Cambia el tipo de datos por el que realmente estés utilizando para los equipos

  constructor(private teamService: TeamService, private dialogService: DialogService) {}

  ngOnInit() {
    this.loadTeams();
    this.teamService.teamCreated.subscribe(()=>{
      this.loadTeams();
    });
  }

  loadTeams() {
    this.teamService.getAllTeams().subscribe(
      (data) => {
        this.teams = data;
      },
      (error) => {
        console.error('Error fetching teams:', error);
      }
    );
  }

  showMembersModal(team: any) {
    const ref = this.dialogService.open(TeamMembersModalComponent, {
      header: 'Integrantes del Equipo',
      data: team.members
    });
  }

  openAddMemberModal(teamId: number) {
    console.log(teamId);

    const ref = this.dialogService.open(AddMemberModalComponent, {
      header: 'Agregar Miembro al Equipo',
      data: { teamId: teamId } // Asegúrate de que la clave sea 'teamId'
    });

    ref.onClose.subscribe((data) => {
      if (data) {
        // Si se ha agregado un miembro, actualiza la lista de equipos
        this.loadTeams();
      }
    });
  }

}
