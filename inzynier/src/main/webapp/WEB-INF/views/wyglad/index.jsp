<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div class="main">
        <h1> Reisende - Wyglad Postaci </h1>
        <a href="/wyglad"><input type="submit" value="Wyglad Postaci"/></a>
        <a href="/zbroja"><input type="submit" value="Zbroja i Ekwipunek"/></a>
        <h3>Tu mozesz wybrac wyglad swojej postaci. Wybierz ilustacje przesuwajac strzalkami i kliknij zapisz. To wystarczy by Twoja postac wygladala w dany sposob</h3>
        <br/><br/>
        <s:form action="/wyglad/save/${current}" method="post" modelAttribute="lista" enctype="multipart/form-data">
            <c:url value="/wyglad" var="prev">
            <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <h3><a href='<c:out value="${prev}" />' class="pn prev"><<</a></h3>
            </c:if>
            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                <c:choose>
                    <c:when test="${page == i.index}">
                        <img style ="background-color: transparent;" src="/resources/${current}"/>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:url value="/wyglad" var="next">
            <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <h3><a href='<c:out value="${next}" />' class="pn next">>></a></h3>
            </c:if>
            <input type="submit" value="Zapisz"/>
        </s:form>
    </div>
</body>
