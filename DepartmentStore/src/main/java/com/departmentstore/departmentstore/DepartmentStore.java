/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.departmentstore;
import com.departmentstore.model.Employee;

/**
 *
 * @author gabri
 */
public class DepartmentStore {
    
   public static void main(String[] args) {

        Employee employee = new Employee(
                "John Smith",
                "Senior Manager",
                "Finance"
        );

        System.out.println("Name: " + employee.getName());
        System.out.println("Manager Type: " + employee.getManagerType());
        System.out.println("Department: " + employee.getDepartment());

    }
}