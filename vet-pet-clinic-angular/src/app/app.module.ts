import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {OwnersModule} from './owners/owners.module';

import { AppComponent } from './app.component';
import {PetsModule} from './pets/pets.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    PetsModule,
    OwnersModule,
    BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
