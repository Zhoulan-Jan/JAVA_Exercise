package library_management.book;

public class BookList {
    private  int size;
    private Book[] books = new Book[100];

   //无参数的构造方法  //好好领悟一下这种写法
    public BookList() {
        books[0]= new Book("西游记","001",
                "吴承恩","古典小说",false);
        books[1]=new Book("红楼梦","002",
                "曹雪芹","古典小说",false);
        books[2]=new Book("哈利波特","003",
                "JK罗琳","现代小说",false);
        books[3]=new Book("三体","004",
                "刘慈欣","现代小说",false);
        size = 4;
    }

    //对于书籍，要做到根据下标找到书
    public Book getBooks(int index) {
        return books[index];
    }

    public void setBook(int index,Book newBook) {
         books[index] = newBook;  //领悟一下
    }

    public int getSize() { return size; }

    public void setSize(int size) {
        this.size = size;
    }

}
