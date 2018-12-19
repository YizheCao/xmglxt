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
     * ȡ��һ�����ݿ����� 
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
        //������������
      	Class.forName(driver);
        //�������ݿ����ȡ��һ�����ݿ�����  
        conn = DriverManager.getConnection(url, user, password);  
        return conn;  
    }  
    
    /** 
     * ���ݴ����SQL��䷵��һ������� 
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
     * ���ݴ����SQL��������ݿ�����һ����¼ 
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
     * ���ݴ����SQL���������ݿ��¼ 
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
     * ���ݴ����SQL���ɾ��һ�����ݿ��¼ 
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
