
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {VetService} from './vet.service';
import {Vet} from './vets';

/**
 * @author Vitaliy Fedoriv
 */

@Injectable()
export class VetResolver implements Resolve<Vet> {

  constructor(private vetService: VetService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Vet> | Promise<Vet> | Vet {
    return this.vetService.getVetById(route.paramMap.get('id'));
  }

}
