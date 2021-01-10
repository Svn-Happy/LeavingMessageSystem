package util;

//这个类的作用：就是用来连接数据库的

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil  {

    private static String driver;//数据库驱动
    private static String url;//连接数据库的路径
    private static String username;//数据库用户名
    private static String password;//数据库密码
    private static Connection conn;//数据库链接对象

    //当该类被加载的时候，应该加载数据库的配置文件。
    static {
        //创建Propertis
        Properties p = new Properties();
        //使用流读取配置文件
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");//生成本地变量的快捷键。
        try {
            p.load(in);
            //读取配置文件的信息。
            driver = p.getProperty("jdbc.driverName");//!!deriverClassName
            url = p.getProperty("jdbc.url");
            username = p.getProperty("jdbc.username");
            password = p.getProperty("jdbc.password");

            //加载驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //封装一个方法获取数据库的连接
    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //封装一个方法关闭数据的连接
    public static void closeConn(Connection conn){
        if(conn != null){
            try {
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
