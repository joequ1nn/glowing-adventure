<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>${country.name}</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
		<script type="text/javascript" src="../resources/js/jquery.ui.map.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			// If you dont add a constructor ($('#map_canvas').gmap({'some_option':'some_value'});) the plugin will auto initialize 
			$('#map_canvas').gmap('addMarker', {'position': '57.7973333,12.0502107', 'bounds': true}).click(function() {
				$('#map_canvas').gmap('openInfoWindow', {'content': 'Hello World!'}, this);
			});
		});
		
		</script>
	</head>
	<body>
	<h1>Full</h1>
	<jsp:include page="/WEB-INF/includes/site-switcher.jsp"/>
	<c:forEach items="${country.embassies}" var="embassy">												
			<div data-role="collapsible" data-theme="a">
				<h1>${embassy.designation} ${embassy.locationName}</h1>
			<ul data-role="listview">
					<li>
						<h3>Location</h3>
						<div class="ui-bar-c ui-corner-all ui-shadow" style='padding:1em;'>
							<div id="map_canvas" style="height:350px;"></div>
						</div>					
					</li>
					<li>
						<h3>Website</h3>
						<p><a href="${embassy.originalUrl}">${embassy.originalUrl}</a></p>					
					</li>
					<li>
						<h3>Secondary Website</h3>
						<p><a href="${embassy.url}">${embassy.url}</a></p>
					</li>
					<li>
						<h3>Phone</h3>
						<p>${embassy.phone}</p>
					</li>
					<li>
						<h3>Email</h3>
						<p>${embassy.email}</p>
					</li>
					<li>
						<h3>Address</h3>
						<p>${embassy.address.markup}</p>
					</li>
					<li>
						<h3>Opening Hours</h3>
						<p>${embassy.officeHours.markup}</p>
					</li>
				</ul>				
			</div>
			</c:forEach>
	
	</body>
	
</html>