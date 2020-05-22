import { Injectable } from '@angular/core';
import {HandleError, HttpErrorHandler} from '../error.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Visit} from './visit';
import {catchError} from 'rxjs/operators';

@Injectable()
export class VisitService {

  private entityUrl = 'https://localhost:8080' + 'visits';

  private readonly handlerError: HandleError;

  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('OwnerService');
  }

  getVisits(): Observable<Visit[]> {
    return this.http.get<Visit[]>(this.entityUrl)
      .pipe(
        catchError(this.handlerError('getVisits', []))
      );
  }

  getVisitById(visitId: string): Observable<Visit> {
    return this.http.get<Visit>(this.entityUrl + '/' + visitId)
      .pipe(
        catchError(this.handlerError('getVisitById', {} as Visit))
      );
  }

  addVisit(visit: Visit): Observable<Visit> {
    return this.http.post<Visit>(this.entityUrl, visit)
      .pipe(
        catchError(this.handlerError('addVisit', visit))
      );
  }

  updateVisit(visitId: string, visit: Visit): Observable<Visit> {
    return this.http.put<Visit>(this.entityUrl + '/' + visitId, visit)
      .pipe(
        catchError(this.handlerError('updateVisit', visit))
      );
  }

  deleteVisit(visitId: string): Observable<number> {
    return this.http.delete<number>(this.entityUrl + '/' + visitId)
      .pipe(
        catchError(this.handlerError('deleteVisit', 0))
      );

  }

}
