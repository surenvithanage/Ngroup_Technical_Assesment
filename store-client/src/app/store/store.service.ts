import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Store } from './store';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  private apiURL = "http://localhost:9090/api/v1/store";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this.httpClient.get(this.apiURL + '/list')
      .pipe(
        catchError(this.errorHandler)
      )
  }

  create(store: Store): Observable<any> {
    return this.httpClient.post(this.apiURL + '/insert', store, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  find(id: any): Observable<any> {
    return this.httpClient.get(this.apiURL + '/find/' + id)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  update(store: Store): Observable<any> {
    return this.httpClient.put(this.apiURL + '/update', store, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  delete(id: string) {
    return this.httpClient.delete(this.apiURL + '/delete/' + id, this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }


  errorHandler(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}