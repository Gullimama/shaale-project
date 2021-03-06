var baseUrl = "http://" + "localhost:8080"; 

function getRestCaller(url, type, successCallback) {
	console.log(url); 
	$.ajax({
		url: baseUrl + url, 
		type: "GET", 
		success: function(result) {
			console.log(result); 
			successCallback(result); 
		}, 
		error: function(error) {
			console.log(error); 
		}
	}); 
}

function postRestCaller(url, data, successCallback) {
	console.log(url); 
     $.ajax({
 		url: baseUrl + url, 
 		type: "POST",
 		data: JSON.stringify(data), 
 	    contentType: "application/json;charset=utf-8",
 		success: function(result) {
 			console.log(result); 
 			successCallback(result);
 		}, 
 		error: function(error) {
 			console.log(error); 
 		}
 	});
}

function putRestCaller(url, data, successCallback) {
	console.log(url); 
    $.ajax({
		url: baseUrl + url, 
		type: "PUT",
		data: JSON.stringify(data), 
	    contentType: "application/json;charset=utf-8",
		success: function(result) {
			console.log(result); 
			successCallback(); 
		}, 
		error: function(error) {
			console.log(error); 
		}
	});
}

function getRestCallerWithReqBody(url, type, reqBody, successCallback) {
	console.log(url); 
	$.ajax({
		url: baseUrl + url, 
		type: type, 
	    data: reqBody,
		success: function(result) {
			console.log(result); 
			successCallback(result); 
		}, 
		error: function(error) {
			console.log(error); 
		}
	});
}