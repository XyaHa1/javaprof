import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookBox implements BookCollection{
    private BookItem head;
    private BookItem tail;
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Book book) {
        if (book == null)
            throw new NullPointerException("Книга для добавления не существует");
        if (head == null) {
            head = tail = new BookItem(book, null);
        } else {
            tail.setNext(new BookItem(book, null));
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<>() {
            private BookItem current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Book next() {
                if (!hasNext())
                    throw new NoSuchElementException("Книги в коробке закончились");

                Book book = current.getBook();
                current = current.getNext();
                return book;
            }
        };
    }

    @Override
    public String getDescription() {
        return String.format("Коробка с %d книгами", size);
    }
}
