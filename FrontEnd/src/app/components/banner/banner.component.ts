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
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.getUser();
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
}
