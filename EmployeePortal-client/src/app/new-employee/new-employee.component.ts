import { Component, OnInit,Input } from '@angular/core';
import { EmployeeServiceService as EmployeeService} from '../service/employee-service.service';
import { Employee } from '../classes/employee';
import {Router} from '@angular/router';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styleUrls: ['./new-employee.component.css']
})
export class NewEmployeeComponent implements OnInit {

  @Input() fname:string;
  @Input() lname:string;
  @Input() dob:string;
  @Input() gender:string;
  @Input() department:string;
  employee:Employee;
  errorMsg:string;


  constructor(private _router:Router,private _employeeService:EmployeeService) { }

  ngOnInit() {
  }

  saveEmployee(){
    this.employee = new Employee();
    this.employee.fname = this.fname;
    this.employee.lname = this.lname;
    this.employee.dob = this.dob;
    this.employee.gender = this.gender;
    this.employee.department = this.department;
    if(this.validateEmployee()){
      this._employeeService.createEmployee(this.employee).subscribe(response=>{
        this.employee = response;
        this._router.navigate(['./home'])
      })
    }else{
      this.errorMsg="All fields are mandatory";
    }
    
  }
  validateEmployee(){
    console.log(this.employee);
    if(this.employee.fname != undefined && this.employee.lname != undefined && this.employee.gender != undefined && this.employee.dob != undefined && this.employee.department != undefined){
    return true;
  }
  return false;
  }
}
