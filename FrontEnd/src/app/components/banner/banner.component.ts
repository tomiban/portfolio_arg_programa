import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { HeaderService } from 'src/app/servicios/header.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  public usuario : Usuario | undefined;
  public editUsuario: Usuario | undefined;

  constructor(private headerService : HeaderService, private tokenService: TokenService) { }

  isLogged = false;
  ngOnInit(): void {
    this.getUser();
    if(this.tokenService.getToken()){
      this.isLogged = true;
  } else{
    this.isLogged = false;
  }
}

  public getUser():void{
    this.headerService.getUser().subscribe({
      next: (response: Usuario) =>{
        this.usuario=response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode:String, user?: Usuario):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addUsuarioModal');
    } else if(mode==='delete'){
      this.editUsuario=user;
      button.setAttribute('data-target', '#deleteUsuarioModal');
    } else if (mode==='edit'){
      this.editUsuario=user;
      button.setAttribute('data-target', '#editUsuarioModal')

    }
    container?.appendChild(button);
    button.click();
  }

  public onUpdateUsuario(usuario: Usuario){
    document.getElementById('add-usuario-form')?.click();
    this.headerService.updateUsuario(usuario).subscribe({
      next:(response: Usuario) =>{
        console.log(response);
        this.getUser()
      }, 
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }
}
