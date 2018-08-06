import {Injectable} from '@angular/core';
import {Http} from "@angular/http";
import {Employee} from "./dto/dto";
import {Observable} from "rxjs";

@Injectable()
export class EmployeeService {

  private employeeUrl = 'api/';
  private headers = new Headers({'Content-Type': 'application/json'});
  // private handleError:;

  constructor(private http: Http) {
  }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get('api/empl')
      .map(resp=>resp.json())
      .catch(this.handleErrorObservable);
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}
