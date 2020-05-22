import { Component, OnInit } from '@angular/core';
import {Specialty} from '../specialty';
import {SpecialtyService} from '../specialty.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-speciality-list',
  templateUrl: './speciality-list.component.html',
  styleUrls: ['./speciality-list.component.css']
})
export class SpecialityListComponent implements OnInit {

  specialties: Specialty[];
  errorMessage: string;
  responseStatus: number;
  isInsert = false;

  constructor(private specService: SpecialtyService, private router: Router) {
    this.specialties = [];
  }

  ngOnInit() {
    this.specService.getSpecialties().subscribe(
      specialties => this.specialties = specialties,
      error => this.errorMessage = error as any);
  }

  deleteSpecialty(specialty: Specialty) {
    this.specService.deleteSpecialty(specialty.id.toString()).subscribe(
      response => {
        this.responseStatus = response;
        this.specialties = this.specialties.filter(currentItem => !(currentItem.id === specialty.id));
      },
      error => this.errorMessage = error as any);
  }

  onNewSpecialty(newSpecialty: Specialty) {
    this.specialties.push(newSpecialty);
    this.showAddSpecialtyComponent();
  }

  showAddSpecialtyComponent() {
    this.isInsert = !this.isInsert;
  }

  showEditSpecialtyComponent(updatedSpecialty: Specialty) {
    this.router.navigate(['/specialties', updatedSpecialty.id.toString(), 'edit']);
  }

  gotoHome() {
    this.router.navigate(['/welcome']);
  }

}
