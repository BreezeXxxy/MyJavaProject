package per.xy.service;

import per.xy.model.BookCategory;

import java.util.Map;

public interface IBookCategoryService {
//    查询所有书籍分类
    public Map<String,Object> queryAllBookCategory(BookCategory bookCategory);
}
