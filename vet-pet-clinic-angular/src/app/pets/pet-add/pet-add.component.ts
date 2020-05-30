import {Component, Input, OnInit} from '@angular/core';
import {Pet} from '../pet';
import {OwnerService} from '../../owners/owner.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Owner} from '../../owners/owner';
import {PetType} from '../../pettypes/pettype';
import {PetService} from '../pet.service';
import {PetTypeService} from '../../pettypes/pet.service';

@Component({
  selector: 'app-pet-add',
  templateUrl: './pet-add.component.html',
  styleUrls: ['./pet-add.component.css']
})
export class PetAddComponent implements OnInit {

  pet: Pet;
  @Input() currentType: PetType;
  currentOwner: Owner;
  petTypes: PetType[];
  addedSuccess = false;
  errorMessage: string;

  constructor(private ownerService: OwnerService, private petService: PetService,
              private petTypeService: PetTypeService, private router: Router, private route: ActivatedRoute) {
    this.pet = {} as Pet;
    this.currentOwner = {} as Owner;
    this.currentType = {} as PetType;
    this.petTypes = [];
  }

  ngOnInit() {
    this.petTypeService.getPetTypes().subscribe(
      pettypes => this.petTypes = pettypes,
      error => this.errorMessage = error as any);

    const ownerId = this.route.snapshot.params.id;
    this.ownerService.getOwnerById(ownerId).subscribe(
      response => {
        this.currentOwner = response;
      },
      error => this.errorMessage = error as any);
  }

  onSubmit(pet: Pet) {
    pet.id = null;
    pet.owner = this.currentOwner;
    // format output from datepicker to short string yyyy/mm/dd format
    this.petService.addPet(pet).subscribe(
      newPet => {
        this.pet = newPet;
        this.addedSuccess = true;
        this.gotoOwnerDetail();
      },
      error => this.errorMessage = error as any);
  }

  gotoOwnerDetail() {
    this.router.navigate(['/owners', this.currentOwner.id]);
  }

}
