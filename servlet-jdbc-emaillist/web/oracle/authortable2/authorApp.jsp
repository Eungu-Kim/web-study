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
            + " order by author_id desc";
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

        /* 선택된 행 스타일 추가 */
        .tbl-ex tr.selected {
            background-color: #4CAF50 !important;
            color: white;
        }

        .tbl-ex tr.selected:hover {
            background-color: #45a049 !important;
        }

        div {
            display: block;
            font-size: 20px;
            margin-left: 20px;
            margin-top: 20px;
            text-align: center;
        }

        input {
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }

        #submit,
        #delete {
            display: block;
            margin: 10px auto;
            padding: 5px 10px;
            font-size: 16px;
            cursor: pointer;
        }

        /* 테이블 행에 커서 변경 */
        #teams tbody tr {
            cursor: pointer;
        }

    </style>
</head>
<body>
<div>저자 정보</div>

<form action="insertAuthor.jsp" method="post" id="authorForm">
    <table width="800" class="tbl-ex tbl" id="teams">
        <input type="hidden" name="author_id" id="author_id" value="">
        <tr>
            <td>저자명: <input type="text" name="author_name" id="author_name" size="20"></td>
            <td>설명: <input type="text" name="author_desc" id="author_desc" size="20"></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="제출" id="submit">

</form>

<table width=800 class=tbl-ex id="authorTable">
    <tr>
        <th>선택</th>
        <th>저자번호</th>
        <th>저자명</th>
        <th>설명</th>
    </tr>
    <%@ include file="viewAuthorTable.jsp"%>
</table>

<script src="authorScript.js"></script>

</body>
</html>