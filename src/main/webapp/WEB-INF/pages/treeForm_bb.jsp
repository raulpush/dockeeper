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
        .tree {
            min-height:20px;
            padding:19px;
            margin-bottom:20px;
            background-color:#fbfbfb;
            border:1px solid #999;
            -webkit-border-radius:4px;
            -moz-border-radius:4px;
            border-radius:4px;
            -webkit-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
            -moz-box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05);
            box-shadow:inset 0 1px 1px rgba(0, 0, 0, 0.05)
        }
        .tree li {
            list-style-type:none;
            margin:0;
            padding:10px 5px 0 5px;
            position:relative
        }
        .tree li::before, .tree li::after {
            content:'';
            left:-20px;
            position:absolute;
            right:auto
        }
        .tree li::before {
            border-left:1px solid #999;
            bottom:50px;
            height:100%;
            top:0;
            width:1px
        }
        .tree li::after {
            border-top:1px solid #999;
            height:20px;
            top:25px;
            width:25px
        }
        .tree li span {
            -moz-border-radius:5px;
            -webkit-border-radius:5px;
            border:1px solid #999;
            border-radius:5px;
            display:inline-block;
            padding:3px 8px;
            text-decoration:none
        }
        .tree li.parent_li>span {
            cursor:pointer
        }
        .tree>ul>li::before, .tree>ul>li::after {
            border:0
        }
        .tree li:last-child::before {
            height:30px
        }
        .tree li.parent_li>span:hover, .tree li.parent_li>span:hover+ul li span {
            background:#eee;
            border:1px solid #94a0b4;
            color:#000
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="tree well">
        <ul>
            <li>
                <span><i class="icon-folder-open"></i> Parent</span> <a href="">Goes somewhere</a>
                <ul>
                    <li>
                        <span><i class="icon-minus-sign"></i> Child</span> <a href="">Goes somewhere</a>
                        <ul>
                            <li>
                                <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span><i class="icon-minus-sign"></i> Child</span> <a href="">Goes somewhere</a>
                        <ul>
                            <li>
                                <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                            </li>
                            <li>
                                <span><i class="icon-minus-sign"></i> Grand Child</span> <a href="">Goes somewhere</a>
                                <ul>
                                    <li>
                                        <span><i class="icon-minus-sign"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                        <ul>
                                            <li>
                                                <span><i class="icon-leaf"></i> Great great Grand Child</span> <a href="">Goes somewhere</a>
                                            </li>
                                            <li>
                                                <span><i class="icon-leaf"></i> Great great Grand Child</span> <a href="">Goes somewhere</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span><i class="icon-leaf"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                    </li>
                                    <li>
                                        <span><i class="icon-leaf"></i> Great Grand Child</span> <a href="">Goes somewhere</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span><i class="icon-leaf"></i> Grand Child</span> <a href="">Goes somewhere</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <span><i class="icon-folder-open"></i> Parent2</span> <a href="">Goes somewhere</a>
                <ul>
                    <li>
                        <span><i class="icon-leaf"></i> Child</span> <a href="">Goes somewhere</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <div class="tree">
        <ul>
            <li>
                <span><i class="icon-calendar"></i> 2013, Week 2</span>
                <ul>
                    <li>
                        <span class="badge badge-success"><i class="icon-minus-sign"></i> Monday, January 7: 8.00 hours</span>
                        <ul>
                            <li>
                                <a href=""><span><i class="icon-time"></i> 8.00</span> &ndash; Changed CSS to accomodate...</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span class="badge badge-success"><i class="icon-minus-sign"></i> Tuesday, January 8: 8.00 hours</span>
                        <ul>
                            <li>
                                <span><i class="icon-time"></i> 6.00</span> &ndash; <a href="">Altered code...</a>
                            </li>
                            <li>
                                <span><i class="icon-time"></i> 2.00</span> &ndash; <a href="">Simplified our approach to...</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span class="badge badge-warning"><i class="icon-minus-sign"></i> Wednesday, January 9: 6.00 hours</span>
                        <ul>
                            <li>
                                <a href=""><span><i class="icon-time"></i> 3.00</span> &ndash; Fixed bug caused by...</a>
                            </li>
                            <li>
                                <a href=""><span><i class="icon-time"></i> 3.00</span> &ndash; Comitting latest code to Git...</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span class="badge badge-important"><i class="icon-minus-sign"></i> Wednesday, January 9: 4.00 hours</span>
                        <ul>
                            <li>
                                <a href=""><span><i class="icon-time"></i> 2.00</span> &ndash; Create component that...</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li>
                <span><i class="icon-calendar"></i> 2013, Week 3</span>
                <ul>
                    <li>
                        <span class="badge badge-success"><i class="icon-minus-sign"></i> Monday, January 14: 8.00 hours</span>
                        <ul>
                            <li>
                                <span><i class="icon-time"></i> 7.75</span> &ndash; <a href="">Writing documentation...</a>
                            </li>
                            <li>
                                <span><i class="icon-time"></i> 0.25</span> &ndash; <a href="">Reverting code back to...</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>


</div>

<script src="assets/js/jquery-1.8.3.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
        $('.tree li.parent_li > span').on('click', function (e) {
            var children = $(this).parent('li.parent_li').find(' > ul > li');
            if (children.is(":visible")) {
                children.hide('fast');
                $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
            } else {
                children.show('fast');
                $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
            }
            e.stopPropagation();
        });
    });
</script>
</body>
</html>
