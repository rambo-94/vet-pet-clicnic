import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VisitAddComponent } from './visit-add/visit-add.component';
import { VisitEditComponent } from './visit-edit/visit-edit.component';
import { VisitListComponent } from './visit-list/visit-list.component';
import {VisitService} from './visit.service';
import {FormsModule} from '@angular/forms';
import {MatDatepickerModule} from '@angular/material';
import {VisitRoutingModule} from './visit-routing/visit-routing.module';



@NgModule({
  declarations: [VisitAddComponent, VisitEditComponent, VisitListComponent],
  imports: [
    CommonModule,
    FormsModule,
    MatDatepickerModule,
    VisitRoutingModule
  ],
  providers : [VisitService]
})
export class VisitsModule { }
