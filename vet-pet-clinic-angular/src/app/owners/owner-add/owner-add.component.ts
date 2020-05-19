import { Component, OnInit } from '@angular/core';
import {Form, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {NgModule} from '@angular/core';
import {OwnerService} from '../owner.service';
import {Router} from '@angular/router';
import {Owner} from '../owner';

@Component({
  selector: 'app-owner-add',
  templateUrl: './owner-add.component.html',
  styleUrls: ['./owner-add.component.css']
})
export class OwnerAddComponent implements OnInit {

  ownerForm: FormGroup;
  owner: Owner;
  errorMessage: string;
  constructor(private fb: FormBuilder, private ownerService: OwnerService, private router: Router) {
    this.owner = {} as Owner;

    this.ownerForm = this.fb.group({
      firstName: ['', Validators.required, Validators.maxLength(2)],
      lastName : ['', Validators.required, Validators.maxLength(2)],
      address: this.fb.group({
        address1: ['', Validators.required, Validators.maxLength(6)],
        city: ['', Validators.required, Validators.maxLength(4), selectedCities],
        telephone: ['', Validators.required , Validators.pattern('[0-9&&[^A-Z]&&[^a-z]]{10}')]
      })

    });

  }

  ngOnInit() {
  }

  onSubmit(owner: Owner) {
    owner.id = null;
    this.ownerService.addOwner(owner).subscribe(
      newOwner => {
        this.owner = newOwner;
        this.gotoOwnersList();
      },
      error => this.errorMessage = error as any
    );
  }

  gotoOwnersList() {
    this.router.navigate(['/owners']);
  }

}

function selectedCities( input: FormControl) {

  const cities = ['St.Louis', 'Kansas City', 'Columbia'];
  return cities.includes(input.value) ? null : { noCity: true };




}
