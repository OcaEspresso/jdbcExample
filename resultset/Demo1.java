package resultset;

import model.Book;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 遍历查询结果
 * @author: RicksonYu
 * @create: 2025年-03月-05日--00:10
 */
public class Demo1 {

    private static DbUtil dbUtil = new DbUtil();


    //columnIndex
    private static void listBook() throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "select * from t_book";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();//返回结果集 result
        while(rs.next()){
            int id = rs.getInt(1);
            String bookName = rs.getString(2);
            float price = rs.getFloat(3);
            String author = rs.getString(4);
            int bookTypeId = rs.getInt(5);
            System.out.println(id+"\t"+bookName+"\t"+price+"\t"+author+"\t"+bookTypeId);
        }

    }

    //实际开发用这种形式  columnlabel
    private static void listBook2() throws Exception{
        Connection con = dbUtil.getCon();
        String sql = "select * from t_book";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();//返回结果集 result
        while(rs.next()){
            int id = rs.getInt("id");
            String bookName = rs.getString("bookName");
            float price = rs.getFloat("price");
            String author = rs.getString("author");
            int bookTypeId = rs.getInt("bookTypeId");
            System.out.println(id+"\t"+bookName+"\t"+price+"\t"+author+"\t"+bookTypeId);
        }

    }


    //实际开发返回集合
    private static List<Book> listBook3() throws Exception{
       List<Book> bookList = new ArrayList<>();
        Connection con = dbUtil.getCon();
        String sql = "select * from t_book";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();//返回结果集 result
        while(rs.next()){
            int id = rs.getInt("id");
            String bookName = rs.getString("bookName");
            float price = rs.getFloat("price");
            String author = rs.getString("author");
            int bookTypeId = rs.getInt("bookTypeId");

            bookList.add(new Book(id,bookName,price,author,bookTypeId));
        }
        return bookList;
    }


    public static void main(String[] args) throws Exception{
        //1.遍历了一个结果集
//        listBook();
//        listBook2();
         List<Book> bookList = listBook3();
         for(Book book:bookList)
             System.out.println(book);
    }
}
