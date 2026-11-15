/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.departmentstore;

import com.departmentstore.model.Employee;
import com.departmentstore.model.Employee;
import com.departmentstore.util.FileReaderUtil;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class DepartmentStore {

    public static void main(String[] args) {

        ArrayList<Employee> employees
                = FileReaderUtil.readEmployees("Applicants_Form.txt");

        System.out.println("Total employees: " + employees.size());

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}
