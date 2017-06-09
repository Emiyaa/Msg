<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>留言板</title>
    <jsp:include page="/js/resource/easyui.jsp"></jsp:include>
    <style type="text/css">
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<center>
    <div style="width:800px;height:auto;border:2px solid #ccc;">

        <!-- 留言板标题 -->
        <table id="t_msg" title="留言板" class="easyui-datagrid"
               style="width:800px;height:auto;border:1px solid #ccc;">
        </table>

        <!-- 欢迎提示和退出登录 -->
        <div align="right" style="margin: 5px">

            <!-- 在此处添加用户名显示 -->

            <font style="font-family:微软雅黑;font-size:13px;">
                欢迎你：${pageContext.session.getAttribute("userNickName")}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/LogoutAction">
                    退出登录</a></font>
        </div>

        <!-- 搜索框 -->
        <div align="right" style="margin-right: 10px;padding: 3px">

            <!-- 在此处添加搜索表单 -->
            <form id="search" action="${pageContext.request.contextPath }/OpMessageAction?op=search" method="post">
                <input class="easyui-textbox" data-options="prompt:'请输入搜索关键字...'" width="300px" name="condition">&nbsp;
                <a href="#" class="easyui-linkbutton" style="height: 22px" iconCls="icon-search"
                   onclick="document.getElementById('search').submit();return false"></a>
            </form>
        </div>

        <!-- 留言版面内容 -->
        <table class="easyui-datagrid" style="width:700px;height:auto;border:1px solid #ccc;table-layout:fixed" align="center">
            <thead>
            <tr>
                <th data-options="field:'userNickName',align:'center',width:'15%'">昵称</th>
                <th data-options="field:'msgTime',align:'center',width:'22%'">发表时间</th>
                <th data-options="field:'msgContent',align:'center',width:'63%'">留言内容</th>
            </tr>
            </thead>
            <tbody>

            <!-- 在此处添加jstl标签遍历并显示留言列表 -->
            <c:forEach items="${msgList }" var="msg">
                <tr align="center">
                        <%--用户昵称--%>
                    <td>${msg.user.userNickName }</td>
                        <%--发布留言时间--%>
                    <td><font size="2">${msg.msgTime }</font></td>
                        <%--留言内容--%>
                    <td>${msg.msgContent }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- 翻页设置 -->

        <!-- 在此处添加翻页链接设置 -->

        <div align="center" style="padding: 5px">
            <font style="font-family:微软雅黑;font-size:13px;">
                <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.startPage}">第一页</a>&nbsp;
                <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.prevPage}">上一页</a>&nbsp;
                -${page.pageNow }-&nbsp;
                <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.nextPage}">下一页</a>&nbsp;
                <a href="${pageContext.request.contextPath }/OpMessageAction?str_pageNow=${page.endPage}">最后一页</a>&nbsp;
                共${page.endPage }页&nbsp;
            </font>
        </div>

        <!-- 提交留言 -->
        <div align="center">

            <!-- 在此处添加留言提交表单 -->
            <form id="form" action="${pageContext.request.contextPath }/OpMessageAction?op=add"
                  method="post">
                <input class="easyui-textbox" name="msgContent" data-options="multiline:true"
                       style="width: 700px;height: 50px"></br>
                <div style="padding: 5px">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
                       onclick="document.getElementById('form').submit(); return false">提交</a>
                </div>
            </form>
        </div>
    </div>
</center>
</body>
</html>