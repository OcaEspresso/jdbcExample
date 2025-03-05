package sec03;

import model.Book;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-04日--03:33
 */
public class Demo1 {

    private static DbUtil dbUtil = new DbUtil();

    public static int updateBook(Book  book) throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "update t_book set  bookName='"+book.getBookName()+"',price="+book.getPrice()+",author='"+book.getAuthor()+"',bookTypeId="+book.getBookTypeId()+" where id="+book.getId();
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        dbUtil.close(stmt, con);
        return result;
    }

    public static void main(String[] args) throws Exception{

        Book book = new Book(1, "java并发编程", 39.9f, "于童", 1);
        int result = updateBook(book);
        if(result >0)
            System.out.println("更新成功");
        else
            System.out.println("更新失败");
    }
}
