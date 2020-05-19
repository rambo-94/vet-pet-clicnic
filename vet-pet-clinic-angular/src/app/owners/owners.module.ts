import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwnerAddComponent } from './owner-add/owner-add.component';
import { OwnerDetailComponent } from './owner-detail/owner-detail.component';
import { OwnerEditComponent } from './owner-edit/owner-edit.component';
import { OwnerListComponent } from './owner-list/owner-list.component';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {OwnersRoutingModule} from './owner-routing.moudle';
import {OwnerService} from './owner.service';

@NgModule({
  declarations: [OwnerAddComponent, OwnerDetailComponent, OwnerEditComponent, OwnerListComponent],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        OwnersRoutingModule,
        FormsModule
    ],
  providers : [OwnerService],

})
export class OwnersModule { }
