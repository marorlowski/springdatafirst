import {Component, OnInit} from '@angular/core';
import {Employee} from "../dto/dto";
import {EmployeeService} from "../employee.service";
import {error} from "util";


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  selectedEmployee: Employee;
  errorMessage: String;
  cols: any[];

  constructor(private emplServ: EmployeeService) {
  }

  ngOnInit() {
    this.getEmployee();

    this.cols = [
      {field: 'id', header: 'Nr ID'},
      {field: 'firstName', header: 'Imię'},
      {field: 'lastName', header: 'Nazwisko'}
    ];
  }

  getEmployee() {
    this.emplServ.getEmployees()
      .subscribe(
        empl => this.employees = empl,
        error => this.errorMessage = <any>error
      );
  }

  buttonClick(eve) {
    console.log("działa przycisk");
    this.emplServ.sendClick("działa przycisk z Angulara");


  }
}
