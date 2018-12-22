<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/12/22
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>商家主页</title>
    <link href="../css/bootstrap-combined.min.css" rel="stylesheet" />
    <link href="../css/layoutit.css" rel="stylesheet" />
    <!-- 可视化对bootstrap4.0及以上版本兼容性不好 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#itemForm").hide();
            $("#btnForm").hide();
            $.ajax({
                url: "/shop/viewItemMessage?shopId="+1,
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if(data){
                        var html = "";
                        html += "<thead><tr><th>商品id</th><th>类别id</th><th>商品名</th><th>商品价格</th><th>描述</th><th>邮箱</th><th>地址</th><th>地址</th><th>地址</th><th>地址</th><th>地址</th></tr></thead>";
                        for(var i in data){
                            html += "<tr><td>"+data[i].itemId+"</td><td>"+data[i].categoryId+"</td><td>"+data[i].name+"</td><td>"+data[i].price+"</td><td>"+data[i].description+"</td><td>"+data[i].shelfTime+"</td><td>"+data[i].shopId+"</td>" +
                                "<td>"+data[i].state+"</td><td>"+data[i].imageId+"</td><td>"+data[i].imageUrl+"</td><td>"+data[i].imageDescription+"</td></tr>";
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
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3 class="text-center text-info">
                商家主页
            </h3>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span2">
            <ul class="nav nav-list">
                <li class="nav-header">
                    <p>
                        商品管理
                    </p>
                </li>
                <li>
                    <a href="#" id="itemMessage">查看编辑商品信息</a>
                </li>
                <li>
                    <a href="#" id="uploadItem">上传商品</a>
                </li>

                <li class="nav-header">
                    订单管理
                </li>
                <li>
                    <a href="#" id="viewBook">查看编辑订单信息</a>
                </li>

            </ul>
        </div>
        <div class="span10">
            <div class="col-md-6">
                <label for="itemid" id="lb1"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索商品：</label>
                <input class="input-large search-query" type="text"  name="itemid" id="itemid" placeholder="输入商品id或名字" />
                <button type="submit" class="btn btn-primary" id="search21">查找</button>
            </div>

            <table class="table table-hover" id="searchResult">
            </table>
            <table class="table table-hover" id="searchResult1">
            </table>
            <table class="table table-hover" id="searchResult2">
            </table>
            <table class="table table-hover" id="searchResult3">
            </table>

            <%--<div id="showOrNot">
                <input class="input-large search-query" type="text"  name="updateState" id="updateState" placeholder="输入更新订单的id" />
                <button type="button" class="btn" id="toggle">修改订单状态</button>
            </div>--%>

            <form class="form-horizontal" role="form" id="itemForm" method="post">
                <legend>输入商品信息</legend>
                <div class="form-group">
                    <label class="col-sm-2">选择类别：</label>
                    <div class="col-sm-8">
                        <%--下拉列表，异步请求出服务器的类别--%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">商品名：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" placeholder="请输入商品名">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">价格：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="price" placeholder="请输入价格">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">上架时间：</label>
                    <div class="col-sm-8">
                        <%--选择时间--%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">商品简介：</label>
                    <div class="col-sm-8">
                        <!-- <input type="text" class="form-control" id="description" placeholder="请输入简介">-->
                        <textarea type="text" class="form-control" id="description" placeholder="请输入商品简介"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">上传图片：</label>
                    <div class="col-sm-8">
                        <form class="form-horizontal" role="form" id="fileForm" enctype="multipart/form-data" method="POST">
                            <input type="file" name="files" id="files">
                        </form>
                    </div>
                </div>
                <div class="form-group" id="btnForm">
                    <button type="button" class="btn col-sm-10 bg-info text-white" id="submitBook">提交</button>
                </div>
            </form>
            <!--<div class="pagination">
                <ul>
                    <li>
                        <a href="#">上一页</a>
                    </li>
                    <li>
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li>
                        <a href="#">下一页</a>
                    </li>
                </ul>
            </div>-->
        </div>
    </div>
</div>
</body>
</html>
