<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Home Page</title>
    <!-- Favicon-->
    <link href="<c:url value="/template/web/assets/favicon.ico" />" rel="icon" type="image/x-icon" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value="/template/web/css/styles.css" />" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
    <%-- header --%>
    <%@ include file="/common/web/header.jsp" %>
    <%-- header --%>

    <div id="content">
        <dec:body/>
    </div>

    <%-- footer --%>
    <%@ include file="/common/web/footer.jsp" %>
    <%-- footer --%>

    <!-- Bootstrap core JS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <!-- Core theme JS-->
    <script src="<c:url value="/template/web/js/scripts.js" />"></script>
    <!-- jQuery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>
