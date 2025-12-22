<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%!
    Connection conn = null;
    PreparedStatement pstmt = null;

    String url = "jdbc:oracle:thin:@localhost:1521/XE";
    String user = "webdb";
    String pass = "1234";

    String sql = "delete from author where author_id = ?";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String author_id= request.getParameter("author_id");

    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, pass);

        //미리 미완성의 sql을 등록시켜 놓겠다.
        pstmt = conn.prepareStatement(sql);

        //바인딩 시키기
        pstmt.setInt(1, Integer.parseInt(author_id));

        pstmt.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
%>
<script>
    alert("삭제 완료");
    document.location.href = "authorApp.jsp";
</script>

</body>
</html>