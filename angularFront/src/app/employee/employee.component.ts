import { Component, OnInit } from '@angular/core';
import {Employee} from "../dto/dto";
import {EmployeeService} from "../employee.service";
import {error} from "util";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees : Employee[];
  selectedEmployee: Employee;
  errorMessage: String;


  constructor(private emplServ: EmployeeService) { }

  ngOnInit() {
    this.getEmployee();
    console.log('getEmployee: '+this.employees);

  }

  getEmployee(){
    this.emplServ.getEmployees()
      .subscribe(
        empl=>this.employees=empl,
        error=>this.errorMessage = <any>error
      );
  }

}
