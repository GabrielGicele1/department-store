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
import com.departmentstore.service.SearchingService;
import java.util.Scanner;
import com.departmentstore.service.SearchingService;

/**
 *
 * @author gabri
 */
public class DepartmentStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read employees from file
        ArrayList<Employee> employees
                = FileReaderUtil.readEmployees("Applicants_Form.txt");

        System.out.println("Total employees: " + employees.size());

        // Sort employees alphabetically
        SortingService.mergeSort(employees);

        // Display first 20 employees
        System.out.println("\nFirst 20 employees sorted alphabetically:");

        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName());
        }

        // Search employee by name
        System.out.print("\nEnter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        Employee found = SearchingService.binarySearch(
                employees,
                searchName,
                0,
                employees.size() - 1
        );

        if (found != null) {
            System.out.println("\nEmployee found!");
            System.out.println("Name: " + found.getName());
            System.out.println("Manager Type: " + found.getManagerType());
            System.out.println("Department: " + found.getDepartment());
        } else {
            System.out.println("\nEmployee not found.");
        }

        scanner.close();
    
}
}
