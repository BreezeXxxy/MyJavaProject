package per.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.xy.model.Book;
import per.xy.model.BookCategory;
import per.xy.service.IBookCategoryService;
import per.xy.service.IBookService;
import per.xy.util.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCategoryService bookCategoryService;
//    查找所有书籍+模糊查询
    @RequestMapping("/queryAllBooks")
    public Map<String,Object> queryAllBooks(Book book,PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> booksQueryMap = new HashMap<>();
        int code = 200;
        String msg = "查询成功！";
        List<Book> booksList = bookService.queryAllBooksByPage(book, pageBean);
//        没有查到书籍数据的情况
        if(booksList.size()<=0){
            code = 204;
            msg = "没有查到书籍！";
        }else {
            booksQueryMap.put("booksList",booksList);
        }
//        放入总条目数total
        booksQueryMap.put("total",pageBean.getTotal());
        booksQueryMap.put("code",code);
        booksQueryMap.put("msg",msg);
        return booksQueryMap;
    }

//    插入新书籍
    @RequestMapping("/insertBook")
    public Map<String,Object> insertBook(Book book){

        Map<String, Object> bookInsertMap = new HashMap<>();
//        判断操作book的id值，为空则新增，有值则根据id去修改书籍。
        if(null == book.getBookId()){
             bookInsertMap = bookService.insertBook(book);
        }else {
             bookInsertMap = bookService.updateBook(book);
        }
        return bookInsertMap;
    }

//    查询书籍分类信息
    @RequestMapping("/queryAllBookCategory")
    public Map<String,Object> queryAllBookCategory(BookCategory bookCategory){
        Map<String, Object> bookCategoryMap = bookCategoryService.queryAllBookCategory(bookCategory);
        System.out.println("完成了");
        return bookCategoryMap;
    }

}
