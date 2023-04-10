package per.xy.mapper;

import org.springframework.stereotype.Repository;
import per.xy.model.BookCategory;

import java.util.List;
@Repository
public interface BookCategoryMapper {
    int deleteByPrimaryKey(Long bookCategoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Long bookCategoryId);

//    查到所有的书籍分类
    List<BookCategory> queryAllBooksCategory(BookCategory bookCategory);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}