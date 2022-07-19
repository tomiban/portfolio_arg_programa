import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Experiencia } from 'src/app/models/experiencia';
import { ExperienciaService } from 'src/app/servicios/experiencia.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {
  public experiencia:Experiencia[]=[];
  public editExperiencia:Experiencia | undefined;
  public deleteExperiencia:Experiencia | undefined;

  constructor(private experienciaService:ExperienciaService) { }

  ngOnInit(): void {
    this.getExperiencias();
  }

  public getExperiencias():void{
    this.experienciaService.getExperiencia().subscribe({
      next:(Response: Experiencia[]) => {
        this.experiencia=Response;
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
    })
  }

  public onOpenModal(mode:String, experiencia?: Experiencia):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addExperienciaModal');
    } else if(mode==='delete'){
      this.deleteExperiencia=experiencia;
      button.setAttribute('data-target', '#deleteExperienciaModal');
    } else if (mode==='edit'){
      this.editExperiencia=experiencia;
      button.setAttribute('data-target', '#editExperienciaModal')

    }
    container?.appendChild(button);
    button.click();
  }
  public onAddExperiencia(addForm: NgForm){
    document.getElementById('add-experiencia-form')?.click();
    this.experienciaService.addExperiencia(addForm.value).subscribe({
      next:(response: Experiencia) =>{
        console.log(response);
        this.getExperiencias()
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
         
      }
    })
  }

public onUpdateExperiencia(experiencia: Experiencia){
  document.getElementById('add-experiencia-form')?.click();
  this.experienciaService.updateExperiencia(experiencia).subscribe({
    next:(response: Experiencia) =>{
      console.log(response);
      this.getExperiencias()
    }, 
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
}

public onDeleteExperiencia(idEdu: number):void{
  
  this.experienciaService.deleteExperiencia(idEdu).subscribe({
    next:(response:void) =>{
      console.log(response);
      this.getExperiencias()
    }, error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }
}
