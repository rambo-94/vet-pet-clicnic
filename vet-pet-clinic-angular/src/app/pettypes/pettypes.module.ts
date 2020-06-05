import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PettypeAddComponent } from './pettype-add/pettype-add.component';
import { PettypeEditComponent } from './pettype-edit/pettype-edit.component';
import { PettypeListComponent } from './pettype-list/pettype-list.component';
import {FormsModule} from '@angular/forms';
import {PetService} from '../pets/pet.service';


@NgModule({
  declarations: [PettypeAddComponent, PettypeEditComponent, PettypeListComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [PetService]
})
export class PettypesModule { }
