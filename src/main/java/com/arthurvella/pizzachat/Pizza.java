package com.arthurvella.pizzachat;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Pizza {
    int id;
    Base base;
    String name;
    float price;
    String imageUrl;

    public static List<Pizza> all = List.of(
            new Pizza().setId(1).setBase(Base.all.get(0)).setName("Margherita").setPrice((float) 9.99).setImageUrl("https://www.dominos.fr/ManagedAssets/FR/product/PMAR/FR_PMAR_all_menu_9664.png?v1832609322"),
            new Pizza().setId(2).setBase(Base.all.get(0)).setName("Regina").setPrice((float) 10.99).setImageUrl("https://www.dominos.fr/ManagedAssets/FR/product/PREI/FR_PREI_fr_menu_9172.png?v359197323"),
            new Pizza().setId(3).setBase(Base.all.get(1)).setName("Saumon").setPrice((float) 11.99).setImageUrl("https://www.dominos.fr/ManagedAssets/FR/product/PSAU/FR_PSAU_fr_menu_9172.png?v-577323236"),
            new Pizza().setId(4).setBase(Base.all.get(1)).setName("Chèvre-Miel").setPrice((float) 11.99).setImageUrl("https://www.dominos.fr/ManagedAssets/FR/product/PCMI/FR_PCMI_fr_menu_9172.png?v1841034372")
    );

    public static List<Pizza> getPizzaFromBase(Base base) {
        return Pizza.all.stream().filter(p -> p.base.id == base.id).collect(Collectors.toList());
    }
}
