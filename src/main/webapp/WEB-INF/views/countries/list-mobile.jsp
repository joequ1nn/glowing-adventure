<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1" />
	<title>FCO Travel Advice</title>
	<link rel="stylesheet" href="resources/js/jquery.mobile-1.1.0.css" />
	
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="resources/js/jquery.mobile-1.1.0.js"></script>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&key=AIzaSyD0kL08UvEOGpfGqfA-LfjKmB8Fxe_v8HM"></script>
	<script type="text/javascript" src="resources/js/jquery.ui.map.min.js"></script>
	<script type="text/javascript">
		$(document).bind("mobileinit", function(){
        	$.mobile.defaultPageTransition = 'none';
		});

		$( '#show' ).live( 'pageshow',function(event){ 
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
           		$(this).find('.map_canvas').gmap('refresh');           	 
           });
		});
		 
// 		$('div[data-role="page"]').live( 'pageinit',function(event){ 
// 			alert( 'data-role!' );
// 		});
		</script>
</head>
<body>
	<div data-role="page" id="list">
		<div data-role="header" data-position="fixed">
	        <h3>
	            FCO Travel Advice
	        </h3>
	    </div>
		<div data-role="content">
			<ul id="largeListView" data-role="listview" data-theme="c"  data-ajax="false" data-filter="true" data-filter-placeholder="Search Countries...">
			<c:forEach items="${countries}" var="country">
			<li><a href="countries/${country.slug}.htm">
				<h3>${country.name}</h3>
			</a></li>					
			</c:forEach>	
			</ul>		
		</div>
		<div data-role="footer" id="footer" data-position="fixed">
			<h1>Mobile</h1>
			<jsp:include page="/WEB-INF/includes/site-switcher.jsp" />
		</div>
	</div>	
</body>
</html>