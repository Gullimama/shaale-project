function hideMainComponents() {
	// handles timetable, attendance. 
	document.getElementById("datatableHolder").style.display = "none"; 
	
	document.getElementById("announcementForm").style.display = "none"; 
	document.getElementById("leaveForm").style.display = "none"; 
	document.getElementById("ptmForm").style.display = "none"; 
	
}

function hideAllDisplayComponents() {
	// hide all sidebar options
	hideAllSidebarOptions();

	// hide all forms
	hideAllForms(); 
	
	// hide all tables
	hideMainSection(); 
	
	// hide all tabular forms
	hideTabularForms(); 
	
	// hide the jumbotron
}

function hideMainSection() {
	hideAllForms(); 
	hideTabularForms(); 
	hideMainTable(); 
}

function hideTabularForms() {
	document.getElementById("tabularForm").style.display = "none"; 
		document.getElementById("tabularClassSectionDropdowns").style.display = "none"; 
		document.getElementById("tabularAttendanceDates").style.display = "none"; 
	
}

function hideMainTable() {
	document.getElementById("datatableHolder").style.display = "none"; 
}

function displayMainTable() {
	document.getElementById("datatableHolder").style.display = "block"; 
}

function hideAllForms() {
	// hide announcements, leaves, ptm forms
//	document.getElementById("tabularForm").style.display = "none"; 
	document.getElementById("announcementForm").style.display = "none"; 
		document.getElementById("announcementClassSections").style.display = "none"; 
//		document.getElementById("announcementSection").style.display = "none"; 
		document.getElementById("announcementType").style.display = "none"; 
		document.getElementById("announcementTopic").style.display = "none"; 
		document.getElementById("announcementMessage").style.display = "none"; 
	document.getElementById("leaveForm").style.display = "none"; 
		document.getElementById("leaveStartDate").style.display = "none"; 
		document.getElementById("leaveEndDate").style.display = "none"; 
		document.getElementById("leaveMessage").style.display = "none"; 
	document.getElementById("ptmForm").style.display = "none"; 
		document.getElementById("ptmClass").style.display = "none"; 
		document.getElementById("ptmSection").style.display = "none"; 
		document.getElementById("ptmStudentId").style.display = "none"; 
		document.getElementById("ptmStudentName").style.display = "none"; 
		document.getElementById("ptmDate").style.display = "none"; 
		document.getElementById("ptmTime").style.display = "none"; 
		document.getElementById("ptmMessage").style.display = "none"; 
}

function hideAllSidebarOptions() {
	document.getElementById("timetableOption").style.display = "none"; 
	document.getElementById("attendanceOption").style.display = "none"; 
	document.getElementById("announcementOption").style.display = "none"; 
		document.getElementById("makeAnnoucementButton").style.display = "none"; 
		document.getElementById("viewClassAnnouncementButton").style.display = "none"; 
		document.getElementById("viewSchoolAnnouncementButton").style.display = "none"; 
		document.getElementById("viewPrincipalAnnouncementButton").style.display = "none"; 
	document.getElementById("leaveManagementOption").style.display = "none"; 
		document.getElementById("pendingLeaveButton").style.display = "none"; 
		document.getElementById("allLeaveButton").style.display = "none"; 
		document.getElementById("myLeaveButton").style.display = "none"; 
		document.getElementById("newLeaveButton").style.display = "none"; 
	document.getElementById("ptmOption").style.display = "none"; 
		document.getElementById("newPtmButton").style.display = "none"; 
		document.getElementById("previousPtmButton").style.display = "none"; 
		
	document.getElementById("attendeesOption").style.display = "none"; 
	document.getElementById("sessionOption").style.display = "none"; 
		document.getElementById("startClassButton").style.display = "none"; 
		document.getElementById("pauseClassButton").style.display = "none"; 
		document.getElementById("screenShareButton").style.display = "none"; 
	document.getElementById("archivedClasses").style.display = "none"; 
}

