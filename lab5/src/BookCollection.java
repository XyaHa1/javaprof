public interface BookCollection extends Iterable<Book> {
    int size();
    void add(Book book);
    String getDescription();
}
