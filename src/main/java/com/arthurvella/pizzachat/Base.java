package com.arthurvella.pizzachat;

import lombok.Data;

import java.util.List;

@Data
public class Base {
    int id;
    String name;

    public static List<Base> all = List.of(
            new Base().setId(1).setName("Tomate"),
            new Base().setId(2).setName("Crème")
    );
}
