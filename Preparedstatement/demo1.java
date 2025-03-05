package Preparedstatement;

import model.Book;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-04日--22:44
 */
public class demo1 {

    static DbUtil dbUtil = new DbUtil();

    //添加操作
    private static int addBook(Book book) throws Exception{

        Connection con = dbUtil.getCon();//获取连接
        String sql = "insert into t_book values(?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getBookName());
        preparedStatement.setFloat(3,book.getPrice());
        preparedStatement.setString(4,book.getAuthor());
        preparedStatement.setInt(5,book.getBookTypeId());
        int result = preparedStatement.executeUpdate();
       dbUtil.close(preparedStatement,con);
       return result;
    }

    public static void main(String[] args) throws Exception{
        Book book = new Book(5, "jvm虚拟机调优", 39.9f, "于童", 1);

        int result = addBook(book);
        if(result >0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");

    }

}
