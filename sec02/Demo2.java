package sec02;

import model.Book;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @description 添加图书功能
 * @author: RicksonYu
 * @create: 2025年-03月-04日--02:57
 */
public class Demo2 {


    private static DbUtil dbUtil = new DbUtil();


    /**
     * 添加图书By面向对象
     */
    private static int addBook2(Book book) throws Exception {

        Connection con = dbUtil.getCon(); //获取连接
        String sql = "insert into t_book values(" + book.getId() + ",'" + book.getBookName() + "'," + book.getPrice() + ",'" + book.getAuthor() + "'," + book.getBookTypeId() + ")";
        Statement statement = con.createStatement();
        int result = statement.executeUpdate(sql);
        dbUtil.close(statement, con); //关闭statement和con
        return result;


    }


    private static int addBook(int Id, String bookName, float price, String author, int bookTypeId) throws Exception {

        Connection con = dbUtil.getCon(); //获取连接
        String sql = "insert into t_book values(" + Id + ",'" + bookName + "'," + price + ",'" + author + "'," + bookTypeId + ")";
        Statement statement = con.createStatement();
        int result = statement.executeUpdate(sql);
        dbUtil.close(statement, con); //关闭statement和con
        return result;
    }

    public static void main(String[] args) throws Exception {

//        int result = addBook(3,"python从入门到精通",39.9f,"rickson",1);
//        if (result > 0)
//        {
//            System.out.println("添加成功了" + result);
//        }else
//            System.out.println("添加失败了");
//    }
//}
        Book book = new Book(4, "jvm从入门到精通", 39.9f, "于童", 1);


        int result = addBook2(book);

        if (result > 0)
        {
            System.out.println("添加成功了" + result);
        }else
            System.out.println("添加失败了");
         }
    }

