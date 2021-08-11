package com.homework.bookapp.model;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String barcode;
    private int quantity;
    private double pricePerUnit;
}
