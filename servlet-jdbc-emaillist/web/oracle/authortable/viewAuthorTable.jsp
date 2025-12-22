<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%! 
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  
  String url = "jdbc:oracle:thin:@localhost:1521:XE";
  String user = "webdb";
  String pass = "1234";
  
  String sql = " Select author_id, " 
             + " author_name,"
             + " author_desc"
             + " from author"
             + " order by author_id";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저자정보</title>
<style type="text/css" media="screen">
*           { margin:0; padding:0 }
body { 
  font-family: '맑은 고딕' 돋움; 
  font-size:0.75em; 
  color:#333 }
  
h1 { 
  text-align:center; 
}

.tbl-ex { 
  margin:10px auto; 
  border:1px solid #333; 
  border-collapse:collapse;
}

.tbl-ex th  { 
  border:1px solid #333; 
  padding:8px;
  text-align: center;
}

.tbl-ex td  { 
  border:1px solid #333; 
  padding:8px;
  text-align: left;
} 

.tbl-ex th        { background-color:#999; font-size:1.1em; color:#fff; }

.tbl-ex tr.even     { background-color:#E8ECF6  }

.tbl-ex td:hover,
.tbl-ex td.even:hover   { background-color:#fc6; cursor:pointer }

a {
    font-size: 15px;
    margin-left: 20px;
    margin-top: 20px;
}
</style>
</head>
<body>

<table width=800 class=tbl-ex>
  <tr>
    <th>저자번호</th>
    <th>저자명</th>
    <th>설명</th>
  </tr>
  
  <%
  try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn = DriverManager.getConnection(url, user, pass);
    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();
    
    while(rs.next()){
      out.println("<tr>");
      out.println("<td>" + rs.getInt("author_id") + "</td>");
      out.println("<td>" + rs.getString("author_name") + "</td>");
      out.println("<td>" + rs.getString("author_desc") + "</td>");
      out.println("</tr>");
    }
  }catch(Exception e){
    e.printStackTrace();
  }finally{
    try{
      if(rs != null) rs.close();
      if(pstmt != null) pstmt.close();
      if(conn != null) conn.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  %>
 </table>
<p></p>
<a href="insertForm.jsp">돌아가기</a>
</body>
</html>
