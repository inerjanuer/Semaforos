<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
  integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
  crossorigin=""/>
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
  integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
  crossorigin=""></script>
<title>Insert title here</title>
<%@ include file="../util/scripts.jsp"%>
</head>
<body>
<%@ include file="../util/navbar.jsp"%>

<style>
#mapid { height: 1080px; }
</style>
	<div id="mapid"></div>
	<script type="text/javascript">

	$.get( "http://localhost:8080/traffic/all", function( data ) {
		  createMap(data);
		});

	function createMap(data){

		var trafficLight = L.layerGroup();
		console.log(data);

		var LeafIcon = L.Icon.extend({
			options: {
				shadowUrl: 'https://image.winudf.com/v2/image/YnIuY29tLmFwcC5ncHUxODI2NTE2LmdwdTFmZGE4NTFiYzUzNDMzNDdhMmI1ODcyMjYyNDYxYjViX2ljb25fMTUzODgwMzYxN18wODU/icon.png?w=170&fakeurl=1',
				iconSize:     [30, 30],
				shadowSize:   [0, 0],
				iconAnchor:   [22, 94],
				shadowAnchor: [4, 62],
				popupAnchor:  [-3, -76]
			}
		});

		var greenIcon = new LeafIcon({iconUrl: 'https://image.winudf.com/v2/image/YnIuY29tLmFwcC5ncHUxODI2NTE2LmdwdTFmZGE4NTFiYzUzNDMzNDdhMmI1ODcyMjYyNDYxYjViX2ljb25fMTUzODgwMzYxN18wODU/icon.png?w=170&fakeurl=1'});
		
		for(var k=0; k<data.length; k++){
			var lat = data[k].latitud;
			var log = data[k].longitud;
 			var button = "<b>Semaforo</b><br/>"+
 						"Tiempo de semaforo " + data[k].time+" segundos<br/>"+
 						"<button class='btn btn-success btn-sm btn-block'" +
 						"onclick="+"window.location.href='/traffic/edit/"+data[k].id+"'"+">Editar</button>";
			L.marker([lat,log], {icon: greenIcon}).bindPopup(button).addTo(trafficLight)
		}
		
		var mbAttr = 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
			mbUrl = 'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw';



		var grayscale   = L.tileLayer(mbUrl, {id: 'mapbox.streets', attribution: mbAttr}),
		streets  = L.tileLayer(mbUrl, {id: 'mapbox.streets',   attribution: mbAttr});

		var map = L.map('mapid', {
		    center: [4.6097102, -74.081749],
		    zoom: 13,
		    layers: [grayscale, trafficLight]
		});


	}


	</script>
</body>
</html>