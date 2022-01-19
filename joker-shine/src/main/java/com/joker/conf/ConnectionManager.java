//package com.joker.conf;
//
//import org.omg.CORBA.portable.ApplicationException;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * ConnectionManager
// *
// * @author joker
// * @version 1.0
// * 2022/1/19 16:35
// **/
//
//public class ConnectionManager {
//
//
//    //设置当前线程变量，以确保获得的是同一Connection
//    private static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>();
//
//    public static Connection getConnection(){
//        //获得线程中对应的Connection
//        Connection conn=connectionHolder.get();
//        //假设当前线程中没有绑定对应的Connection
//        if (conn==null){
//            try {
//                JdbcConfig jdbcConfig=XmlConfigReader.getInstance().getJdbcConfig();
//                //载入驱动
//                Class.forName(jdbcConfig.getDriverName());
//                String url=jdbcConfig.getUrl();
//                String userName=jdbcConfig.getUserName();
//                String password=jdbcConfig.getPassword();
//                //建立连接
//                conn = (Connection) DriverManager.getConnection(url, userName, password);
//                //将Connection设置到当前线程中
//                connectionHolder.set(conn);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//                throw new ApplicationException("系统错误，请联系管理员！");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                throw new ApplicationException("系统错误。请联系管理员！");
//            }
//        }
//        return conn;
//    }
//
//    /**
//     * 关闭连接
//     */
//    public static void closeConnection(){
//        //从ThreadLocal中获取Connection
//        Connection conn=connectionHolder.get();
//        if (conn!= null){
//            try {
//                conn.close();
//                //从ThreadLocal中清除Connection
//                connectionHolder.remove();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    /**
//     * 手动开启事务
//     * @param conn
//     */
//    public static void beginTransaction(Connection conn){
//        try{
//            if (conn != null){
//                if (conn.getAutoCommit()){
//                    conn.setAutoCommit(false); //手动提交
//                }
//            }
//        }catch(SQLException e){}
//    }
//
//    /**
//     * 手动提交事务
//     * @param conn
//     */
//    public static void commitTransaction(Connection conn){
//        try{
//            if (conn!=null){
//                if (!conn.getAutoCommit()){
//                    conn.commit();
//                }
//            }
//        }catch(SQLException e){}
//    }
//
//    /**
//     * 回滚事务
//     * @param conn
//     */
//    public static void rollbackTransaction(Connection conn){
//        try{
//            if (conn!=null){
//                if (!conn.getAutoCommit()){
//                    conn.rollback();
//                }
//            }
//        }catch(SQLException e){}
//    }
//
//    public static void resetConnection(Connection conn){
//        try{
//            if (conn!=null){
//                if (conn.getAutoCommit()){
//                    conn.setAutoCommit(false);
//                }else{
//                    conn.setAutoCommit(true);
//                }
//            }
//        }catch(SQLException e){}
//    }
//}
