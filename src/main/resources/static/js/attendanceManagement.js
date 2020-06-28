var attendanceHeaders = ["Name", "ID", "PERIODS", "Total"]; 
var classAttendanceUrl = "/attendance/class/"; 
var headerIds = []; 
var attendanceRequestDate = new Date();

function getAttendanceForRole() {
	// depending upon role, call the correct function.
	if(globalUserRole === "ClassTeacher") {
		getClassAttendance(); 
	} else if (globalUserRole === "SubjectTeacher"){ 
	} else if(globalUserRole === "Principal") {
		tabularFormClassInput = parseInt(document.getElementById("tabularClassDropdown").value); 
		tabularFormSectionInput = document.getElementById("tabularSectionDropdown").value; 
		globalClassId = globalClassesObjects.find(classes => classes.classesNo === tabularFormClassInput && classes.sectionName === tabularFormSectionInput).id;
		getClassAttendance(); 
	} else if(globalUserRole === "Admin") {
		
	}
}

function getNextAttendance() {
//	dataTableClear();
	attendanceRequestDate = attendanceRequestDate.addDays(1); 
	getClassAttendance(); 
}

function getPreviousAttendance() {
//	dataTableClear();
	attendanceRequestDate = attendanceRequestDate.addDays(-1);
	getClassAttendance(); 
}

function getClassAttendance() {
	var requestBody = {
		userId: globalUserId, 
		classesId: globalClassId, 
		startDate: attendanceRequestDate
	}
//	dataTableClear();
	postRestCaller(classAttendanceUrl, requestBody, populateClassAttendance); 
}

function getAttendance(dateInput) {
	attendanceRequestDate = dateInput.valueAsDate;
	console.log("attendanceDate: " + attendanceRequestDate); 
//	dataTableClear(); 
	getClassAttendance(); 
}

function populateClassAttendance(attendanceData) {
	globalOnPageOption = "Attendance"; 
	dataTableClear();
	populateHeaderJumbotronForAttendance();  
	hideAndShowRelevantAttendanceComponents(); 
	populateAttendanceDetails(attendanceData); 
	dataTableReload(); 
}

function populateHeaderJumbotronForAttendance() {
	document.getElementById("dataTableHeader").innerHTML = ""; 
	document.getElementById("dataTableBody").innerHTML = "";
	document.getElementById("pageHeaderIcon").setAttribute("data-feather", "users"); 
	feather.replace(); 
	document.getElementById("pageHeaderTitle").innerHTML = "Attendance"; 
	
	if (globalUserRole === "Student") {
		return; 
	}
	else if (globalUserRole === "ClassTeacher") {
		document.getElementById("pageHeaderBody").innerHTML = "CLASS: <b> " + globalClassNo + " || </b> SECTION: <b>'" + globalSectionName + "'</b>"; 
	}
	else if (globalUserRole === "Principal"){
		document.getElementById("pageHeaderBody").innerHTML = globalUserName; 
	}
}

function hideAndShowRelevantAttendanceComponents() {
//	hideMainComponents(); 
//	hideMainSection(); 
	displayAttendanceComponents(); 
//	document.getElementById("datatableHolder").style.display = "block"; 
//	document.getElementById("tabularForm").style.display = "block";
}

function populateAttendanceDetails(attendanceData) {
	populateAttendanceHeaders(attendanceData); 
	populateAttendanceBody(attendanceData);
}

function populateAttendanceHeaders(data) {
	document.getElementById("attendanceDate").valueAsDate = attendanceRequestDate; 
	
	var tableHeaderElement = document.getElementById("dataTableHeader"); 
	// clear previously loaded header content
	tableHeaderElement.innerHTML = ""; 
	
	var tableHeaderRow = document.createElement("tr");
	
	attendanceHeaders.forEach((header, index) => {
		if (header === "PERIODS") {
			data.periodsList.forEach((period, index) => {
				var tableHeader = document.createElement("th");
				tableHeader.innerHTML = period.startTime.substring(0, 5) + " - " + period.endTime.substring(0, 5) + " (mins)"; 
				tableHeaderRow.appendChild(tableHeader); 
			}); 
		}
		else {
			var tableHeader = document.createElement("th");
			tableHeader.innerHTML = header;  
			tableHeaderRow.appendChild(tableHeader); 
		}
	}); 
	
	tableHeaderElement.appendChild(tableHeaderRow); 
}

function populateAttendanceBody(data) {
	//["Name", "ID", "PERIODS", "Total"];
	var detailElement = document.getElementById("dataTableBody");
	
	// clear previously loaded header content
	detailElement.innerHTML = ""; 
	
	data.usersList.forEach((user, index) => {
		var ttRow = document.createElement("tr"); 
		var totalCount = 0; 
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = user.fullName;
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = user.id;
		ttRow.appendChild(ttRowData);
		
		data.periodsList.forEach((period, index) => {
				var ttRowData = document.createElement("td"); 
				var present = data.attendance.find(x => 
					(x.periodId === period.id && user.id === x.userId) ); 
				present = (present === undefined) ? "0" : present.duration;
				ttRowData.innerHTML = present; 
				if (present > 0) {
					totalCount ++; 
				}
				ttRow.appendChild(ttRowData);
			}
		); 
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = totalCount;   
		ttRow.appendChild(ttRowData);
			
		detailElement.appendChild(ttRow); 
	}); 
}
