package model;

import pojo.Message;
import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    /*
        数据库名messagesystem
        表名：user  属性： id 、 password
        表名：message 属性：num(主键、序号) 、  id（外键） 、 message 、 date
     */


    ////查询用户名是否存在、读取用户留言内容（加载用户所有信息）
    //查询用户
    public User FindUser(String id){
        User user = new User();
        Connection conn = DBUtil.getConn();

        return user;
    }

    //查询留言
    public List<Message> FindMessage(String id){
        List<Message> list=new ArrayList<>();
        return list;
    }

    //存储账号
    public int SaveUser(User user){
        int reg = 0;
        return reg;
    }


    //存储用户留言内容
    public int SavaMessage(String id,String message){
        int reg = 0;
        return reg;
    }

    //修改用户留言内容（待定）
}
