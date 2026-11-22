/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.controller;

import com.departmentstore.model.Employee;
import com.departmentstore.view.EmployeeView;
import com.departmentstore.enums.MenuOption;
import com.departmentstore.service.SortingService;
import com.departmentstore.service.SearchingService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class EmployeeController {

    private final ArrayList<Employee> employees;
    private final EmployeeView view;
    private final Scanner scanner;

    public EmployeeController(ArrayList<Employee> employees) {
        this.employees = employees;
        this.view = new EmployeeView();
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            view.displayMenu();

            String input = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.displayMessage("Invalid input. Enter a number.");
                continue;
            }

            MenuOption option = MenuOption.fromValue(choice);

            if (option == null) {
                view.displayMessage("Invalid menu option.");
                continue;
            }

            switch (option) {

                case SORT:
                    sortEmployees();
                    break;

                case SEARCH:
                    searchEmployee();
                    break;

                case ADD_EMPLOYEE:
                    view.displayMessage("Add Employee - Coming soon.");
                    break;

                case BINARY_TREE:
                    view.displayMessage("Binary Tree - Coming soon.");
                    break;

                case EXIT:
                    view.displayMessage("Exiting application...");
                    running = false;
                    break;
            }
        }

        scanner.close();
    }

    private void sortEmployees() {

        SortingService.mergeSort(employees);

        view.displayMessage("\nFirst 20 employees sorted alphabetically:");

        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            view.displayMessage(
                    (i + 1) + ". " + employees.get(i).getName()
            );
        }
    }

    private void searchEmployee() {

        // Binary Search requires a sorted list
        SortingService.mergeSort(employees);

        System.out.print("\nEnter employee name: ");
        String name = scanner.nextLine().trim();

        Employee found = SearchingService.binarySearch(
                employees,
                name,
                0,
                employees.size() - 1
        );

        if (found != null) {

            view.displayMessage("\nEmployee found!");
            view.displayMessage("Name: " + found.getName());
            view.displayMessage("Manager Type: " + found.getManagerType());
            view.displayMessage("Department: " + found.getDepartment());

        } else {
            view.displayMessage("\nEmployee not found.");
        }
    }
}
