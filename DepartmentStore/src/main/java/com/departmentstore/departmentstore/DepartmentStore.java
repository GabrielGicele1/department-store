/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.departmentstore;

import com.departmentstore.model.Employee;
import com.departmentstore.util.FileReaderUtil;
import java.util.ArrayList;
import com.departmentstore.controller.EmployeeController;


/**
 *
 * @author gabri
 */
public class DepartmentStore {

    public static void main(String[] args) {

         // Load employees from file
        ArrayList<Employee> employees =
                FileReaderUtil.readEmployees("Applicants_Form.txt");

        System.out.println("Total employees: " + employees.size());

        // Start the application menu
        EmployeeController controller = new EmployeeController(employees);
        controller.start();
    }
}