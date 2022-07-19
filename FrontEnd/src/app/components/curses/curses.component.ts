import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cursos } from 'src/app/models/cursos';
import { CursosService } from 'src/app/servicios/cursos.service';

@Component({
  selector: 'app-curses',
  templateUrl: './curses.component.html',
  styleUrls: ['./curses.component.css']
})
export class CursesComponent implements OnInit {
  
  public cursos:Cursos[]=[];
  public editCurso:Cursos | undefined;
  public deleteCurso:Cursos | undefined;

  constructor(private cursosService:CursosService) { }

  ngOnInit(): void {
    this.getCursos();
  }

  public getCursos():void{
    this.cursosService.getCursos().subscribe({
      next:(Response: Cursos[]) => {
        this.cursos=Response;
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
    })
  }

  public onOpenModal(mode:String, curso?: Cursos):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addCursosModal');
    } else if(mode==='delete'){
      this.deleteCurso=curso;
      button.setAttribute('data-target', '#deleteCursosModal');
    } else if (mode==='edit'){
      this.editCurso=curso;
      button.setAttribute('data-target', '#editCursosModal')

    }
    container?.appendChild(button);
    button.click();
  }
  public onAddCurso(addForm: NgForm){
    document.getElementById('add-education-form')?.click();
    this.cursosService.addCurso(addForm.value).subscribe({
      next:(response: Cursos) =>{
        console.log(response);
        this.getCursos()
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
         
      }
    })
  }

public onUpdateCurso(curso: Cursos){
  document.getElementById('add-cursos-form')?.click();
  this.cursosService.updateCurso(curso).subscribe({
    next:(response: Cursos) =>{
      console.log(response);
      this.getCursos()
    }, 
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
}

public onDeleteCurso(idCurso: number):void{
  
  this.cursosService.deleteCurso(idCurso).subscribe({
    next:(response:void) =>{
      console.log(response);
      this.getCursos()
    }, error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }
}