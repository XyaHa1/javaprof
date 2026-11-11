import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelf implements BookCollection{
    private final Book[] books;
    private int currentSize = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    @Override
    public void add(Book book) {
        if (book == null)
            throw new NullPointerException("Книга не может быть null!");
        if (currentSize >= books.length)
            throw new IllegalStateException("Шкаф полон!");

        books[currentSize++] = book;
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < currentSize;
            }

            @Override
            public Book next() {
                if (!hasNext())
                    throw new NoSuchElementException("Вышли за пределы шкафа!");

                return books[cursor++];
            }
        };
    }

    @Override
    public int size() {
        return currentSize;
    }

    public Book get(int index) {
        if (index < 0 ||index >= books.length)
            throw new IndexOutOfBoundsException("Вышли за пределы шкафа!");
        if (books[index] == null)
            throw new NoSuchElementException("Книги в этом месте нет!");

        return books[index];
    }

    @Override
    public String getDescription() {
        return String.format("Шкаф с %d книгами", currentSize);
    }


}
