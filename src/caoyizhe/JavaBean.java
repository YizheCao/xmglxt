package caoyizhe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaBean {
	private int id = 0;
	private String no = null;
	private String name = null;
	private String password = null;
	
	public JavaBean() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 
     * 取得一个数据库连接 
     *  
     * @return 
     * @throws Exception 
     */  
    public Connection getConnection() throws Exception {  
        Connection conn = null;  
        String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/xmglxt?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "";
        //加载驱动程序
      	Class.forName(driver);
        //根据数据库参数取得一个数据库连接  
        conn = DriverManager.getConnection(url, user, password);  
        return conn;  
    }  
    
    /** 
     * 根据传入的SQL语句返回一个结果集 
     *  
     * @param sql 
     * @return 
     * @throws Exception 
     */  
    public ResultSet select(String sql) throws Exception {  
        Connection conn = null;  
        Statement stmt = null;  
        ResultSet rs = null;  
        try {  
            conn = getConnection();  
            stmt = conn.createStatement();  
            rs = stmt.executeQuery(sql);  
            return rs;  
        } catch (SQLException sqle) {  
            throw new SQLException("select data exception: " + sqle.getMessage());  
        } catch (Exception e) {  
            throw new Exception("System e exception: " + e.getMessage());  
        }  
    }  
    
    /** 
     * 根据传入的SQL语句向数据库增加一条记录 
     *  
     * @param sql 
     * @throws Exception 
     */  
    public void insert(String sql) throws Exception {  
        Connection conn = null;  
        PreparedStatement ps = null;  
        try {  
            conn = getConnection();  
            ps = conn.prepareStatement(sql);  
            ps.executeUpdate();  
        } catch (SQLException sqle) {  
            throw new Exception("insert data exception: " + sqle.getMessage());  
        } finally {  
            try {  
                if (ps != null) {  
                    ps.close();  
                }  
            } catch (Exception e) {  
                throw new Exception("ps close exception: " + e.getMessage());  
            }  
        }  
        try {  
            if (conn != null) {  
                conn.close();  
            }  
        } catch (Exception e) {  
            throw new Exception("connection close exception: " + e.getMessage());  
        }  
    }  
    
    /** 
     * 根据传入的SQL语句更新数据库记录 
     *  
     * @param sql 
     * @throws Exception 
     */  
    public void update(String sql) throws Exception {  
        Connection conn = null;  
        PreparedStatement ps = null;  
        try {  
            conn = getConnection();  
            ps = conn.prepareStatement(sql);  
            ps.executeUpdate();  
        } catch (SQLException sqle) {  
            throw new Exception("update exception: " + sqle.getMessage());  
        } finally {  
            try {  
                if (ps != null) {  
                    ps.close();  
                }  
            } catch (Exception e) {  
                throw new Exception("ps close exception: " + e.getMessage());  
            }  
        }  
        try {  
            if (conn != null) {  
                conn.close();  
            }  
        } catch (Exception e) {  
            throw new Exception("connection close exception: " + e.getMessage());  
        }  
    } 
    
    /** 
     * 根据传入的SQL语句删除一条数据库记录 
     *  
     * @param sql 
     * @throws Exception 
     */  
    public void delete(String sql) throws Exception {  
        Connection conn = null;  
        PreparedStatement ps = null;  
        try {  
            conn = getConnection();  
            ps = conn.prepareStatement(sql);  
            ps.executeUpdate();  
        } catch (SQLException sqle) {  
            throw new Exception("delete data exception: " + sqle.getMessage());  
        } finally {  
            try {  
                if (ps != null) {  
                    ps.close();  
                }  
            } catch (Exception e) {  
                throw new Exception("ps close exception: " + e.getMessage());  
            }  
        }  
        try {  
            if (conn != null) {  
                conn.close();  
            }  
        } catch (Exception e) {  
            throw new Exception("connection close exception: " + e.getMessage());  
        }  
    } 
}
