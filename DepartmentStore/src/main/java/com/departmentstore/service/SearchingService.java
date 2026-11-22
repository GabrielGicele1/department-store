/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.service;

import com.departmentstore.model.Employee;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class SearchingService {

    public static Employee binarySearch(
            ArrayList<Employee> employees,
            String name,
            int left,
            int right) {

        // Base case: employee not found
        if (left > right) {
            return null;
        }

        // Find the middle index
        int middle = left + (right - left) / 2;

        Employee employee = employees.get(middle);

        // Compare names
        int comparison = name.compareToIgnoreCase(employee.getName());

        // Employee found
        if (comparison == 0) {
            return employee;
        }

        // Search the left half
        if (comparison < 0) {
            return binarySearch(employees, name, left, middle - 1);
        }

        // Search the right half
        return binarySearch(employees, name, middle + 1, right);
    }
}
