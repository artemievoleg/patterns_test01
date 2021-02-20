package entities;

public class Book {

    private String name;
    private String publisher;
    private String author;
    private String year;

    private Book(String nestedName, String nestedPublisher, String nestedAuthor, String nestedYear){
        this.name = nestedName;
        this.publisher = nestedPublisher;
        this.author = nestedAuthor;
        this.year = nestedYear;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!name.equals(book.name)) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return year != null ? year.equals(book.year) : book.year == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public static class BookBuilder {

        private String nestedName;
        private String nestedPublisher;
        private String nestedAuthor;
        private String nestedYear;

        public Book build() {
            if (!((nestedName == null) || nestedName.isEmpty())) {
                return new Book(nestedName, nestedPublisher, nestedAuthor, nestedYear);
            } else {
                return null;
            }
        }

        public BookBuilder setName(final String nestedName) {
            this.nestedName = nestedName;

            return this;
        }

        public BookBuilder setPublisher(final String nestedPublisher) {
            this.nestedPublisher = nestedPublisher;

            return this;
        }

        public BookBuilder setAuthor(final String nestedAuthor) {
            this.nestedAuthor = nestedAuthor;

            return this;
        }

        public BookBuilder setYear(final String nestedYear) {
            this.nestedYear = nestedYear;

            return this;
        }
    }
}
