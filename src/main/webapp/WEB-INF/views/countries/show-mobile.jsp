<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1" />
		<title>FCO Travel Advice</title>
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
		<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&key=AIzaSyD0kL08UvEOGpfGqfA-LfjKmB8Fxe_v8HM"></script>
		<script type="text/javascript" src="../resources/js/jquery.ui.map.min.js"></script>
		<script type="text/javascript">
		// Following only called on refresh - otherwise parent page js is executed. 
		 $(function() {
			 
			 $( ".map_canvas" ).each(function(i){
				 var coords = $(this).attr('data-lat') + ", " + $(this).attr('data-lng'); 
				 var address= $(this).attr('data-addr');
				 var marker = { 'center': coords, 'zoom': 15 };	 
				 $('#map_canvas' + (i+1)).gmap({'center': marker.center, 'zoom': marker.zoom, 'disableDefaultUI':false, 'callback': function() {
						var self = this;
						self.addMarker({'position': this.get('map').getCenter() }).click(function() {
							self.openInfoWindow({ 'content': address }, this);
					});
				}}); 
			});
			 			
            $(".mapRefresh").click(function() {
            	
            	 $('.map_canvas').gmap('refresh');
            	 
            });
     	});
		</script>
		
	</head>

	<body>
	<div data-role="page" id="show">
		<div data-role="header" data-position="fixed">
	        <h3>
	            FCO Travel Advice
	        </h3>
	        <a data-role="button" data-direction="reverse" data-rel="back" href="#list" data-icon="arrow-l" data-iconpos="left">
	            Back
	        </a>
	    </div>
		<div data-role="content">
			<h1><c:out value="${country.name}"/></h1>
			<img src="${country.flagUrl}" alt="${country.name}"/>
			<p>Embassies:</p>			
			<div data-role="collapsible-set">	
		
			<c:forEach items="${country.embassies}" var="embassy" varStatus="status">	
															
			<div data-role="collapsible" data-theme="a" class="mapRefresh">
		
				<h1>${embassy.designation} ${embassy.locationName}</h1>
				
				
		    		
				<ul data-role="listview">
					<li>
						<h3>Location</h3>
						<div class="ui-bar-c ui-corner-all ui-shadow" style='padding:1em;'>
							<div class="map_canvas" id="map_canvas${status.count}" style="height:350px;" data-lng="${embassy.lng}" data-lat="${embassy.lat}" data-addr="${embassy.address.plain}" >
								
							</div>	
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
			</div>			
		</div>
		<div data-role="footer" id="footer" data-position="fixed">
		<jsp:include page="/WEB-INF/includes/site-switcher.jsp" />
		</div>
	</div>
	<c:forEach items="${country.embassies}" var="embassy">
	<div data-role="page" id="embassy-${embassy.fcoId}">
		<div data-role="header">
	        <h3>
	            FCO Travel Advice
	        </h3>
	        <a data-role="button" data-direction="reverse" data-rel="back" href="#list" data-icon="arrow-l" data-iconpos="left">
	            Back
	        </a>
	    </div>
	    <div data-role="content">
	    	
			
				
		</div>
		<div data-role="footer" id="footer">
		<jsp:include page="/WEB-INF/includes/site-switcher.jsp" />
		</div>
	</div>
</c:forEach>
			
	</body>
</html>