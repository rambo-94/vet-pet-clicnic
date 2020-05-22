import {RouterModule, Routes} from '@angular/router';
import {VetsListComponent} from '../vets-list/vets-list.component';
import {VetsAddComponent} from '../vets-add/vets-add.component';
import {VetsEditComponent} from '../vets-edit/vets-edit.component';
import {NgModule} from '@angular/core';
import {VetResolver} from '../vet-resolver';
import {SpecsResolver} from '../../specialities/specs-resolver';

const vetRoutes: Routes = [
  {path: 'vets', component: VetsListComponent},
  {path: 'vets/add', component: VetsAddComponent},
  {path: 'vets/:id/edit', component: VetsEditComponent, resolve: {vet: VetResolver, specs: SpecsResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(vetRoutes)],
  exports: [RouterModule]
})
export class VetsRoutingModule { }
