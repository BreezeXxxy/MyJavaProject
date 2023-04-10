package per.xy.mapper;

import org.springframework.stereotype.Repository;
import per.xy.model.Book;

import java.util.List;
import java.util.Map;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Long bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

//    查询所有书籍，模糊查询
    List<Book> queryAllBooks(Book book);

//    插入新书籍
   int insertBook(Book book);

//   修改书籍
    int updateBook(Book book);




}