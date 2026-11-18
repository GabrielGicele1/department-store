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
public class SortingService {

    public static void mergeSort(ArrayList<Employee> employees) {

       // Base case
        if (employees.size() <= 1) {
            return;
        }

        // Find the middle
        int middle = employees.size() / 2;

        // Divide the list
        ArrayList<Employee> left = new ArrayList<>(
                employees.subList(0, middle)
        );

        ArrayList<Employee> right = new ArrayList<>(
                employees.subList(middle, employees.size())
        );

        // Recursive calls
        mergeSort(left);
        mergeSort(right);

        // Merge sorted lists
        merge(employees, left, right);
    }

    private static void merge(
            ArrayList<Employee> employees,
            ArrayList<Employee> left,
            ArrayList<Employee> right) {

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare employee names
        while (i < left.size() && j < right.size()) {

            if (left.get(i).getName().compareToIgnoreCase(
                    right.get(j).getName()) <= 0) {

                employees.set(k, left.get(i));
                i++;

            } else {

                employees.set(k, right.get(j));
                j++;
            }

            k++;
        }

        // Copy remaining left elements
        while (i < left.size()) {
            employees.set(k, left.get(i));
            i++;
            k++;
        }

        // Copy remaining right elements
        while (j < right.size()) {
            employees.set(k, right.get(j));
            j++;
            k++;
        }
    }
}