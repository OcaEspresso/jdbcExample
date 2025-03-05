package 大数据对象处理;

import model.Book;
import utils.DbUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-05日--11:02
 */
public class Demo1 {

    private static DbUtil dbUtil = new DbUtil();

    /**
     * 添加图书
     * */

    private static int addBook(Book book) throws Exception{

        //获取连接
        Connection con = dbUtil.getCon();
        String sql = "insert into t_book values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getBookName());
        preparedStatement.setFloat(3,book.getPrice());
        preparedStatement.setString(4,book.getAuthor());
        preparedStatement.setInt(5,book.getBookTypeId());
        File context=book.getContext();//获取文件
        //定义输入流
        InputStream inputStream = new FileInputStream(context);
        preparedStatement.setAsciiStream(6,inputStream,context.length());

        int result = preparedStatement.executeUpdate();
        dbUtil.close(preparedStatement,con);
        return result;
    }

    //读取文本
    public static void getBook(int id) throws Exception{

        Connection con = dbUtil.getCon();
        String sql = "select * from t_book where id=?";
        PreparedStatement pres = con.prepareStatement(sql);
        pres.setInt(1,id);
        ResultSet result = pres.executeQuery();
        if(result.next()){

            int id1 = result.getInt("id");
            String bookName = result.getString("bookName");
            float price = result.getFloat("price");
            String author = result.getString("author");
            int bookTypeId = result.getInt("bookTypeId");
            Clob c = result.getClob("context");
            String context = c.getSubString(1,(int)c.length());
            System.out.println(id1+"\t"+bookName+"\t"+price+"\t"+author+"\t"+bookTypeId+"\t"+context);
      }
        dbUtil.close(pres,con);

    }

    public static void main(String[] args) throws Exception{
//        File context = new File("C:/Users/Bravo _Tango/Desktop/HelloWorld.txt");
//        Book book = new Book(4,"java高级应用",39.9f,"于童",1,context);
//        int result = addBook(book);
//
//        if(result >0)
//            System.out.println("添加成功");
//        else
//            System.out.println("添加失败");
        getBook(4);
    }
}
