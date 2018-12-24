<%--
  Created by IntelliJ IDEA.
  User: 83708
  Date: 2018/12/22
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>shop</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--<script src="static/js/shopJS.js"></script>--%>
</head>
<body>


<nav class="navbar navbar-default " role="navigation">
    <div class="container">
        <div class="nav-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>商家</a>
        </div>
        <div style="padding-top: 5px">
            <p class="navbar-text navbar-left" id="shop_name">商店名</p>
            <ul class="nav navbar-nav navbar-right" style="padding-top: 10px">
                <li><button type="button" class="btn btn-warning ">
                    <span class="glyphicon glyphicon-log-out"></span>&nbsp;登出</button></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-1">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#" id="itemManage"><span class="glyphicon glyphicon-barcode"></span>&nbsp;商品管理</a></li>
                <li><a href="#" id="ordersManage"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;订单管理</a></li>
            </ul>
        </div>
        <div class="col-lg-11" id="shop_container">
            <div class="row" id="itemsearch">
                <div class="col-md-6">
                    <label for="inputSearchItemName"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索商品：</label>
                    <input class="input-large search-query" type="text" id="inputSearchItemName" placeholder="输入商品名称" />
                    <button type="submit" class="btn btn-primary" id="btnSearchItem">查找</button>
                </div>
                <div class="col-md-4 col-md-offset-2">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#upItemModal"><span class="glyphicon glyphicon-upload"></span>
                        &nbsp;上传商品</button>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#upImageModal"><span class="glyphicon glyphicon-picture"></span>
                        &nbsp;上传图片</button>
                </div>
            </div>

            <div class="row" id="orderssearch">
                <div class="col-md-6">
                    <label for="orderid" id="lb2"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索订单：</label>
                    <input class="input-large search-query" type="text"  name="itemid" id="orderId" placeholder="输入订单ID" />
                    <button type="submit" class="btn btn-primary" id="search2">查找</button>
                </div>
            </div>

            <div class="row" id="itemTable">
                <table class="table table-striped" id="initemTable"></table>
            </div>
            <div class="row" id="ordersTable">
                <table class="table table-striped" id="inordersTable"></table>
            </div>

            <div class="row" id="deleteItemSearch">
                <button class="btn btn-danger" data-toggle="modal" data-target="#deItemModal"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除商品</button>
            </div>
            <div class="row" id="changeOrderSearch">
                <button class="btn btn-success" data-toggle="modal" data-target="#chOrderModal"><span class="glyphicon glyphicon-random"></span>&nbsp;订单发货</button>
            </div>

            <%--删除商品模态框--%>
            <div class="modal fade" id="deItemModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除商品</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label>商品ID：</label>
                                    <input id="deItemInputId" class="form-control" type="text" placeholder="需删除商品的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnDeItem" type="button" class="btn btn-primary">删除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--订单发货模态框--%>
            <div class="modal fade" id="chOrderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-random"></span>&nbsp;订单发货</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label>商品ID：</label>
                                    <input id="chOrderInputId" class="form-control" type="text" placeholder="需发货订单的ID">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnChOrder" type="button" class="btn btn-primary">发货</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--上传商品模态框--%>
            <div class="modal fade" id="upItemModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-upload"></span>&nbsp;上传商品</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="upItemForm" method="post">
                                <div class="form-group">
                                    <label for="upItemName">商品名称：</label>
                                    <input type="text" class="form-control" id="upItemName" placeholder="请输入商品名称">
                                </div>
                                <div class="form-group">
                                    <label for="upItemCate">商品种类：</label>
                                    <select class="form-control" id="upItemCate">
                                        <%--动态请求商品种类--%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="upItemPrice">商品价格：</label>
                                    <input type="text" class="form-control" id="upItemPrice" placeholder="请输入商品价格">
                                </div>
                                <div class="form-group">
                                    <label for="upItemDescrip">商品描述：</label>
                                    <textarea class="form-control" id="upItemDescrip" placeholder="请输入商品描述"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="files">商品配图：</label>
                                    <form role="form" id="fileForm1" enctype="multipart/form-data" method="POST">
                                        <input type="file" name="files" id="files">
                                    </form>

                                </div>
                                <div class="form-group">
                                    <label for="upItemImageDes">图片描述：</label>
                                    <input type="text" class="form-control" id="upItemImageDes" placeholder="请对图片简单描述">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnUpItem" type="button" class="btn btn-primary">提交</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%--上传图片模态框--%>
            <div class="modal fade" id="upImageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-picture"></span>&nbsp;上传图片</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" id="upImageForm" method="post">
                                <div class="form-group">
                                    <label for="upImageItemId">商品ID：</label>
                                    <input type="text" class="form-control" id="upImageItemId" placeholder="请输入商品ID">
                                </div>
                                <div class="form-group">
                                    <label for="files">上传图片：</label>
                                    <form role="form" id="fileForm2" enctype="multipart/form-data" method="POST">
                                        <input type="file" name="file" id="file">
                                    </form>
                                </div>
                                <div class="form-group">
                                    <label for="upItemImageDes">图片描述：</label>
                                    <input type="text" class="form-control" id="upImageDes" placeholder="请对图片简单描述">
                                </div>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="btnUpImage" type="button" class="btn btn-primary">上传</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<%--<button class="btn btn-danger" onclick="del()"><span class="glyphicon glyphicon-trash"></span></button>--%>

