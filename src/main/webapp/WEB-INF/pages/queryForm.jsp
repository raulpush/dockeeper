<%@ page language="java" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--Le styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way
                 to the bottom of the topbar */
        }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="assets/css/bootstrap-dialog.min.css" rel="stylesheet">
    <!--Le HTML5 shim,for IE6-8support of HTML5 elements-->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
    </script>
    <![endif]-->
    <!--Le fav and touch icons-->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">


    <form:form commandName="search">
        <form:errors path="*" cssClass="errorblock" element="div"/>

        <label>Search in your's folders</label>

        <div class="input-prepend">
            <span class="input-group-addon" id="basic-addon3">https://example.com/users/</span>
            <input name="content" type="text" class="form-control" id="content" aria-describedby="basic-addon3"/>
            <input type="submit" class="btn" value="Search"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>


    </form:form>

    <div class="control-group">
        <table class="table table-bordered table-hover">
            <c:forEach items="${searchList}" var="paragraph">
                <tr>
                    <td>
                        <a href='#' onClick='queryByIdPrev(${paragraph.getId()});return false;'
                           title="Previous paragraph"> <span class="label label-info">Prev</span></a>
                        <input id="pname-${paragraph.getId()}" type="hidden" value="${paragraph.getId()-1}"/>
                        <a href='#' onClick='queryByIdPost(${paragraph.getId()}); return false;'
                           title="Next paragraph"><span class="label label-info">Next</span></a>
                        <a href='#' onClick='querySendEmail(${paragraph.getId()}); return false;'
                           title="Send Email"><span class="label label-info">Share</span></a></li>
                        <input id="namep-${paragraph.getId()}" type="hidden"
                               value="${paragraph.getId()+1}"/>
                        <br/>
                        <c:choose>
                            <c:when test="${paragraph.title.length() > 15}">
                                <c:out value="${paragraph.title.substring(0, 15)}"/>...<c:out
                                    value="${paragraph.decorator}"/><br/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${paragraph.title}"/> <c:out value="${paragraph.decorator}"/><br/>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${paragraph.score > 1}">
                                <span class="badge badge-success"><c:out value="${paragraph.score}"/></span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge badge-error"><c:out value="${paragraph.score}"/></span>
                            </c:otherwise>
                        </c:choose>
                        <br/>
                        <form:form id="form-${paragraph.getId()}" commandName="filex" action="downloadForm.html">
                            <input name="name" type="hidden" value="${paragraph.title}"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <a href="javascript:{}"
                               onclick='document.getElementById("form-${paragraph.getId()}").submit(); return false;'
                               title="<c:out value="${paragraph.title}"/>">Download</a>
                        </form:form>
                    </td>
                    <td>
                        <div id="name-${paragraph.getId()}"><c:out value="${paragraph.text}"/></div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="assets/js/jquery-1.8.3.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript">
    function queryByIdPrev(index) {
        var nr = parseInt($("#pname-" + index).val());
        $.getJSON("/api/paragraphs/" + nr, {
            ajax: 'true'
        }, function (data) {
            $("#pname-" + index).val(nr - 1);
            var sel = $("#name-" + index);
            sel.text(data.text + "|" + sel.text());
            sel.focus();
        });
    }

    function queryByIdPost(index) {
        var nr = parseInt($("#namep-" + index).val());
        $.getJSON("/api/paragraphs/" + nr, {
            ajax: 'true'
        }, function (data) {
            $("#namep-" + index).val(nr + 1);
            var sel = $("#name-" + index);
            sel.text(sel.text() + "|" + data.text);
            sel.focus();
        });
    }

    function querySendEmail(index) {

//        BootstrapDialog.show({
//            message: 'Send document @: <input type="text" class="form-control"><br><input type="checkbox" name="paragraph"/>Paragraph only.',
//            onhide: function(dialogRef){
//                var email = dialogRef.getModalBody().find('input').val();
//                var nrsup = parseInt($("#pname-" + index).val());
//                var nrinf = parseInt($("#namep-" + index).val());
//                alert(email+"-"+nrinf+"-"+nrsup)
//                return false;
//
//            },
//            buttons: [{
//                label: 'Send Email',
//                action: function(dialogRef) {
//                    dialogRef.close();
//                }
//            }]
//        });
        BootstrapDialog.show({
            message: 'Your most favorite fruit: <input type="text" class="form-control">',
            onhide: function(dialogRef){
                var fruit = dialogRef.getModalBody().find('input').val();
                if($.trim(fruit.toLowerCase()) !== 'banana') {
                    alert('Need banana!');
                    return false;
                }
            },
            buttons: [{
                label: 'Close',
                action: function(dialogRef) {
                    dialogRef.close();
                }
            }]
        });
    }
</script>
</body>
</html>
