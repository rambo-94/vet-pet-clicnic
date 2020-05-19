import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PetAddComponent } from './pet-add/pet-add.component';
import { PetEditComponent } from './pet-edit/pet-edit.component';
import { PetListComponent } from './pet-list/pet-list.component';



@NgModule({
  declarations: [PetAddComponent, PetEditComponent, PetListComponent],
  imports: [
    CommonModule
  ]
})
export class PetsModule { }