function displaySchoolOptions() {
	// TODO - handle as per USERROLES;
	hideAllSidebarOptions(); 
	
	switch(globalUserRole) {
	case "ClassTeacher": 
		// show - timetable, attendance, announcements, leave-management, parents meeting
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("attendanceOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
			document.getElementById("pendingLeaveButton").style.display = "block"; 
			document.getElementById("allLeaveButton").style.display = "block"; 
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
			document.getElementById("newPtmButton").style.display = "block"; 
			document.getElementById("previousPtmButton").style.display = "block"; 
			
		break; 
	case "SubjectTeacher": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
//			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block";
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
			document.getElementById("newPtmButton").style.display = "block"; 
			document.getElementById("previousPtmButton").style.display = "block"; 
		break; 
	case "Principal": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block";
		document.getElementById("attendanceOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
			document.getElementById("newPtmButton").style.display = "block"; 
			document.getElementById("previousPtmButton").style.display = "block"; 
		break; 
	case "Student": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		break; 
	case "Parent": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
	case "Admin": 
		break; 
	}
}

function displayClassOptions() {
	hideAllSidebarOptions(); 
	
	switch(globalUserRole) {
	case "ClassTeacher": 
		// show - timetable, attendance, announcements, leave-management, parents meeting
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("attendanceOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
			document.getElementById("pendingLeaveButton").style.display = "block"; 
			document.getElementById("allLeaveButton").style.display = "block"; 
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
			document.getElementById("newPtmButton").style.display = "block"; 
			document.getElementById("previousPtmButton").style.display = "block"; 
			
		document.getElementById("attendeesOption").style.display = "block"; 
		document.getElementById("sessionOption").style.display = "block"; 
			document.getElementById("startClassButton").style.display = "block"; 
			document.getElementById("pauseClassButton").style.display = "block"; 
			document.getElementById("screenShareButton").style.display = "block"; 
		document.getElementById("archivedClasses").style.display = "block"; 
		break; 
	case "SubjectTeacher": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
//			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
		
		document.getElementById("attendeesOption").style.display = "block"; 
		document.getElementById("sessionOption").style.display = "block"; 
			document.getElementById("startClassButton").style.display = "block"; 
			document.getElementById("pauseClassButton").style.display = "block"; 
			document.getElementById("screenShareButton").style.display = "block"; 
		document.getElementById("archivedClasses").style.display = "block"; 
		break; 
	case "Principal": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("attendanceOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("makeAnnoucementButton").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
			document.getElementById("viewPrincipalAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block";
		
		document.getElementById("attendeesOption").style.display = "block"; 
		document.getElementById("sessionOption").style.display = "block"; 
			document.getElementById("startClassButton").style.display = "block"; 
			document.getElementById("pauseClassButton").style.display = "block"; 
			document.getElementById("screenShareButton").style.display = "block"; 
		document.getElementById("archivedClasses").style.display = "block"; 
		break; 
	case "Student": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block"; 
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("archivedClasses").style.display = "block"; 
		break; 
	case "Parent": 
		document.getElementById("timetableOption").style.display = "block"; 
		document.getElementById("announcementOption").style.display = "block"; 
			document.getElementById("viewClassAnnouncementButton").style.display = "block"; 
			document.getElementById("viewSchoolAnnouncementButton").style.display = "block"; 
		document.getElementById("leaveManagementOption").style.display = "block";
			document.getElementById("myLeaveButton").style.display = "block"; 
			document.getElementById("newLeaveButton").style.display = "block"; 
		document.getElementById("ptmOption").style.display = "block"; 
			document.getElementById("previousPtmButton").style.display = "block"; 
		document.getElementById("archivedClasses").style.display = "block"; 
		break; 
	case "Admin": 
		break; 
	}
}

function displayTimetableComponents() {
	switch(globalUserRole) {
	case "Principal":
		document.getElementById("tabularForm").style.display = "block"; 
			document.getElementById("tabularClassSectionDropdowns").style.display = "flex"; 
			document.getElementById("tabularAttendanceDates").style.display = "none"; 
		break; 
	case "ClassTeacher":
		
		break; 
	case "SubjectTeacher":
		
		break; 
	case "Student":
		
		break; 
	case "Parent":
		
		break; 
	case "Admin":
		
		break; 
	}
	
	displayMainTable(); 
//	document.getElementById("datatableHolder").style.display= "block"; 
}

function displayAttendanceComponents() {
	switch(globalUserRole) {
	case "Principal":
		document.getElementById("tabularForm").style.display = "block"; 
			document.getElementById("tabularClassSectionDropdowns").style.display = "flex"; 
			document.getElementById("tabularAttendanceDates").style.display = "flex"; 
		break; 
	case "ClassTeacher":
		document.getElementById("tabularForm").style.display = "block"; 
			document.getElementById("tabularClassSectionDropdowns").style.display = "none"; 
			document.getElementById("tabularAttendanceDates").style.display = "flex"; 
		break; 
	case "SubjectTeacher":
		
		break; 
	case "Student":
		
		break; 
	case "Parent":
		
		break; 
	case "Admin":
		
		break;
	}
	displayMainTable(); 
}

function displayAnnouncementComponentsForClass() {
	hideMainSection(); 
	switch(globalUserRole) {
	case "Principal":
		document.getElementById("tabularForm").style.display = "block"; 
		document.getElementById("tabularClassSectionDropdowns").style.display = "flex"; 
		document.getElementById("tabularAttendanceDates").style.display = "none"; 
		break; 
	case "ClassTeacher":
		break; 
	case "SubjectTeacher":
		
		break; 
	case "Student":
		
		break; 
	case "Parent":
		
		break; 
	case "Admin":
		
		break;
	}
	displayMainTable(); 
}

function displayAnnouncementComponentsForSchool() {
	hideMainSection(); 
	switch(globalUserRole) {
	case "Principal":
		break; 
	case "ClassTeacher":
		break; 
	case "SubjectTeacher":
		
		break; 
	case "Student":
		
		break; 
	case "Parent":
		
		break; 
	case "Admin":
		
		break;
	}
	displayMainTable(); 
}

function displayAnnouncementComponentsForPrincipal() {
	hideMainSection(); 
	switch(globalUserRole) {
	case "Principal":
		break; 
	case "ClassTeacher":
		break; 
	case "SubjectTeacher":
		
		break; 
	case "Student":
		
		break; 
	case "Parent":
		
		break; 
	case "Admin":
		
		break;
	}
	displayMainTable(); 
}

function displayAnnouncementForm() {
	switch(globalUserRole) {
	case "Principal":
		document.getElementById("announcementForm").style.display = "block"; 
			document.getElementById("announcementClassSections").style.display = "none"; 
			document.getElementById("announcementType").style.display = "block"; 
			document.getElementById("announcementTopic").style.display = "block"; 
			document.getElementById("announcementMessage").style.display = "block"; 
		break; 
	case "ClassTeacher":
		document.getElementById("announcementForm").style.display = "block"; 
			document.getElementById("announcementClassSections").style.display = "none"; 
			document.getElementById("announcementType").style.display = "none"; 
			document.getElementById("announcementTopic").style.display = "block"; 
			document.getElementById("announcementMessage").style.display = "block"; 
		break; 
	case "SubjectTeacher":
		document.getElementById("announcementForm").style.display = "block"; 
			document.getElementById("announcementClassSections").style.display = "flex"; 
			document.getElementById("announcementType").style.display = "none"; 
			document.getElementById("announcementTopic").style.display = "block"; 
			document.getElementById("announcementMessage").style.display = "block"; 
		break; 
	case "Student":
		break; 
	case "Parent":
		break; 
	case "Admin":
		break;
	}
}