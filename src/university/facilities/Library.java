package university.facilities;

public class Library {
    private String libraryName;
    private int bookCount;

    private static int totalBooks = 0;

    public Library(String libraryName, int bookCount) {
        this.libraryName = libraryName;
        this.bookCount = bookCount;
        totalBooks += bookCount;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        totalBooks -= this.bookCount;
        this.bookCount = bookCount;
        totalBooks += bookCount;
    }

    public String getLibraryInfo() {
        return "Library Name: " + libraryName + ", Book Count: " + bookCount;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}