<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>List of Countries</title>
	</head>
	<body>
		<h1>Full</h1>
		<jsp:include page="/WEB-INF/includes/site-switcher.jsp"/>
		<ol>
			<c:forEach items="${countries}" var="country">
			<li><a href="countries/${country.slug}.htm"><c:out value="${country.slug}"></c:out></a></li>
			</c:forEach> 
		</ol>
	</body>
</html>