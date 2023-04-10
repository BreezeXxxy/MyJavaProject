package per.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.xy.mapper.BookCategoryMapper;
import per.xy.mapper.BookMapper;
import per.xy.model.BookCategory;
import per.xy.service.IBookCategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookCategoryServiceImpl implements IBookCategoryService {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    @Override
    public Map<String, Object> queryAllBookCategory(BookCategory bookCategory) {
        int code = 200;
        String str = "查询所有书籍分类信息成功！";
        Map<String, Object> bookCategoryMap = new HashMap<>();
        List<BookCategory> bookCategoriesList = bookCategoryMapper.queryAllBooksCategory(bookCategory);
        if(bookCategoriesList.size()<=0){
            code = 203;
            str = "查询所有书籍分类信息失败！";
        }else {
            bookCategoryMap.put("object",bookCategoriesList);
        }
        bookCategoryMap.put("code",code);
        bookCategoryMap.put("str",str);
        return bookCategoryMap;
    }
}
