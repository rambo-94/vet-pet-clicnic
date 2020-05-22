import { Component, OnInit } from '@angular/core';
import {Specialty} from '../../specialities/specialty';
import {SpecialtyService} from '../../specialities/specialty.service';
import {Router} from '@angular/router';
import {VetService} from '../vet.service';
import {Vet} from '../vets';

@Component({
  selector: 'app-vets-add',
  templateUrl: './vets-add.component.html',
  styleUrls: ['./vets-add.component.css']
})
export class VetsAddComponent implements OnInit {

  vet: Vet;
  specialtiesList: Specialty[];
  selectedSpecialty: Specialty;
  errorMessage: string;

  constructor(private specialtyService: SpecialtyService, private vetService: VetService, private router: Router) {
    this.vet = {} as Vet;
    this.selectedSpecialty = {} as Specialty;
    this.specialtiesList = [];
  }

  ngOnInit() {
    this.specialtyService.getSpecialties().subscribe(
      specialties => this.specialtiesList = specialties,
      error => this.errorMessage = error as any
    );
  }

  onSubmit(vet: Vet) {
    vet.id = null;
    vet.specialties = [];
    if (this.selectedSpecialty.id !== undefined) {
      vet.specialties.push(this.selectedSpecialty);
    }
    this.vetService.addVet(vet).subscribe(
      newVet => {
        this.vet = newVet;
        this.gotoVetList();
      },
      error => this.errorMessage = error as any
    );
  }

  gotoVetList() {
    this.router.navigate(['/vets']);
  }


}
