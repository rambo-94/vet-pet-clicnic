import {Injectable} from '@angular/core';
import {Owner} from './owner';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {HandleError, HttpErrorHandler} from '../error.service';


@Injectable()
export class OwnerService {

  entityUrl = 'http://localhost:8080/' + 'owners';

  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('OwnerService');
  }

  getOwners(): Observable<Owner[]> {
    return this.http.get<Owner[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getOwners', []))
      );
  }

  getOwnerById(ownerId: string): Observable<Owner> {
    return this.http.get<Owner>(this.entityUrl + '/' + ownerId)
      .pipe(
        catchError(this.handlerError('getOwnerById', {} as Owner))
      );
  }

  addOwner(owner: Owner): Observable<Owner> {
    return this.http.post<Owner>(this.entityUrl, owner)
      .pipe(
        catchError(this.handlerError('addOwner', owner))
      );
  }

  updateOwner(ownerId: string, owner: Owner): Observable<{}> {
    return this.http.put<Owner>(this.entityUrl + '/' + ownerId, owner)
      .pipe(
        catchError(this.handlerError('updateOwner', owner))
      );
  }

  deleteOwner(ownerId: string): Observable<{}> {
    return this.http.delete<Owner>(this.entityUrl + '/' + ownerId)
      .pipe(
        catchError(this.handlerError('deleteOwner', [ownerId]))
      );
  }


}
