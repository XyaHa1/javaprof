import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== BookShelf =====");
        Book book1 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book2 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book book3 = new Book("Дюна", "Фрэнк Герберт", 1965);
        Book book4 = new Book("Автостопом по галактике", "Дуглас Адамс", 1979);
        Book book5 = new Book("Пикник на обочине", "Аркадий и Борис Стругацкие", 1972);

        BookCollection shelf = new BookShelf(5);
        shelf.add(book1);
        shelf.add(book2);
        shelf.add(book3);
        shelf.add(book4);
        shelf.add(book5);
        for (Book book : shelf) {
            System.out.println(book.title());
        }

        System.out.println("\n===== BookBox =====");
        Book javaBook1 = new Book("Effective Java", "Joshua Bloch", 2018);
        Book javaBook2 = new Book("Clean Code", "Robert C. Martin", 2008);
        Book javaBook3 = new Book("Design Patterns", "Erich Gamma", 1994);
        Book javaBook4 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006);

        BookCollection box = new BookBox();
        box.add(javaBook1);
        box.add(javaBook2);
        box.add(javaBook3);
        box.add(javaBook4);
        for (Book book : box) {
            System.out.println(book);
        }

        System.out.println("\n===== BookCollection =====");
        List<BookCollection> collections = List.of(shelf, box);
        for (BookCollection collection : collections) {
            System.out.println(collection.getDescription());
            for (Book book : collection) {
                System.out.printf("\"%s\" (%s, %d)\n", book.title(), book.author(), book.year());
            }
        }
    }
}
