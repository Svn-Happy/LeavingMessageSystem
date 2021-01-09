package model;

import pojo.Message;
import pojo.User;
import util.DBUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    /*
        数据库名messagesystem
        表名：user  属性： id 、 password
        表名：message 属性：num(主键、序号) 、  id（外键） 、 message 、 date。。
     */


    //查询用户
    public User FindUser(String id){
        User user = null;
        System.out.println("1");
        Connection conn = DBUtil.getConn();
        System.out.println("2");
        String sql = "select * from user where id = ?";
        System.out.println("3");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        System.out.println(user);
        return user;
    }

    //查询留言(查不到返回空)
    public List<Message> FindMessage(String id){
        List<Message> list = null;
        Connection conn = DBUtil.getConn();
        String sql = "select * from message where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list = new ArrayList<>();
                Message message = new Message();
                message.setMessage(rs.getString("message"));
                message.setDate(rs.getDate("date"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return list;
    }

    //存储账号
    public int SaveUser(User user){
        int row = 0;
        Connection conn = DBUtil.getConn();

        String sql = "insert into user (id,password) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getId());
            ps.setString(2,user.getPassword());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }

        return row;
    }


    //存储用户留言内容
    public int SavaMessage(String id,Message message){
        int row = 0;
        Connection conn = DBUtil.getConn();
        String sql = "insert into message (num,id,message,date) values (null,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,message.getMessage());
            ps.setDate(3,message.getDate());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return row;
    }

    //修改用户留言内容（待定）
    public int UpdateMessage(Message m){
        int row = 0;
        Connection conn = DBUtil.getConn();
        String sql="update message set message=? where num=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,m.getMessage());
            ps.setInt(2,m.getNum());
            row=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return row;
    }
}
