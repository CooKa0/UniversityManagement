package university.facilities;

public class Library {
    private String libraryName;
    private int bookCount;

    private static final int MAX_BOOKS = 10000;
    private static int totalBooks;

    public Library(String libraryName, int bookCount) {
        this.libraryName = libraryName;
        if (bookCount > MAX_BOOKS) {
            throw new IllegalArgumentException("Initial book count exceeds maximum allowed.");
        }
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

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookCount=" + bookCount +
                '}';
    }

    @Override
    public int hashCode() {
        return libraryName.hashCode() + bookCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Library that = (Library) obj;
        return bookCount == that.bookCount && libraryName.equals(that.libraryName);
    }
}