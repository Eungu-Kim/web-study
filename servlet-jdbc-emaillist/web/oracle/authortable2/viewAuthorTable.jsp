<%@ page import="java.sql.*"%>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "webdb";
    String pass = "1234";

    String sql = "SELECT author_id, author_name, author_desc FROM author ORDER BY author_id DESC";

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next()) {
            int authorId = rs.getInt("author_id");
            String authorName = rs.getString("author_name");
            String authorDesc = rs.getString("author_desc");

            out.println("<tr class='data-row' data-id='" + authorId + "' data-name='" + authorName + "' data-desc='" + authorDesc + "'>");
            out.println("<td><input type='checkbox' name='selectedAuthor' value='" + authorId + "'></td>");
            out.println("<td>" + authorId + "</td>");
            out.println("<td>" + authorName + "</td>");
            out.println("<td>" + authorDesc + "</td>");
            out.println("</tr>");
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
%>