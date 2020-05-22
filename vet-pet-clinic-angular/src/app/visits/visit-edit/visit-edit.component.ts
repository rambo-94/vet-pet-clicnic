import { Component, OnInit } from '@angular/core';
import {Visit} from '../visit';
import {Pet} from '../../pets/pet';
import {Owner} from '../../owners/owner';
import {PetType} from '../../pettypes/pettype';
import {VisitService} from '../visit.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-visit-edit',
  templateUrl: './visit-edit.component.html',
  styleUrls: ['./visit-edit.component.css']
})
export class VisitEditComponent implements OnInit {

  visit: Visit;
  currentPet: Pet;
  currentOwner: Owner;
  currentPetType: PetType;
  updateSuccess = false;
  errorMessage: string;

  constructor(private visitService: VisitService, private route: ActivatedRoute, private router: Router) {
    this.visit = {} as Visit;
    this.currentPet = {} as Pet;
    this.currentOwner = {} as Owner;
    this.currentPetType = {} as PetType;
  }

  ngOnInit() {
    const visitId = this.route.snapshot.params.id;
    this.visitService.getVisitById(visitId).subscribe(
      response => {
        this.visit = response;

        this.currentPet = this.visit.pet;
        this.currentPetType = this.currentPet.petType;
        this.currentOwner = this.currentPet.owner;
      },
      error => this.errorMessage = error as any);
  }

  onSubmit(visit: Visit) {
    visit.pet = this.currentPet;

    // format output from datepicker to short string yyyy/mm/dd format


    this.visitService.updateVisit(visit.id.toString(), visit).subscribe(
      res => this.gotoOwnerDetail(),
      error => this.errorMessage = error as any);

  }

  gotoOwnerDetail() {
    this.router.navigate(['/owners', this.currentOwner.id]);
  }

}


