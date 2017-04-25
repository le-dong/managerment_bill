package com.phuongdong.managermentbillbook.activity;

/**
 * Created by phuongdong on 4/3/17.
 */

public class Bill {
    String customerName;
    int numberBook;
    boolean checkCustomerVip;

    public Bill() {
    }

    public Bill(String customerName, int numberBook, boolean checkCustomerVip) {
        this.customerName = customerName;
        this.numberBook = numberBook;
        this.checkCustomerVip = checkCustomerVip;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public boolean isCheckCustomerVip() {
        return checkCustomerVip;
    }

    public void setCheckCustomerVip(boolean checkCustomerVip) {
        this.checkCustomerVip = checkCustomerVip;
    }
}
