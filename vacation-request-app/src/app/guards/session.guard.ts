import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree,Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionGuard implements CanActivate {
  constructor(private router: Router){};
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      const currentUser = localStorage.getItem('currentUser');
      if (currentUser) {
        // La sesión del usuario existe, permitir el acceso a la ruta
        const currentEmployee = localStorage.getItem('currentEmployee');
        if(currentEmployee){
          return true;
        }
        this.router.navigate(['/register/employee']);
        return false;
      } else {
        // La sesión del usuario no existe, redirigir a la página de inicio de sesión o mostrar mensaje de error
        this.router.navigate(['/login']); // Asegúrate de tener esta ruta configurada en tu aplicación
        return false;
      }
  }

}
