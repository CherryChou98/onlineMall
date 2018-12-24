<%@ page import="onlineMall.web.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 83708
  Date: 2018/12/22
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        /*页面载入时*/
        $(document).ready(function () {
            $("#itemUpRequestTable").hide();
            $("#blogTable").hide();
            $("#commentTable").hide();
            $.ajax({
                url: "/category/queryAll",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    $("#categoryTable").children("incategoryTable").remove();
                    if(data[0].categoryId){
                        var html = "";
                        html += "<thead><tr><th>类别id</th><th>类别名</th></tr></thead>";
                        for(var i in data){
                            html += "<tr><td>"+data[i].categoryId+"</td><td>"+data[i].name+"</td><td></tr>";
                            $("#searchResult").html(html);
                        }
                    }else {
                        $("#searchResult").html("未查询到用户");
                    }
                },
                error: function (jqXHR) {
                    alert("发生错误："+jqXHR.status);
                }
        })
        /*点击商品分类管理时*/

    </script>
</head>
<body>


<nav class="navbar navbar-default " role="navigation">
    <div class="container">
        <div class="nav-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-briefcase"></span>管理员</a>
        </div>
        <div style="padding-top: 5px">
            <p class="navbar-text navbar-left" id="admin_name"></p>
            <ul class="nav navbar-nav navbar-right" style="padding-top: 10px">
                <li><form method="post" action="/login/redirectIndex"><span class="glyphicon glyphicon-log-out"></span>&nbsp;
                    <input type="submit" class="btn btn-warning" id="btnAdminLogout" value="登出"></form></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-2">
            <%--左导航栏--%>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#" id="categoryManage"><span class="glyphicon glyphicon-tags"></span>&nbsp;商品分类管理</a></li>
                <li><a href="#" id="itemUpRequestManage"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;商品上传申请</a></li>
                <li><a href="#" id="blogManage"><span class="glyphicon glyphicon-bold"></span>&nbsp;论坛管理</a></li>
                <li><a href="#" id="commentManage"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;评论管理</a></li>
            </ul>
        </div>
        <div class="col-md-10" id="admin_container">


            <div class="row" id="categoryTable">
                <%--分类表格及其操作按钮--%>
                <div class="row" id="categoryHeader">
                    <div class="col-md-4">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#newCategoryModal"><span class="glyphicon glyphicon-upload"></span>
                            &nbsp;新建分类</button>&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-danger" data-toggle="modal" data-target="#deCategoryModal"><span class="glyphicon glyphicon-trash"></span>
                            &nbsp;删除分类</button>
                    </div>
                </div>
                <table class="table table-striped" id="incategoryTable"></table>
            </div>

            <div class="row" id="itemUpRequestTable">
                <%--商品上传申请表格及其操作按钮--%>
                <div class="row">
                    <div class="col-md-4">
                        <button class="btn btn-success" data-toggle="modal" data-target="#passRequestModal"><span class="glyphicon glyphicon-ok"></span>
                            &nbsp;通过申请</button>&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-danger" data-toggle="modal" data-target="#deRequestModal"><span class="glyphicon glyphicon-trash"></span>
                            &nbsp;删除申请</button>
                    </div>
                </div>
                <table class="table table-striped" id="initemUpRequestTable"></table>
            </div>

            <div class="row" id="blogTable">
                <%--博客表格及其操作按钮--%>
                <div class="row">
                <div class="col-md-6">
                    <%--搜索博客、无模态框--%>
                    <label for="inputSearchBlog"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索帖子：</label>
                    <input class="input-large search-query" type="text" id="inputSearchBlog" placeholder="输入关键字" />
                    <button type="submit" class="btn btn-primary" id="btnSearchBlog" >搜索</button>
                </div>
                <div class="col-md-4">
                    <%--删除博客--%>
                    <button class="btn btn-danger" data-toggle="modal" data-target="#deBlogModal"><span class="glyphicon glyphicon-trash"></span>
                        &nbsp;删除帖子</button>
                </div>
                </div>
                <table class="table table-striped" id="inblogTable"></table>
            </div>

            <div class="row" id="commentTable">
                <%--评论表格及其操作按钮--%>
                <div class="row">
                    <div class="col-md-4">
                        <button class="btn btn-danger" data-toggle="modal" data-target="#deCommentModal"><span class="glyphicon glyphicon-trash"></span>
                            &nbsp;删除评论</button>
                    </div>
                </div>
                <table class="table table-striped" id="incommentTable"></table>
            </div>


            <%--新建分类模态框--%>
            <div class="modal fade" id="newCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-upload"></span>&nbsp;新建分类</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="newCategoryForm" method="post">
                                <div class="form-group">
                                    <label for="inputNewCateName">分类名称：</label>
                                    <input type="text" class="form-control" id="inputNewCateName" placeholder="请输入分类名称">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnNewCategory" type="button" class="btn btn-primary">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--删除分类模态框--%>
            <div class="modal fade" id="deCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除分类</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="deCategoryForm" method="post">
                                <div class="form-group">
                                    <label>分类ID：</label>
                                    <input id="inputDeCateId" class="form-control" type="text" placeholder="需删除分类的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnDeCategory" type="button" class="btn btn-danger">删除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--通过申请模态框--%>
            <div class="modal fade" id="passRequestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-ok"></span>&nbsp;通过申请</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="passRequestForm" method="post">
                                <div class="form-group">
                                    <label>申请ID：</label>
                                    <input id="inputPassReId" class="form-control" type="text" placeholder="需通过申请的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnPassRequest" type="button" class="btn btn-success">通过</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--删除申请模态框--%>
            <div class="modal fade" id="deRequestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除申请</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="deRequestForm" method="post">
                                <div class="form-group">
                                    <label>申请ID：</label>
                                    <input id="inputDeReId" class="form-control" type="text" placeholder="需删除申请的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnDeRequest" type="button" class="btn btn-danger">删除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--删除博客模态框--%>
            <div class="modal fade" id="deBlogModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除帖子</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="deBlogForm" method="post">
                                <div class="form-group">
                                    <label>帖子ID：</label>
                                    <input id="inputDeBlogId" class="form-control" type="text" placeholder="需删除帖子的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnDeBlog" type="button" class="btn btn-danger">删除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--删除评论模态框--%>
            <div class="modal fade" id="deCommentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除评论</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="deCommentForm" method="post">
                                <div class="form-group">
                                    <label>评论ID：</label>
                                    <input id="inputDeCommentId" class="form-control" type="text" placeholder="需删除评论的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnDeComment" type="button" class="btn btn-danger">删除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<script>
    $(document).ready(function () {
        $("#admin_name").text("");
        <%
          User user = (User)session.getAttribute("admin");
          if (user != null){
        %>
        $("#admin_name").text("管理员用户名："+"<%=user.getUserName()%>");
        <%
          }else {
        %>
        $("#admin_name").text("未登录");
        <%
          }
        %>
    })

    $("#btnShopLogout").click(function () {
        <%session.removeAttribute("admin");%>
    })
</script>
</body>
</html>
