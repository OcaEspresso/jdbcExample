package databasemeta;

import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-05日--13:41
 */
public class Demo2 {

    public static void main(String[] args) throws Exception{
        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getCon();
        String sql = "select * from t_book";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSetMetaData rsmd = pstmt.getMetaData();
        int num = rsmd.getColumnCount();//获取元数据列的总数
        System.out.println("共有"+num+"列");
        for(int i = 1; i <= num; i++)
        {
            System.out.println("第"+i+"列的名称为："+rsmd.getColumnName(i));

        }
    }
}