<script>
    $(document).ready(function () {
        /*页面载入时*/
        $("#itemsearch").hide();
        $("#orderssearch").hide();
        $("#itemTable").hide();
        $("#ordersTable").hide();
        $("#deleteItemSearch").hide();
        $("#changeOrderSearch").hide();
    })

    $("#upItemModal").ready(function () {
        //上传商品时加载可选商品种类
        $.ajax({
            url: "/category/queryAll",
            type: "GET",
            dataType: "json",
            success: function (data) {
                $("#upItemCate").children("option").remove();
                if (data){
                    for (var i in data){
                        var html = "<option value=\""+data[i].categoryId+"\">"+data[i].name+"</option>";
                        $("#upItemCate").append(html);
                    }
                }else {
                    alert("加载类别出错");
                }
            }
        })
    })

    $("#btnSearchItem").click(function () {
        //搜索商品
        $("#initemTable").empty();
        $.ajax({
            url: "/item/queryItem?name=" + $("#inputSearchItemName").val(),
            type: "GET",
            dataType: "json",
            success: function (data) {
                $("#itemTable").children("p").remove();
                if (data[0]) {
                    var html = "";
                    html += "<thead><tr><th>商品ID</th><th>商品名称</th><th>商品种类</th><th>商品价格</th><th>商品描述</th><th>上架时间</th><th>商品状态</th></tr></thead><tbody>";
                    for (var i in data){
                        html += "<tr><td>"+data[i].itemId+"</td><td>"+data[i].name+"</td><td>"+data[i].categoryId+"</td><td>"+data[i].price+"</td><td>"+(data[i].description.substring(0,10)+"...")+"</td><td>"+data[i].shelfTime+"</td><td>"+data[i].state+"</td></tr>";
                    }
                    html += "</tbody>";
                    $("#initemTable").append(html);
                }else {
                    $("#itemTable").children("p").remove();
                    $("#itemTable").append($("<p></p>").text("未查询到商品！"))
                }
            }
        })
    })

    $("#btnUpImage").click(function () {
        //单独上传图片
        var formData = new FormData();
        formData.append("files", $("#file")[0].files[0]);
        formData.append("itemId", $("#upImageItemId").val());
        formData.append("imageDescription", $("#upImageDes").val());
        $.ajax({
            url: "/shop/item/insertItemImage",
            type: "POST",
            cache: false,
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
                alert("上传成功");
            },
            error: function (jqXHR) {
                alert("发生错误"+jqXHR.status);
            }
        })
    })

    $("#btnUpItem").click(function () {
        //上传商品、图片
        $.ajax({
            url: "/shop/item/insertItem",
            type: "POST",
            data: {
                "itemId": 0,
                "categoryId": $("#upItemCate").val(),
                "name": $("#upItemName").val(),
                "price": $("#upItemPrice").val(),
                "description": $("#upItemDescrip").val(),
                "shelfTime": new Date(),
                "shopId": 1,  //shopID传值待修改s
                "state": 0
            },
            dateType: "json",
            success: function (data) {
                if (data){
                    //上传成功，继续上传图片
                    var formData = new FormData();
                    formData.append("files", $("#files")[0].files[0]);
                    formData.append("itemId", 0);
                    formData.append("imageDescription", $("#upItemImageDes").val());
                    $.ajax({
                        url: "/shop/item/insertItemImage",
                        type: "POST",
                        cache: false,
                        data: formData,
                        contentType: false,
                        processData: false,
                        success: function (data) {
                            $("#itemTable").children("p").remove();
                            if (data){
                                $("#initemTable").empty();
                                $.ajax({
                                    url: "/item/viewItem?shopId="+1,  //shopID传值待修改
                                    type: "GET",
                                    dataType: "json",
                                    success: function (data){
                                        if (data[0]) {
                                            var html = "";
                                            html += "<thead><tr><th>商品ID</th><th>商品名称</th><th>商品种类</th><th>商品价格</th><th>商品描述</th><th>上架时间</th><th>商品状态</th></tr></thead><tbody>";
                                            for (var i in data){
                                                html += "<tr><td>"+data[i].itemId+"</td><td>"+data[i].name+"</td><td>"+data[i].name1+"</td><td>"+data[i].price+"</td><td>"+(data[i].description.substring(0,10)+"...")+"</td><td>"+data[i].shelfTime+"</td><td>"+data[i].state+"</td></tr>";
                                            }
                                            html += "</tbody>";
                                            $("#initemTable").append(html);
                                        }else {
                                            $("#itemTable").children("p").remove();
                                            $("#itemTable").append($("<p></p>").text("未查询到商品！"))
                                        }
                                    },
                                    error: function (jqXHR) {
                                        alert("发生错误1："+jqXHR.status);
                                    }
                                })
                            } else {
                                alert("上传图片失败");
                            }
                        },
                        error: function (jqXHR) {
                            alert("发生错误2："+jqXHR.status);
                        }
                    })
                } else {
                    alert("上传商品失败");
                }
            },
            error: function (jqXHR) {
                alert("发生错误3："+jqXHR.status);
            }
        })
    })

    $("#itemManage").click(function () {
        //加载商品管理界面
        $("#itemsearch").show();
        $("#orderssearch").hide();
        $("#ordersTable").hide();
        $("#initemTable").empty();
        $("#itemTable").show();
        $("#deleteItemSearch").show();
        $("#changeOrderSearch").hide();
        $.ajax({
            url: "/item/viewItem?shopId="+1,  //shopID传值待修改
            type: "GET",
            dataType: "json",
            success: function (data){
                $("#itemTable").children("p").remove();
                if (data[0]) {
                    var html = "";
                    html += "<thead><tr><th>商品ID</th><th>商品名称</th><th>商品种类</th><th>商品价格</th><th>商品描述</th><th>上架时间</th><th>商品状态</th></tr></thead><tbody>";
                    for (var i in data){
                        html += "<tr><td>"+data[i].itemId+"</td><td>"+data[i].name+"</td><td>"+data[i].name1+"</td><td>"+data[i].price+"</td><td>"+(data[i].description.substring(0,10)+"...")+"</td><td>"+data[i].shelfTime+"</td><td>"+data[i].state+"</td></tr>";
                    }
                    html += "</tbody>";
                    $("#initemTable").append(html);
                }else {
                    $("#itemTable").children("p").remove();
                    $("#itemTable").append($("<p></p>").text("未查询到商品！"))
                }
            }
        })
    })


    $("#ordersManage").click(function () {
        //加载订单管理界面
        $("#itemsearch").hide();
        $("#orderssearch").show();
        $("#itemTable").hide();
        $("#inordersTable").empty();
        $("#ordersTable").show();
        $("#deleteItemSearch").hide();
        $("#changeOrderSearch").show();
        $.ajax({
            url: "/shop/order/viewOrder?shopId="+1,  //shopID传值待修改
            type: "GET",
            dataType: "json",
            success: function (data){
                $("#ordersTable").children("p").remove();
                if (data[0]) {
                    var html = "";
                    html += "<thead><tr><th>订单ID</th><th>下单时间</th><th>商品ID</th><th>商品名称</th><th>商品单价</th><th>商品数量</th><th>订单金额</th><th>收货人</th><th>收货人电话</th><th>收货地址</th><th>订单状态</th><th>下单用户ID</th></tr></thead><tbody>";
                    for (var i in data){
                        html += "<><td>"+data[i].orderId+"</td><td>"+data[i].orderTime+"</td><td>"+data[i].itemId+"</td><td>"+data[i].itemName+"</td><td>"+data[i].singlePrice+"</td><td>"+data[i].number+"</td><td>"+data[i].totalPrice+"</td><td>"+
                            data[i].receiver+"</td><td>"+data[i].phone+"</td><td>"+data[i].address+"</td><td>"+data[i].status+"</td><td>"+data[i].userId+"</td></tr>";
                    }
                    html += "</tbody>";
                    $("#inordersTable").append(html);
                }else {
                    $("#ordersTable").children("p").remove();
                    $("#ordersTable").append($("<p></p>").text("未查询到订单！"))
                }
            }
        })
    })

    $("#btnDeItem").click(function () {
        //删除商品
        $.ajax({
            url: "/item/deleteItemMessage?itemId="+$("#deItemInputId").val(),
            type: "GET",
            dataType: "json",
            success: function () {
                $("#itemTable").children("p").remove();
                $("#initemTable").empty();
                $("#deleteItemSearch").show();
                $.ajax({
                    url: "/item/viewItem?shopId="+1,  //shopID传值待修改
                    type: "GET",
                    dataType: "json",
                    success: function (data){
                        if (data[0]) {
                            var html = "";
                            html += "<thead><tr><th>商品ID</th><th>商品名称</th><th>商品种类</th><th>商品价格</th><th>商品描述</th><th>上架时间</th><th>商品状态</th></tr></thead><tbody>";
                            for (var i in data){
                                html += "<tr><td>"+data[i].itemId+"</td><td>"+data[i].name+"</td><td>"+data[i].name1+"</td><td>"+data[i].price+"</td><td>"+(data[i].description.substring(0,10)+"...")+"</td><td>"+data[i].shelfTime+"</td><td>"+data[i].state+"</td></tr>";
                            }
                            html += "</tbody>";
                            $("#initemTable").append(html);
                        }else {
                            $("#itemTable").children("p").remove();
                            $("#itemTable").append($("<p></p>").text("未查询到商品！"))
                        }
                    }
                })
                alert("删除成功");
            }
        })
    })

    $("#btnChOrder").click(function () {
        //订单发货
        $.ajax({
            url: "/shop/order/deliverItem?orderId="+$("#chOrderInputId").val(),
            type: "GET",
            dataType: "json",
            success: function () {
                alert("发货成功");
                $("#ordersTable").children("p").remove();
                $("#inordersTable").empty();
                $("#changeOrderSearch").show();
                $.ajax({
                    url: "/shop/order/viewOrder?shopId="+1,  //shopID传值待修改
                    type: "GET",
                    dataType: "json",
                    success: function (data){
                        $("#ordersTable").children("p").remove();
                        if (data[0]) {
                            var html = "";
                            html += "<thead><tr><th>订单ID</th><th>下单时间</th><th>商品ID</th><th>商品名称</th><th>商品单价</th><th>商品数量</th><th>订单金额</th><th>收货人</th><th>收货人电话</th><th>收货地址</th><th>订单状态</th><th>下单用户ID</th></tr></thead><tbody>";
                            for (var i in data){
                                html += "<><td>"+data[i].orderId+"</td><td>"+data[i].orderTime+"</td><td>"+data[i].itemId+"</td><td>"+data[i].itemName+"</td><td>"+data[i].singlePrice+"</td><td>"+data[i].number+"</td><td>"+data[i].totalPrice+"</td><td>"+
                                    data[i].receiver+"</td><td>"+data[i].phone+"</td><td>"+data[i].address+"</td><td>"+data[i].status+"</td><td>"+data[i].userId+"</td></tr>";
                            }
                            html += "</tbody>";
                            $("#inordersTable").append(html);
                        }else {
                            $("#ordersTable").children("p").remove();
                            $("#ordersTable").append($("<p></p>").text("未查询到订单！"))
                        }
                    }
                })
            }
        })
    })

    $("#search2").click(function () {
        //搜索订单
        $("#inordersTable").empty();
        $.ajax({
            url: "/shop/order/shopQueryOrder?orderId=" + $("#orderId").val(),
            type: "GET",
            dataType: "json",
            success: function (data){
                $("#ordersTable").children("p").remove();
                if (data) {
                    var html = "";
                    html += "<thead><tr><th>订单ID</th><th>下单时间</th><th>商品ID</th><th>商品名称</th><th>商品单价</th><th>商品数量</th><th>订单金额</th><th>收货人</th><th>收货人电话</th><th>收货地址</th><th>订单状态</th><th>下单用户ID</th></tr></thead><tbody>";
                    html += "<><td>"+data.orderId+"</td><td>"+data.orderTime+"</td><td>"+data.itemId+"</td><td>"+data.itemName+"</td><td>"+data.singlePrice+"</td><td>"+data.number+"</td><td>"+data.totalPrice+"</td><td>"+
                        data.receiver+"</td><td>"+data.phone+"</td><td>"+data.address+"</td><td>"+data.status+"</td><td>"+data.userId+"</td></tr>";
                    html += "</tbody>";
                    $("#inordersTable").append(html);
                }else {
                    $("#ordersTable").children("p").remove();
                    $("#ordersTable").append($("<p></p>").text("未查询到订单！"))
                }
            }
        })
    })

</script>
</body>
</html>
