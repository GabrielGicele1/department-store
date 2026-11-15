/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.departmentstore.model.Employee;

/**
 *
 * @author gabri
 */
public class FileReaderUtil {

    public static ArrayList<Employee> readEmployees(String filename) {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // Skip the header
            reader.readLine();

            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length < 9) {
                    continue;
                }

                String name = data[0].trim() + " " + data[1].trim();
                String department = data[5].trim();
                String managerType = data[7].trim();

                Employee employee = new Employee(name, managerType, department);

                employees.add(employee);
            }

            System.out.println("File read successfully.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }
}
