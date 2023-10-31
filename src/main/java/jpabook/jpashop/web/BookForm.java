package jpabook.jpashop.web;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookForm {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    public BookForm() {
    }

    public BookForm(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
