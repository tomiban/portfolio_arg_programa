import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyectos } from '../models/proyectos';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  private apiServerUrl = "https://argprogramatbtest.herokuapp.com";
  constructor(private http:HttpClient) { }

  public getProyectos():Observable<Proyectos[]>{
    return this.http.get<Proyectos[]>(`${this.apiServerUrl}/proyectos/all`);
  }

  public addProyecto(proyecto: Proyectos): Observable<Proyectos>{
    return this.http.post<Proyectos>(`${this.apiServerUrl}/proyectos/add`, proyecto );
  }

  public updateProyecto(proyecto: Proyectos):Observable<Proyectos>{
    return this.http.put<Proyectos>(`${this.apiServerUrl}/proyectos/update`, proyecto);
  }

  public deleteProyecto(proyectoId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/proyectos/delete/${proyectoId}`);
  }

}
