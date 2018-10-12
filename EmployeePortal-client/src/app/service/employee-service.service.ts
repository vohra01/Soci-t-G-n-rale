import { Injectable } from '@angular/core';
import { Http,Headers,Response,RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {Employee } from '../classes/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor(private _http:Http) { }

  createEmployee(employee:Employee):Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this._http.post('http://localhost:8080/employee',employee).pipe(map(res => res.json()));
  }

  getAllEmployees():Observable<Employee[]>{
    return this._http.get('http://localhost:8080/employee').pipe(map(res=>res.json()));
  }

  getAllEmployeeById(id:number):Observable<Employee>{
    return this._http.get('http://localhost:8080/employee/getEmployeeById?id='+id).pipe(map(res=>res.json()));
  }
  deleteEmployee(id:Number):Observable<any>{
    return this._http.delete('http://localhost:8080/employee?id='+id).pipe(map(res=>res.json()));
  }


  handleError(error:Response){
    console.error(error);
    return Observable.throw(error);
  }
}
