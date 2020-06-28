var announcementHeaders = ["Date", "Topic", "Message", "Author Name", "View Details"]; 
var headerIds = []

var principalTeacherAnnouncementsUrl = "/announcements/principal/teacher"; 
var principalSchoolAnnouncementsUrl = "/announcements/principal/school"; 
var classAnnouncementsUrl = "/announcements/classes"; 

function getClassAnnouncementsForRole() {
	if(globalUserRole === "ClassTeacher") {
	} else if (globalUserRole === "SubjectTeacher"){ 
	} else if(globalUserRole === "Principal") {
		tabularFormClassInput = parseInt(document.getElementById("tabularClassDropdown").value); 
		tabularFormSectionInput = document.getElementById("tabularSectionDropdown").value; 
		globalClassId = globalClassesObjects.find(classes => classes.classesNo === tabularFormClassInput && classes.sectionName === tabularFormSectionInput).id;
	} else if(globalUserRole === "Admin") {
		
	}
	getClassAnnouncements(); 
}

// For Teacher Announcements
function getPrincipalAnnouncements() {
	hideAndShowRelevantAnnouncementComponentsForPrincipal(); 
	var requestData = {
	}
	postRestCaller(principalTeacherAnnouncementsUrl, requestData, populateAnnouncements); 
}

function getSchoolAnnouncements() {
	hideAndShowRelevantAnnouncementComponentsForSchool(); 
	var requestData = {
	}
	postRestCaller(principalSchoolAnnouncementsUrl, requestData, populateAnnouncements); 
}

function getClassAnnouncements() {
	hideAndShowRelevantAnnouncementComponentsForClass(); 
	var requestData = {
			userId: globalUserId, 
			classesId: globalClassId
	}
	postRestCaller(classAnnouncementsUrl, requestData, populateAnnouncements); 
}

function populateAnnouncements(data) {
	globalOnPageOption = "Announcement"; 
//	
	populateHeaderJumbotronForAnnouncement();  
	
	populateAnnouncementHeaders(); 
	populateAnnouncementBody(data);
	dataTableReload(); 
}

function hideAndShowRelevantAnnouncementComponentsForSchool() {
	dataTableClear(); 
	displayAnnouncementComponentsForSchool(); 
}

function hideAndShowRelevantAnnouncementComponentsForPrincipal() {
	dataTableClear(); 
	displayAnnouncementComponentsForPrincipal(); 
}

function hideAndShowRelevantAnnouncementComponentsForClass() {
//	hideMainSection(); 
	dataTableClear(); 
	displayAnnouncementComponentsForClass(); 
}

