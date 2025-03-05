package callablestatement;

import utils.DbUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 * @description 测试CallableStatement 存储过程
 * @author: RicksonYu
 * @create: 2025年-03月-05日--12:38
 */
public class Demo1 {

    private static DbUtil dbUtil = new DbUtil();

    /**
     * 调用存储过程，通过id查询bookName
    * **/
    private static String getBookNameById(int id) throws Exception{

        Connection con = dbUtil.getCon();
        String sql = "{call pro_getBookNameById(?,?)}";
        CallableStatement call = con.prepareCall(sql);
        call.setInt(1,id); //设置第一个参数
        call.registerOutParameter(2, Types.VARCHAR);//设置返回类型
        call.execute();
        String bookName = call.getString("bN");
        dbUtil.close(call,con);
        return bookName;
    }

    public static void main(String[] args) throws Exception{

        System.out.println("图书名称是: "+getBookNameById(2));
    }
}
