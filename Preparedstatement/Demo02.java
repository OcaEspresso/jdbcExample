package Preparedstatement;

import model.Book;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-04日--23:07
 */
public class Demo02 {

    private static DbUtil dbUtil = new DbUtil();

    /**
     * 更新
     * */
    private static int updateBook(Book book) throws Exception{

        Connection connection = dbUtil.getCon();
        String sql = "update t_book set  bookName=?,price=?,author=?,bookTypeId=? where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setFloat(2,book.getPrice());
        pstmt.setString(3,book.getAuthor());
        pstmt.setInt(4,book.getBookTypeId());
        pstmt.setInt(5,book.getId());
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,connection); //要记得用完关闭
        return result;
    }

    public static int deleteBook(int id) throws Exception{

        Connection connection = dbUtil.getCon();
        String sql = "delete from t_book where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        int result = pstmt.executeUpdate();
        dbUtil.close(pstmt,connection); //要记得用完关闭
        return result;

    }

    public static void main(String[] args) throws Exception{

      int result = deleteBook(5);
        if (result == 1)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");


    }
}
