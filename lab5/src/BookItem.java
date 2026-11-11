public class BookItem {
    private final Book book;
    private BookItem next;

    public BookItem(Book book, BookItem nextBook) {
        this.book = book;
        this.next = nextBook;
    }

    public Book getBook() {
        return book;
    }

    public BookItem getNext() {
        return next;
    }

    public void setNext(BookItem next) {
        if (next == null) throw new IllegalArgumentException("nextBook cannot be null");
        this.next = next;
    }

}
