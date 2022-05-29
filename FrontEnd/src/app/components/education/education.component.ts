import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/models/educacion';
import { EducacionService } from 'src/app/servicios/educacion.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  public educacion:Educacion[]=[];

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

}
