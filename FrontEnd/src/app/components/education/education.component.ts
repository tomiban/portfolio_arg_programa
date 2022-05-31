import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Educacion } from 'src/app/models/educacion';
import { EducacionService } from 'src/app/servicios/educacion.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  
  public educacion:Educacion[]=[];
  public editEducation:Educacion | undefined;
  public deleteEducation:Educacion | undefined;

  constructor(private educacionService:EducacionService) { }

  ngOnInit(): void {
    this.getEducations();
  }

  public getEducations():void{
    this.educacionService.getEducation().subscribe({
      next:(Response: Educacion[]) => {
        this.educacion=Response;
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
    })
  }

  public onOpenModal(mode:String, education?: Educacion):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addEducationModal');
    } else if(mode==='delete'){
      this. deleteEducation=education;
      button.setAttribute('data-target', '#deleteEducationModal');
    } else if (mode==='edit'){
      this.editEducation=education;
      button.setAttribute('data-target', '#editEducationModal')

    }
    container?.appendChild(button);
    button.click();
  }
  public onAddEducation(addForm: NgForm){
    document.getElementById('add-education-form')?.click();
    this.educacionService.addEducation(addForm.value).subscribe({
      next:(response: Educacion) =>{
        console.log(response);
        this.getEducations()
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
         
      }
    })
  }


public onUpdateEducation(education: Educacion){
  this.editEducation=education;
  document.getElementById('add-education-form')?.click();
  this.educacionService.updateEducation(education).subscribe({
    next:(response: Educacion) =>{
      console.log(response);
      this.getEducations()
    }, 
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
}

public onDeleteEducation(idEdu: number):void{
  
  this.educacionService.deleteEducation(idEdu).subscribe({
    next:(response:void) =>{
      console.log(response);
      this.getEducations()
    }, error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }
}
