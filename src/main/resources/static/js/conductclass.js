function hideNonClassOptions() {
	// TODO - handle for student, teachers and principal.
	
	hideMainComponents(); 
	
	document.getElementById("timetableOption").style.display = "none"; 
	document.getElementById("interfaceOptionHeader").style.display = "none"; 
	document.getElementById("attendanceOption").style.display = "none"; 
	document.getElementById("annoucementOption").style.display = "none"; 
	document.getElementById("leaveManagementOption").style.display = "none"; 
	document.getElementById("ptmOption").style.display = "none"; 
	
	document.getElementById("attendeesOption").style.display = "block";
	document.getElementById("sessionOption").style.display = "block";
	document.getElementById("archivedClasses").style.display = "block";
	
	// set headings for class: 
	document.getElementById("pageHeaderTitle").innerHTML = "Physics - Prof. Walter Lewin"; 
	document.getElementById("pageHeaderBody").innerHTML = "Class 6 || Section 'C' || Archived (05/06/2020)";
	document.getElementById("classBroadcast").style.display = "block"; 
}

function showNonClassOptions() {
	// TODO - handle for student, teachers and principal.
	
	hideMainComponents(); 
	
	document.getElementById("timetableOption").style.display = "block"; 
	document.getElementById("interfaceOptionHeader").style.display = "block"; 
	document.getElementById("attendanceOption").style.display = "block"; 
	document.getElementById("annoucementOption").style.display = "block"; 
	document.getElementById("leaveManagementOption").style.display = "block"; 
	document.getElementById("ptmOption").style.display = "block"; 
	
	document.getElementById("attendeesOption").style.display = "none";
	document.getElementById("sessionOption").style.display = "none";
	document.getElementById("archivedClasses").style.display = "none";
}