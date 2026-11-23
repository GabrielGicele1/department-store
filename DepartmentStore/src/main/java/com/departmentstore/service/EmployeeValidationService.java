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
public class EmployeeValidationService {

    private static final String[] MANAGER_TYPES = {
        "Senior Manager",
        "Manager",
        "Team Lead"
    };

    public static String[] getManagerTypes() {
        return MANAGER_TYPES.clone();
    }

    public static ArrayList<String> getDepartments(
            ArrayList<Employee> employees) {

        ArrayList<String> departments = new ArrayList<>();

        for (Employee employee : employees) {

            String department = employee.getDepartment();

            if (!department.isEmpty()
                    && !departments.contains(department)) {

                departments.add(department);
            }
        }

        departments.sort(String.CASE_INSENSITIVE_ORDER);

        return departments;
    }

    public static boolean isValidManagerType(String managerType) {

        for (String type : MANAGER_TYPES) {
            if (type.equalsIgnoreCase(managerType)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidDepartment(
            String department,
            ArrayList<Employee> employees) {

        for (String existing : getDepartments(employees)) {
            if (existing.equalsIgnoreCase(department)) {
                return true;
            }
        }

        return false;
    }
}
