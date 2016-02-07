<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href="/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/assets/css/bootstrap-switch.css" rel="stylesheet"/>
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way
                 to the bottom of the topbar */
        }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
    </script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
    </style>
</head>
<body>

<%@include file="header1.jsp" %>
<div class="container">
    <div class="hero-unit">

        <form:form method="post" enctype="multipart/form-data" action="fileUpload.htm">
            <table>
                <tr>
                    <td>
                        <div class="col-sm-6 col-lg-4">
                            <h4 class="h4">Upload File:</h4>
                            <p>
                                <input type="file" name="file"/>
                            </p>
                        </div>
                    </td>
                    <td style="color: red; font-style: italic;"><form:errors path="file"/> </td>
                    <td>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </td>

                </tr>
                <tr>
                    <td>
                        <div class="col-sm-6 col-lg-4">
                            <label for="domains"><h4 class="h4">Category:</h4></label>
                            <input id="domains" name="domains" class="form-control"/>
                        </div>
                        <div class="col-sm-6 col-lg-4">
                            <label for="description"><h4 class="h4">Description:</h4></label>
                            <textarea id="description" name="description" class="form-control" rows="2"></textarea>
                        </div>
                    </td>
                    <td></td>
                    <td>
                        <div class="col-sm-6 col-lg-4">
                            <h4 class="h4">Searchable?</h4>
                            <p>
                                <input id="searchable" name="searchable" type="checkbox"   checked="true" data-size="mini">
                            </p>
                        </div><br/>
                        <div class="col-sm-6 col-lg-4">
                            <h4 class="h4">Crypted?</h4>

                            <p>
                                <input id="crypted" name="crypted" type="checkbox" data-size="mini">
                            </p>
                        </div>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>
</div>
<script src="assets/js/jquery-1.8.3.js"/>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-switch.js"></script>
<script src="assets/js/highlight.js"></script>
<script src="assets/js/bootstrap-switch.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>

