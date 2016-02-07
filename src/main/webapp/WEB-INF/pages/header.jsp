<c:url value="/j_spring_security_logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="fileUploadForm.htm">
                Add document
            </a>
            <a class="brand" href="queryForm.htm">
                Query documents
            </a>
            <a class="brand" href="treeForm.htm">
                Tree
            </a>
            <a class="brand" href="register.htm">
                Users
            </a>
            <a class="brand" href="sendEmail.htm">
            Send Email
            </a>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="brandr">
                    Welcome : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()"> Logout</a>
                </div>


            </c:if>
            <ul class="nav">
            </ul>
        </div>
    </div>
</div>