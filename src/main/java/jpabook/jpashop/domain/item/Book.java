package jpabook.jpashop.domain.item;

import jpabook.jpashop.web.BookForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Setter
@Getter
@DiscriminatorValue("B")
@Entity
public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity) {
        super(name, price, stockQuantity);
    }

    public Book(Long id, String name, int price, int stockQuantity) {
        super(id, name, price, stockQuantity);
    }

    protected Book() {

    }

    public static Book createBook(BookForm form) {
        Book book = new Book(form.getName(), form.getPrice(), form.getStockQuantity());
        book.isbn = form.getIsbn();
        book.author = form.getAuthor();
        return book;
    }

    public static Book updateBook(BookForm form) {
        Book book = new Book(form.getId(), form.getName(), form.getPrice(), form.getStockQuantity());
        book.isbn = form.getIsbn();
        book.author = form.getAuthor();
        return book;
    }
}
