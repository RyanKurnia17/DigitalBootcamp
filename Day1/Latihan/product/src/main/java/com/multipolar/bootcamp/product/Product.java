package com.multipolar.bootcamp.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data//untuk membuat get set (?)
@NoArgsConstructor//untuk membuat constructor dengan argumen kosong
@AllArgsConstructor//untuk membuat constructor dengan semua argumen
@ToString//untuk membuatkan method toString
public class Product implements Serializable {
    private int id;
    private String name;

}
