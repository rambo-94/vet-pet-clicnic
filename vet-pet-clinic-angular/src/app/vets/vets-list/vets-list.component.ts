import { Component, OnInit } from '@angular/core';
import {Vet} from '../vets';
import {VetService} from '../vet.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-vets-list',
  templateUrl: './vets-list.component.html',
  styleUrls: ['./vets-list.component.css']
})
export class VetsListComponent implements OnInit {

  vets: Vet[];
  errorMessage: string;
  responseStatus: number;

  constructor(private vetService: VetService, private router: Router) {
    this.vets = [];
  }

  ngOnInit() {
    this.vetService.getVets().subscribe(
      vets => this.vets = vets,
      error => this.errorMessage = error as any);
  }

  deleteVet(vet: Vet) {
    this.vetService.deleteVet(vet.id.toString()).subscribe(
      response => {
        this.responseStatus = response;
        this.vets = this.vets.filter(currentItem => !(currentItem.id === vet.id));
      },
      error => this.errorMessage = error as any);
  }

  gotoHome() {
    this.router.navigate(['/welcome']);
  }

  addVet() {
    this.router.navigate(['/vets/add']);
  }

  editVet(vet: Vet) {
    this.router.navigate(['/vets', vet.id, 'edit']);
  }
}


