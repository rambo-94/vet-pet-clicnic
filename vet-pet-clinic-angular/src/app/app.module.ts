import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { OwnersComponent } from './onwers/owners/owners.component';
import { PetsComponent } from './pets/pets.component';
import { PettypesComponent } from './pettypes/pettypes.component';
import { SpecialtiesComponent } from './specialties/specialties.component';
import { VetsComponent } from './vets/vets.component';
import { VisitsComponent } from './visits/visits.component';
import { OwnerAddComponent } from './onwers/owner-add/owner-add.component';
import { PetAddComponent } from './pets/pet-add/pet-add.component';

@NgModule({
  declarations: [
    AppComponent,
    OwnersComponent,
    PetsComponent,
    PettypesComponent,
    SpecialtiesComponent,
    VetsComponent,
    VisitsComponent,
    OwnerAddComponent,
    PetAddComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
