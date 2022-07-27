import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Proyectos } from 'src/app/models/proyectos';
import { ProyectosService } from 'src/app/servicios/proyectos.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {

  public proyectos: Proyectos[]=[];
  public editProyectos: Proyectos | undefined;
  public deleteProyectos: Proyectos | undefined;

  constructor(private proService: ProyectosService, private tokenService: TokenService) { }

  isLogged = false;
  ngOnInit(): void {
    this.getProyectos();
    if(this.tokenService.getToken()){
      this.isLogged = true;
     } else {
      this.isLogged = false;
     }
  }

  public getProyectos():void{
    this.proService.getProyectos().subscribe({
      next:(Response: Proyectos[]) => {
        this.proyectos = Response;
      },
      error:(error: HttpErrorResponse) =>{
        alert(error.message);
      }
    })
  }

public onOpenModal(mode:String, proyecto?: Proyectos):void{
  const container=document.getElementById('main-container');
  const button=document.createElement('button');
  button.style.display='none';
  button.setAttribute('data-toggle', 'modal');
  if(mode==='add'){
    button.setAttribute('data-target', '#addProyectosModal');
  } else if(mode==='delete'){
    this.deleteProyectos=proyecto;
    button.setAttribute('data-target', '#deleteProyectosModal');
  } else if (mode==='edit'){
    this.editProyectos=proyecto;
    button.setAttribute('data-target', '#editProyectosModal')

  }
  container?.appendChild(button);
  button.click();
}


public onAddProyecto(addForm: NgForm){
  document.getElementById('add-proyectos-form')?.click();
  this.proService.addProyecto(addForm.value).subscribe({
    next:(response: Proyectos) =>{
      console.log(response);
      this.getProyectos()
      addForm.reset();
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
      addForm.reset();

    }
  })
}


public onUpdateProyectos(proyecto: Proyectos){
  document.getElementById('add-proyectos-form')?.click();
  this.proService.updateProyecto(proyecto).subscribe({
    next:(response: Proyectos) =>{
      console.log(response);
      this.getProyectos()
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }


  public onDeleteProyectos(idProyecto: number):void{

    this.proService.deleteProyecto(idProyecto).subscribe({
      next:(response:void) =>{
        console.log(response);
        this.getProyectos()
      }, error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
    }

}
