import {Component, OnInit} from '@angular/core';
import {Employee} from "../dto/dto";
import {EmployeeService} from "../employee.service";


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];
  filterEmployees: Employee[]=[];
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
      {field: 'lastName', header: 'Nazwisko'},
      {field: 'employmentDate', header: 'Data zatrudnienia'}
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
//TODO

    this.emplServ.getByName('Aaron').subscribe(value => this.filterEmployees = value);

    // this.filterEmployees.forEach(value => console.log(value.employmentDate));

    this.emplServ.getByName('Aaron').subscribe(value => this.employees = value);
    this.employees.forEach(value => console.log(value.employmentDate));

  }
}
