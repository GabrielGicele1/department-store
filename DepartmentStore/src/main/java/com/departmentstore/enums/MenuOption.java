/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.departmentstore.enums;

/**
 *
 * @author gabri
 */
public enum MenuOption {

    SORT(1, "Sort Employees"),
    SEARCH(2, "Search Employee"),
    ADD_EMPLOYEE(3, "Add Employee"),
    BINARY_TREE(4, "Create Binary Tree"),
    EXIT(5, "Exit");

    private final int value;
    private final String description;

    MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromValue(int value) {

        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }

        return null;
    }
}
