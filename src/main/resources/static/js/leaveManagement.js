var leaveHeaders = ["Student Name", "Student ID", "Leave Period", "Total Days", "Reason", "Status", "View Details"]; 
var headerIds = []

var classLeavesUrl = "/leaves/class/"; 
var userLeavesUrl = "/leaves/user/"; 

function getPendingLeavesTable() {
	getClassLeaves("PENDING"); 
}

function getAllLeavesTable() {
	getClassLeaves("ALL")
}

function getMyLeavesTable() {
	getClassLeaves("MY"); 
}

function getClassLeaves(pending) {
	//hideMainTables(); 
	document.getElementById("dataTableHeader").innerHTML = ""; 
	document.getElementById("dataTableBody").innerHTML = ""; 
	document.getElementById("pageHeaderTitle").innerHTML = "Leave Management"; 
	
	// show & set PageHeading to TimeTable
	hideMainComponents(); 
	document.getElementById("datatableHolder").style.display= "block";  
	
	if (pending === 'PENDING') {
//		var url = "/leaves/class/1"; 
		var url = classLeavesUrl + globalClassId; 
		var type = "GET"; 
		getRestCaller(url, type, populatePendingLeaves); 
	} else if (pending === 'ALL') {
		var url = classLeavesUrl + globalClassId; 
		var type = "GET"; 
		getRestCaller(url, type, populateAllStudentLeaves); 
	} else if (pending === 'MY') {
		var url = userLeavesUrl + globalClassTeacherId; 
		var type = "GET"; 
		getRestCaller(url, type, populateAllStudentLeaves);
	}
}

function getUserLeaves() {
	var url = "/leaves/user/7"; 
	var type = "GET"; 
	var leavesData = getRestCaller(url, type); 
	
	getRestCaller(url, type, populateAllStudentLeaves); 
}

function populatePendingLeaves(leavesData) {
	populateLeaveManagementTable(leavesData, "PENDING"); 
}

function populateAllStudentLeaves(leavesData) {
	populateLeaveManagementTable(leavesData, "ALL"); 
}

function populateLeaveManagementTable(leavesData, pending) {
	// show & set PageHeading to TimeTable
	document.getElementById("tableHolder").style.display= "block";  
	
	// populate table headers
	populateLeavemanagementHeader(); 
	
	// populate day & periods
	populateLeaves(leavesData, pending);
	
//	$("#dataTable").DataTable().clear().destroy(); 
	$('#dataTable').DataTable().ajax.reload();
}

function populateLeavemanagementHeader() {
	var tableHeaderElement = document.getElementById("dataTableHeader"); 
	
	// clear previously loaded header content
	tableHeaderElement.innerHTML = ""; 
	
	var tableHeaderRow = document.createElement("tr");
	
	leaveHeaders.forEach((header, index) => {
		var tableHeader = document.createElement("th");
		tableHeader.innerHTML = header;  
		tableHeaderRow.appendChild(tableHeader); 
	}); 
	
	tableHeaderElement.appendChild(tableHeaderRow); 
}

function populateLeaves(leavesData, pending) {
	var detailElement = document.getElementById("dataTableBody");
	
	var pendingLeaves; 
	
	if (pending === 'PENDING') {
		pendingLeaves = leavesData.leaves.filter(x => x.statusId === leavesData.leaveStatus.find(x => x.status==="PENDING").id);
	} else if (pending === 'ALL'){
		pendingLeaves = leavesData.leaves;
	} else if (pending === 'MY') {
		pendingLeaves = leavesData.leaves; 
	}
	
	pendingLeaves.forEach((pendingLeave, index) => {
		console.log(pendingLeave); 
		var ttRow = document.createElement("tr"); 
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = leavesData.users.find(x => x.id===pendingLeave.referenceId).fullName; 
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = leavesData.users.find(x => x.id===pendingLeave.referenceId).id; 
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = pendingLeave.startDate.substring(0, 10) + " - " + pendingLeave.endDate.substring(0, 10);  
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = "5";                        // TODO date subtraction logic. 
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = pendingLeave.reason;   
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
		ttRowData.innerHTML = leavesData.leaveStatus.find(x => x.id===pendingLeave.statusId).status;   
		ttRow.appendChild(ttRowData);
		
		var ttRowData = document.createElement("td"); 
//		ttRowData.innerHTML = "View Details";   
		
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

function newLeaveForm() {
	 hideMainComponents(); 
	 
	 populateLeaveFormElements(); 
	 document.getElementById("leaveForm").style.display = "block";
}

function populateLeaveFormElements() {
	// for all user roles: 
	document.getElementById("leaveStartDate").style.display = "block"; 
	document.getElementById("leaveEndDate").style.display = "block"; 
	document.getElementById("leaveMessage").style.display = "block"; 
	
	
	if (globalUserRole === "Principal") {
	}
	
	// if globalUserRole==="ClassTeacher" -> show: topic, message only 
	if (globalUserRole === "ClassTeacher") {
	}
	
	// if globalUserRole==="SubjectTeacher" -> show: class, section, topic, message
	if (globalUserRole === "SubjectTeacher") {
	}
	
	// if globalUserRole==="Student" -> handle error and logout. 
	if (globalUserRole === "Student") {
		// do nothing for now. TODO
	}
}

function newLeaveRequest() {
	populateNewLeaveRequestWindow(); 
}

function populateNewLeaveRequestWindow() {
	hideMainTables(); 
	
	document.getElementById("classSectionRow").style.display = null; 
	document.getElementById("newRequestWindow").style.display = null; 
	
	var formElement = document.getElementById("newRequestForm"); 
	formElement.setAttribute("value", "LEAVE"); 
}

function submitNewRequestForm() {
	var formElement = document.getElementById("newRequestForm"); 
	var formType = formElement.getAttribute("value"); 
	
	if(formType === "LEAVE") {
			var userId = getUserId(); 
			var startDate = formElement.elements[0].value; 
			var endDate = formElement.elements[2].value; 
			var reason = formElement.elements[4].value;
			
			var reqBody = {'startDate' : startDate, 'endDate' : endDate, 'reason' : reason, 'userId' : userId };
			url = "/leave-apply"; 
			
			getRestCallerWithReqBody(url, "GET", reqBody, getUserLeaves); 
	}
}