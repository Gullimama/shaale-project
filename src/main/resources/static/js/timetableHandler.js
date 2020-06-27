var classTimetableUrl = "/timetable/class/"; 
var userTimetableUrl = "/timetable/user/"

function getTimetable() {
	// depending upon role, call the correct function.
	if(globalUserRole === "ClassTeacher" || globalUserRole === "Student" || globalUserRole === "Parent") {
		getClassTimetable(); 
	} else if (globalUserRole === "SubjectTeacher"){ // for Principal and SubjectTeacher by default.
		getUserTimetable(); 
	} else if(globalUserRole === "Principal") {
		// capture TabularForm values into globals; 
//		displayTimetableComponents(); 
		tabularFormClassInput = parseInt(document.getElementById("tabularClassDropdown").value); 
		tabularFormSectionInput = document.getElementById("tabularSectionDropdown").value; 
		globalClassId = globalClassesObjects.find(classes => classes.classesNo === tabularFormClassInput && classes.sectionName === tabularFormSectionInput).id;
		getClassTimetable(); 
	} else if(globalUserRole === "Admin") {
		
	}
}

function getUserTimetable() {
	var type = "GET"; 
	var url = userTimetableUrl + globalUserId; 
	getRestCaller(url, type, populateTimetable); 
}

function getClassTimetable() {
	var type = "GET"; 
	var url = classTimetableUrl + globalClassId; 
	getRestCaller(url, type, populateTimetable); 
}

function populateTimetable(timetableData) {
	globalOnPageOption = "Timetable";
	dataTableClear(); 
	populateHeaderJumbotronForTimetable(); 
	hideAndShowRelevantTimetableComponents(); 
	populateTimetableDetails(timetableData); 
}

function populateHeaderJumbotronForTimetable() {
	document.getElementById("dataTableHeader").innerHTML = ""; 
	document.getElementById("dataTableBody").innerHTML = ""; 
	document.getElementById("pageHeaderTitle").innerHTML = "Timetable";
	
	if (globalUserRole === "ClassTeacher" || globalUserRole === "Student") {
		document.getElementById("pageHeaderBody").innerHTML = "CLASS: <b>" + globalClassNo + " || </b> SECTION: <b>'" + globalSectionName + "'</b>"; 
	}
	else {
		document.getElementById("pageHeaderBody").innerHTML = globalUserName; 
	}
}

function hideAndShowRelevantTimetableComponents() {
	hideMainSection(); 
	displayTimetableComponents(); 
}

function populateTimetableDetails(timetableData) {
	populateTimeTableHeader(timetableData);
	populateDayPeriods(timetableData); 
}

function populateDayPeriods(timetableData) {
	var timeTableDetailElement = document.getElementById("dataTableBody"); 
	
	// clear previously loaded details content
	timeTableDetailElement.innerHTML = ""; 
	
	timetableData.daysofweek.forEach((dayofweek, dayofweekIndex) => {
		var ttRow = document.createElement("tr"); 
		
		var ttRowData = document.createElement("td");
		
		var badgeDiv = document.createElement("div"); 
		badgeDiv.classList.add("d-flex", "justify-content-center", "badge", "badge-warning", "badge-pill"); 
		badgeDiv.innerHTML = dayofweek.day;
		ttRowData.appendChild(badgeDiv); 
		
		ttRow.appendChild(ttRowData); 
		
		timetableData.periods.forEach((period, periodIndex) => {
			var timeTableRowData = timetableData.timetables
											.filter( x => 
												(x.periodId===period.id && 
												x.dayId===dayofweek.id))[0]; 
			if(timeTableRowData == undefined) {
				var subject = "Leisure"; 
				var teacherName = ""; 
			} else {
				var subject = timetableData.subjects
											.find(x => x.id===timeTableRowData.subjectId);
				subject = subject.subjectName; 
				
				if (globalUserRole === "ClassTeacher" || globalUserRole === "Student" || globalUserRole === "Principal" || globalUserRole === "Parent") {
					var teacherName = timetableData.teachers
												.find(teacher => teacher.id === timetableData.teachings
														.find(teaching => teaching.id===timeTableRowData.teachingId).teacherId);
					teacherName = teacherName.fullName; 
				} else {
					var teacherName = timetableData.classes
												.find(classes => classes.id === timeTableRowData.classesId); 
					teacherName = teacherName.classesNo + " - " + teacherName.sectionName; 
					
				}
			}
			
			var ttRowData = document.createElement("td"); 
			// TODO add subjectId here.
			ttRowData.setAttribute("onclick", "hideNonClassOptions(); ")

			var a = document.createElement('a');
			a.setAttribute('href', '#');
			a.innerHTML = "<b>" + subject + "</b> " + "<br /> (" + teacherName + ")";
			
			ttRowData.appendChild(a); 
			ttRow.appendChild(ttRowData);
		});
		
		timeTableDetailElement.appendChild(ttRow);
	}); 
}

function populateTimeTableHeader(timetableData) {
	var tableHeaderElement = document.getElementById("dataTableHeader"); 
	tableHeaderElement.innerHTML = ""; 
	
	var tableHeaderRow = document.createElement("tr");
	
	var tableHeader = document.createElement("th");
	tableHeader.innerHTML = "Day\\Time"; 
	
	tableHeaderRow.appendChild(tableHeader); 
	timetableData.periods.forEach((period, index) => {
		tableHeader = document.createElement("th");
		tableHeader.innerHTML = period.startTime.substring(0, 5) + " - " + period.endTime.substring(0, 5); 
		tableHeaderRow.appendChild(tableHeader); 
	}); 
	
	tableHeaderElement.appendChild(tableHeaderRow); 
}