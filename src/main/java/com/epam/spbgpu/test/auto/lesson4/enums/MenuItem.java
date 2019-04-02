package com.epam.spbgpu.test.auto.lesson4.enums;

public enum MenuItem {

    MY_VIEW("My View"),
    VIEW_ISSUES("View Issues"),
    REPORT_ISSUE("Report Issue");

    private String itemName;

    MenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
