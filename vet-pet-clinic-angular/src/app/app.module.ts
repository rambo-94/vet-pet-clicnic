import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {OwnersModule} from './owners/owners.module';

import { AppComponent } from './app.component';
import {PetsModule} from './pets/pets.module';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    PetsModule,
    OwnersModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
