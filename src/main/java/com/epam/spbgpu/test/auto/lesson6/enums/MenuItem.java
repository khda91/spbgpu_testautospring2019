package com.epam.spbgpu.test.auto.lesson6.enums;

public enum MenuItem {

    MY_VIEW("My View"),
    VIEW_ISSUES("View Issues"),
    REPORT_ISSUE("Report Issue"),
    MANAGE("Manage");

    private String itemName;

    MenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
