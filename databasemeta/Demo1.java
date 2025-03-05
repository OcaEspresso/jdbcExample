package databasemeta;

import utils.DbUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * @description
 * @author: RicksonYu
 * @create: 2025年-03月-05日--13:04
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{

        DbUtil dbUtil = new DbUtil();
        Connection con = dbUtil.getCon();
        //获取元数据
        DatabaseMetaData dmd = con.getMetaData();
        System.out.println("获取数据库名称: "+dmd.getDatabaseProductName());
        System.out.println("获取数据库版本: "+dmd.getDatabaseProductVersion());
    }
}
