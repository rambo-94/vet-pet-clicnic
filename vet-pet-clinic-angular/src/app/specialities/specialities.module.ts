import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpecialityAddComponent } from './speciality-add/speciality-add.component';
import { SpecialityEditComponent } from './speciality-edit/speciality-edit.component';
import { SpecialityListComponent } from './speciality-list/speciality-list.component';
import {FormsModule} from '@angular/forms';
import {SpecialtyService} from './specialty.service';
import {SpecialtiesRoutingModule} from './specialty-routing/specialty-routing.module';
import {SpecsResolver} from './specs-resolver';


@NgModule({
  declarations: [SpecialityAddComponent, SpecialityEditComponent, SpecialityListComponent],
    imports: [
        CommonModule,
        FormsModule,
      SpecialtiesRoutingModule
    ],
  providers: [SpecialtyService, SpecsResolver]
})
export class SpecialitiesModule { }
