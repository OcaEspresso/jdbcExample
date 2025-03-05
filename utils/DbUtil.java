package utils;

import java.sql.*;

/**
 * @description  封装jdbc
 * @author: RicksonYu
 * @create: 2025年-03月-04日--02:44
 */
public class DbUtil {


    //数据库地址
    private static String dbUrl = "jdbc:mysql://localhost:3306/db_jdbc?serverTimezone=Asia/Shanghai";

    //用户名
    private static String user = "root";
    //密码
    private static String password = "sqlyutong6443!";

    //驱动名称
    private static String driver = "com.mysql.cj.jdbc.Driver";


    /**
     * 获取数据库连接
     * **/
    public Connection getCon() throws Exception{

        Class.forName(driver);
        Connection con = DriverManager.getConnection(dbUrl, user, password);

        return con;
    }
    public void close(Statement statement,Connection con) throws Exception{


        if(statement != null)
        {
            statement.close();
            if(con != null)
            {
                con.close();
            }
        }

    }

    public void close(PreparedStatement pstmt,Connection con)throws Exception{
        if(pstmt != null)
        {
            pstmt.close();
            if(con != null)
            {
                con.close();
            }
        }
    }


    public void close(CallableStatement call, Connection con)throws Exception{
        if(call != null)
        {
            call.close();
            if(con != null)
            {
                con.close();
            }
        }
    }
}
