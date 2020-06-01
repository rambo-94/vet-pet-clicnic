import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Pet} from './pet';
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {HandleError, HttpErrorHandler} from '../error.service';

@Injectable()
export class PetService {

  private entityUrl = 'https://localhost:8080' + 'pets';

  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('OwnerService');
  }

  getPets(): Observable<Pet[]> {
    return this.http.get<Pet[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getPets', []))
      );
  }

  getPetById(petId: string): Observable<Pet> {
    return this.http.get<Pet>(this.entityUrl + '/' + petId)
      .pipe(
        catchError(this.handlerError('getPetById', {} as Pet))
      );
  }

  addPet(pet: Pet): Observable<Pet> {
    return this.http.post<Pet>(this.entityUrl, pet)
      .pipe(
        catchError(this.handlerError('addPet', pet))
      );
  }

  updatePet(petId: string, pet: Pet): Observable<Pet> {
    return this.http.put<Pet>(this.entityUrl + '/' + petId, pet)
      .pipe(
        catchError(this.handlerError('updatePet', pet))
      );
  }

  deletePet(petId: string): Observable<number> {
    return this.http.delete<number>(this.entityUrl + '/' + petId)
      .pipe(
        catchError(this.handlerError('deletePet', 0))
      );
  }

}
