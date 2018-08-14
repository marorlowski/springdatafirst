import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {Employee} from "./dto/dto";
import {Observable, Subject, throwError} from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpErrorResponse} from "@angular/common/http";

@Injectable()
export class EmployeeService {

  private employeeUrl = 'api/';
  private headers = new Headers({'Content-Type': 'application/json'});

  // private handleError:;

  constructor(private http: Http) {
  }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get('api/empl')
      .map(resp => resp.json())
      .catch(this.handleError);
  }

  public sendClick(zmienna: string) {
    return this.http.get(`api/testClic/${zmienna}`).subscribe();
  }

  extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.log('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.log(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

}
