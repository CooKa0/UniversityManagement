package university.facilities;

public class Library {
    private String libraryName;
    private int bookCount;

    public Library(String libraryName, int bookCount) {
        this.libraryName = libraryName;
        this.bookCount = bookCount;
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
        this.bookCount = bookCount;
    }

    public String getLibraryInfo() {
        return "Library Name: " + libraryName + ", Book Count: " + bookCount;
    }
}