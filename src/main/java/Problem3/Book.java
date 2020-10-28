package Problem3;

import java.util.UUID;

public abstract class Book implements StoreMediaOperations {
    UUID id;
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.id = UUID.randomUUID();
    }

    public Book(Book anotherBook) {
        this.id = anotherBook.id;
        this.title = anotherBook.title;
        this.author = anotherBook.author;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book theOtherBook = (Book) obj;


        // bug is here
        // Quiz: add unit tests to catch this bug.
        // The bug is caught when
        //  1. newly add tests fail while all old tests still pass
        //  2. remove the bug and use the fix below, all tests pass
        /*return id.equals(theOtherBook.id) &&
                author.equals(theOtherBook.author) &&
                title.equals(theOtherBook.title);*/

        // fix is here
         return id.equals(theOtherBook.id);
    }
}
