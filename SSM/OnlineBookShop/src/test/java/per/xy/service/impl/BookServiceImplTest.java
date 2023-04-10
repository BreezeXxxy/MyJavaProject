package per.xy.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.xy.model.Book;
import per.xy.service.IBookService;
import per.xy.util.PageBean;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring.xml"})
public class BookServiceImplTest {

    @Autowired
    private IBookService bookService;
    @Test
    public void queryAllBooksByPage() {
        Book book=new Book();
        PageBean pageBean=new PageBean();
        bookService.queryAllBooksByPage(book,pageBean);
    }
}