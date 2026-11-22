/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.departmentstore.view;

import com.departmentstore.enums.MenuOption;

/**
 *
 * @author gabri
 */
public class EmployeeView {

    public void displayMenu() {

        System.out.println("\n===== DEPARTMENT STORE =====");

        for (MenuOption option : MenuOption.values()) {
            System.out.println(
                    option.getValue() + ". " + option.getDescription()
            );
        }

        System.out.print("\nEnter your choice: ");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
