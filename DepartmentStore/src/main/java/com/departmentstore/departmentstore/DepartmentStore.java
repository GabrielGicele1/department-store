/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.departmentstore;

import com.departmentstore.model.Employee;
import com.departmentstore.model.Employee;
import com.departmentstore.util.FileReaderUtil;
import java.util.ArrayList;
import com.departmentstore.service.SortingService;

/**
 *
 * @author gabri
 */
public class DepartmentStore {

    public static void main(String[] args) {

     // Read employees from file
        ArrayList<Employee> employees =
                FileReaderUtil.readEmployees("Applicants_Form.txt");

        // Display total employees
        System.out.println("Total employees: " + employees.size());

        // Sort employees alphabetically using Merge Sort
        SortingService.mergeSort(employees);

        // Display first 20 sorted employees
        System.out.println("\nFirst 20 employees sorted alphabetically:");

        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName());
        }
    }
}