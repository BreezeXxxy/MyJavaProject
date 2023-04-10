package per.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.xy.mapper.BookMapper;
import per.xy.model.Book;
import per.xy.service.IBookService;
import per.xy.util.PageBean;
import per.xy.util.PinYinUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> queryAllBooksByPage(Book book, PageBean pageBean) {
        List<Book> booksList = bookMapper.queryAllBooks(book);
        return booksList;

//        int code = 200;
//        String msg = "成功查询书籍。";
//        Map<String,Object> map = new HashMap<>();
//        List<Book> booksList = bookMapper.queryAllBooks(book);
//        //1、没有查到书籍
//        if(booksList.isEmpty()){
//            code = 204;
//            msg = "没找到您想要的书籍。";
//        }else {
////        2、找到书籍了，放入map。
//            map.put("booksList",booksList);
//        }
//        map.put("code",code);
//        map.put("msg",msg);
//        return map;
    }

    @Override
    public Map<String, Object> insertBook(Book book) {
        int code = 200;
        String msg = "新增成功。";
        int n = 1;
        Map<String,Object> bookInsertMap = new HashMap<>();
//        设置拼音
        if(null != book.getBookName()){
            String pinyin = PinYinUtil.toPinyin(book.getBookName());
            book.setBookNamePinyin(pinyin);
            System.out.println("要插入的书籍："+book);
            n = bookMapper.insertBook(book);
        }else {
            n = 0;
        }
//        书籍插入状态判断
        if(n<=0){
            code = 203;
            msg = "书籍新增失败。";
        }
        bookInsertMap.put("code",code);
        bookInsertMap.put("msg",msg);
        return bookInsertMap;
    }

    @Override
    public Map<String, Object> updateBook(Book book) {
        int code = 200;
        String msg = "修改成功。";
        Map<String,Object> bookUpdateMap = new HashMap<>();
        int n = bookMapper.updateBook(book);
//        判断修改返回值
        if(n<=0){
            code = 203;
            msg = "修改失败";
        }
        bookUpdateMap.put("code",code);
        bookUpdateMap.put("msg",msg);
        return bookUpdateMap;
    }
}
