import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})


export class NavbarComponent implements OnInit {

  currentUser: any;
  menuItems: MenuItem[] = [];

  ngOnInit(){
    this.currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');

    this.menuItems = [
      {
        label: 'Solicitud Vacaciones',
        icon: 'pi pi-fw pi-calendar',
        routerLink: '/vacation/request',
      },
      {
        label: 'Aprobación de Solicitudes',
        icon: 'pi pi-fw pi-check-circle',
        routerLink: '/vacation/approval',
      },
      {
        label: 'Equipos',
        icon: 'pi pi-fw pi-users',
        routerLink: '/teams',
      }
    ];
  }

  logout(){

  }
}

