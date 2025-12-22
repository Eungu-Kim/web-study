package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmaillistDao {

  private DBConnectionMgr pool;

  public EmaillistDao() {
    try {
      pool = DBConnectionMgr.getInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<EmaillistVo> getList() {

    // 0. import java.sql.*;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<EmaillistVo> list = new ArrayList<EmaillistVo>();

    try {
      conn = pool.getConnection();
      
      // 3. SQL문 준비 / 바인딩 / 실행
      String query = "select no, last_name, first_name, email "
                   + "from emaillist "
                   + "order by no desc" ;
      pstmt = conn.prepareStatement(query);
      
      rs = pstmt.executeQuery();
      // 4.결과처리
      while(rs.next()) {
        int no = rs.getInt("no");
        String lastName = rs.getString("last_name");
        String firstName = rs.getString("first_name");
        String email = rs.getString("email");
        
        EmaillistVo vo = new EmaillistVo(no, lastName, firstName, email);
        list.add(vo);
      }
      
      
    } catch (SQLException e) {
      
      System.out.println("error:" + e);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 5. 자원정리
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (conn != null) {
          pool.freeConnection(conn);
        }
      } catch (SQLException e) {
        System.out.println("error:" + e);
      }

    }

    return list;
  }
  
  
  public boolean insert(EmaillistVo vo) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int count = 0 ;
    
    try {
      conn = pool.getConnection();
      
      String query ="insert into emaillist values (seq_emaillist_no.nextval, ?, ?, ?)";
      pstmt = conn.prepareStatement(query); 
      
      pstmt.setString(1, vo.getLastName());
      pstmt.setString(2, vo.getFirstName());
      pstmt.setString(3, vo.getEmail());
    
      count = pstmt.executeUpdate();
      
      System.out.println(count + "건 등록");
      
    } catch (SQLException e) {
      System.out.println("error:" + e);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null) pstmt.close();
        if (conn != null) pool.freeConnection(conn);
      } catch (SQLException e) {
        System.out.println("error:" + e);
      }
    }
    return (count>0)?true:false;
  }
  
  public boolean delete(EmaillistVo vo) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int count = 0 ;
    
    try {
      conn = pool.getConnection();
      
      String query ="delete from emaillist where no = ?";
      pstmt = conn.prepareStatement(query); 
      
      pstmt.setInt(1, vo.getNo());
      
      count = pstmt.executeUpdate();
      
      System.out.println(count + "건 삭제");
      
    } catch (SQLException e) {
      System.out.println("error:" + e);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null) pstmt.close();
        if (conn != null) pool.freeConnection(conn);
      } catch (SQLException e) {
        System.out.println("error:" + e);
      }
    }
    return (count>0)?true:false;
  }
  

}
