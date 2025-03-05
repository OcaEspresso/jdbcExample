package sec04;

import utils.DbUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-04日--22:15
 */
public class Demo1 {

    private static DbUtil dbUtil = new DbUtil();
    private static int deleteBook(int id) throws Exception{

        Connection con = dbUtil.getCon();
        String sql = "delete from t_book where id=" + id;
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(sql);
        dbUtil.close(stmt, con);
        return result;

    }

    public static void main(String[] args) throws Exception{

        int result = deleteBook(4);

        if(result >0)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }
}
