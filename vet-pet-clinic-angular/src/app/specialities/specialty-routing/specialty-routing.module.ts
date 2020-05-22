
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SpecialityListComponent} from '../speciality-list/speciality-list.component';
import {SpecialityEditComponent} from '../speciality-edit/speciality-edit.component';

const specialtyRoutes: Routes = [
  {path: 'specialties', component: SpecialityListComponent},
  // {path: 'specialties/add', component: SpecialtyAddComponent},
  // {path: 'specialties/:id', component: SpecialtyDetailComponent},
  {path: 'specialties/:id/edit', component: SpecialityEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(specialtyRoutes)],
  exports: [RouterModule]
})

export class SpecialtiesRoutingModule {
}

@NgModule({
  imports: [RouterModule.forChild(specialtyRoutes)],
  exports: [RouterModule]
})
export class SpecialtyRoutingModule { }
