import { Component, OnInit } from '@angular/core';
import {Specialty} from '../specialty';
import {SpecialtyService} from '../specialty.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-speciality-edit',
  templateUrl: './speciality-edit.component.html',
  styleUrls: ['./speciality-edit.component.css']
})
export class SpecialityEditComponent implements OnInit {

  specialty: Specialty;
  errorMessage: string;

  constructor(private specialtyService: SpecialtyService, private route: ActivatedRoute, private router: Router) {
    this.specialty = {} as Specialty;
  }

  ngOnInit() {
    const specId = this.route.snapshot.params.id;
    this.specialtyService.getSpecialtyById(specId).subscribe(
      specialty => this.specialty = specialty,
      error => this.errorMessage = error as any);
  }

  onSubmit(specialty: Specialty) {
    this.specialtyService.updateSpecialty(specialty.id.toString(), specialty).subscribe(
      res => {
        console.log('update success');
        this.onBack();
      },
      error => this.errorMessage = error as any);
  }

  onBack() {
    this.router.navigate(['/specialties']);
  }

}


