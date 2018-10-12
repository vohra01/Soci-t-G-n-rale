import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService as EmployeeService} from '../service/employee-service.service';
import { Employee } from '../classes/employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees:Employee[];
  employee:Employee;
  constructor(private _employeeService:EmployeeService,private _router:Router) {
    this._employeeService.getAllEmployees().subscribe(response=>{
      this.employees = response;
    })
   }

  ngOnInit() {
    
  }
  setCurrentEmployee(i){
    console.log(i);
    this.employee = this.employees[i];
    console.log(this.employee);
  }
  deleteEmployee(){
    this._employeeService.deleteEmployee(this.employee.id).subscribe(response=>{
     console.log(response);
     this._employeeService.getAllEmployees().subscribe(response=>{
      this.employees = response;
    })
    });
  }
 

}
