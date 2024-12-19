<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="<c:url value="/template/admin/css/styles.css" />" rel="stylesheet" />
    <link href="<c:url value="/template/paging/jquery.twbsPagination.min.js" />" />
</head>
<body class="sb-nav-fixed">

    <%-- header --%>
    <%@ include file="/common/admin/header.jsp" %>
    <%-- header --%>

    <div id="layoutSidenav">
        <%-- menu --%>
        <%@ include file="/common/admin/menu.jsp" %>
        <%-- menu --%>

        <!-- content -->
        <dec:body/>
    </div>

    <%-- footer --%>
    <%@ include file="/common/admin/footer.jsp" %>
    <%-- footer --%>

    <!-- Bootstrap core JS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <!-- Core theme JS-->
    <script src="<c:url value="/template/web/js/scripts.js" />"></script>
    <!-- jQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Charts and Database-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/admin/assets/demo/chart-area-demo.js" />"></script>
    <script src="<c:url value="/template/admin/assets/demo/chart-bar-demo.js" />"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/admin/js/datatables-simple-demo.js" />"></script>
</body>
</html>
