import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PetAddComponent } from './pet-add/pet-add.component';
import { PetEditComponent } from './pet-edit/pet-edit.component';
import { PetListComponent } from './pet-list/pet-list.component';
import {FormsModule} from '@angular/forms';
import {MatDatepickerModule} from '@angular/material';
import {PetsRoutingModule} from './pets-routing.module';
import {PetService} from './pet.service';


@NgModule({
  declarations: [PetAddComponent, PetEditComponent, PetListComponent],
  exports: [
    PetListComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    MatDatepickerModule,
    PetsRoutingModule

  ],
  providers: [PetService]
})
export class PetsModule { }