function populateHeaderJumbotronForAnnouncement() {
	document.getElementById("dataTableHeader").innerHTML = ""; 
	document.getElementById("dataTableBody").innerHTML = "";
	document.getElementById("pageHeaderIcon").setAttribute("data-feather", "package"); 
	feather.replace(); 
	document.getElementById("pageHeaderTitle").innerHTML = "Announcement"; 
	
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

function populateAnnouncementHeaders() {
	var tableHeaderElement = document.getElementById("dataTableHeader"); 
	// clear previously loaded header content
	tableHeaderElement.innerHTML = ""; 
	
	var tableHeaderRow = document.createElement("tr");
	
	announcementHeaders.forEach((header, index) => {
		var tableHeader = document.createElement("th");
		tableHeader.innerHTML = header;  
		tableHeaderRow.appendChild(tableHeader); 
	}); 
	
	tableHeaderElement.appendChild(tableHeaderRow); 
}

function populateAnnouncementBody(data) {
	//["Date", "Topic", "Message", "Author Name", "View Details"]; 
	var detailElement = document.getElementById("dataTableBody");
	
	// clear previously loaded header content
	detailElement.innerHTML = ""; 
	
	data.announcementList.forEach((announcement, index) => {
		var ttRow = document.createElement("tr"); 
		
		var ttRowData = document.createElement("td"); 
//		ttRowData.innerHTML = leavesData.users.find(x => x.id===pendingLeave.referenceId).fullName; 
		ttRowData.innerHTML = announcement.dated;
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = announcement.topic;  
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = announcement.datum;   
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = data.authorList.find(x => x.id === announcement.authorId).fullName;                        // TODO date subtraction logic. 
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		
		var a = document.createElement('a');  
		var link = document.createTextNode("View Details");
		a.appendChild(link);
		a.title = "View Details";
		a.href = "#"; 
		
		ttRowData.appendChild(a); 
		
		ttRow.appendChild(ttRowData);
			
		detailElement.appendChild(ttRow); 
	}); 
}

//function newLeaveRequest() {
//	populateNewLeaveRequestWindow(); 
//}

//function populateNewLeaveRequestWindow() {
//	hideMainTables(); 
//	
//	document.getElementById("classSectionRow").style.display = null; 
//	document.getElementById("newRequestWindow").style.display = null; 
//	
//	var formElement = document.getElementById("newRequestForm"); 
//	formElement.setAttribute("value", "LEAVE"); 
//}

//function submitNewRequestForm() {
//	var formElement = document.getElementById("newRequestForm"); 
//	var formType = formElement.getAttribute("value"); 
//	
//	if(formType === "LEAVE") {
//			var userId = getUserId(); 
//			var startDate = formElement.elements[0].value; 
//			var endDate = formElement.elements[2].value; 
//			var reason = formElement.elements[4].value;
//			
//			var reqBody = {'startDate' : startDate, 'endDate' : endDate, 'reason' : reason, 'userId' : userId };
//			url = "/leave-apply"; 
//			
//			getRestCallerWithReqBody(url, "GET", reqBody, getUserLeaves); 
//	}
//}

function populateAnnoucementClassDropdown() {
	console.log("populating annoucement class dropdown ::" + arguments.callee.name); 
}

function populateAnnoucementSectionDropdown() {
	console.log("populating annoucement section dropdown ::" + arguments.callee.name); 
}

function newAnnouncementForm() {
	 hideMainSection(); 
	 populateHeaderJumbotronForAnnouncement(); 
	 displayAnnouncementForm(); 
}

function submitAnnoucementRequest() {
	console.log("submitting new annoucement request ::" + arguments.callee.name); 
	// rest call for inserting new announcement... role-wise
	var announcementReqBody = {}; 
	switch (globalUserRole) {
	case "Principal": 
		var announcementType = document.getElementById("announcementTypeDropdown").value === "Teachers Announcement" ? 1 : 2; 
		announcementReqBody = {
			dated : new Date(), 
			classesId : announcementType, 
			topic : document.getElementById("announcementTopicInput").value, 
			datum : document.getElementById("announcementMessageInput").value, 
			authorId : globalUserId
		}; 
		break; 
	case "ClassTeacher": 
		announcementReqBody = {
			dated : new Date(), 
			classesId : globalClassId, 
			topic : document.getElementById("announcementTopicInput").value, 
			datum : document.getElementById("announcementMessageInput").value, 
			authorId : globalUserId
		}; 
		break; 
	case "SubjectTeacher": 
		tabularFormClassInput = parseInt(document.getElementById("announcementClassDropdown").value); 
		tabularFormSectionInput = document.getElementById("announcementSectionDropdown").value; 
		globalClassId = globalClassesObjects.find(classes => classes.classesNo === tabularFormClassInput && classes.sectionName === tabularFormSectionInput).id;
		
		announcementReqBody = {
			dated : new Date(), 
			classesId : globalClassId, 
			topic : document.getElementById("announcementTopicInput").value, 
			datum : document.getElementById("announcementMessageInput").value, 
			authorId : globalUserId
		}; 
		break; 
	case "Student": 
		break; 
	case "Parent":
		break; 
	case "Admin": 
		break; 
	}
	var flag = putRestCaller("/announcements", announcementReqBody, getClassAnnouncementsForRole); 
	console.log("flag: " + flag);
}