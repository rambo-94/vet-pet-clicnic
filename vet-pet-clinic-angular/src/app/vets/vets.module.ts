import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VetsAddComponent } from './vets-add/vets-add.component';
import {VetService} from './vet.service';
import { VetsEditComponent } from './vets-edit/vets-edit.component';
import { VetsListComponent } from './vets-list/vets-list.component';
import { MatSelectModule} from '@angular/material';
import {VetResolver} from './vet-resolver';
import {VetsRoutingModule} from './vets-routing/vets-routing.module';


@NgModule({
  declarations: [VetsAddComponent, VetsEditComponent, VetsListComponent],
  imports: [
    CommonModule,
    MatSelectModule,
    VetsRoutingModule
  ],
  providers: [VetService, VetResolver]
})
export class VetsModule { }
