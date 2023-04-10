package per.xy.service;

import per.xy.model.Book;
import per.xy.util.PageBean;

import java.util.List;
import java.util.Map;

public interface IBookService {
//    模糊查询_查询所有书籍
    public List<Book> queryAllBooksByPage(Book book, PageBean pageBean);

//    插入新书籍
    public Map<String,Object> insertBook(Book book);

//    修改书籍
    public Map<String,Object> updateBook(Book book);
}
