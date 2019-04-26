window.onload = () => {
	getAllEmployees();
	getAllPendingRequests();
	document.getElementById("createRequestBtn").addEventListener("click", approveRequest);
	
}

const showEmployees = () => {
	const x = document.getElementById("employees");
	if(x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}

const showMeMoney = () => {
	const x = document.getElementById("reimbursement");
	if(x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}

const approvedMoney = () => {
	const x = document.getElementById("approved");
	if(x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}
}

const getAllEmployees = () => {
	const xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			populateTable(JSON.parse(json));
			console.log(json);
		}
	}
	
	xhr.open("GET", "http://localhost:8088/ERSProject/api/employees");
	
	xhr.send();
}

const populateTable = (listOfEmployees) => {
	
	for (let employee of listOfEmployees) {
		const tdEmployeeId = document.createElement("td");
		const tdEmpFirstName = document.createElement("td");
		const tdEmpLastName = document.createElement("td");


		tdEmployeeId.textContent = employee.employeeId;
		tdEmpFirstName.textContent = employee.employeeFirstName;
		tdEmpLastName.textContent = employee.employeeLastName;
		
		
		const row = document.createElement("tr");
		
	
		row.appendChild(tdEmployeeId);
		row.appendChild(tdEmpFirstName);
		row.appendChild(tdEmpLastName);
		
		document.getElementById("employeeTable").appendChild(row);
	}
}


const getAllPendingRequests = () => {
	console.log("entered getRequests");
	//Step 1: Create an XMLHttpRequest object
	const xhr = new XMLHttpRequest();
	
	//Step 2: Assign a callback function to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		console.log("entered readystatechange")
		//Step 5: Handle each of the different possible outcomes from making this request 
		if (xhr.status === 200 && xhr.readyState === 4){
			console.log("in callback function");
			const json = xhr.responseText;
			populatePendingRequestTable(JSON.parse(json));
		}
	};
	
	//Step 3: Call xhr.open(), passing in 2 strings for the HTTP Method and URL 
	xhr.open("GET", "http://localhost:8088/ERSProject/api/requests"); 
	
	//Step 4: Call xhr.send() to actually fire off your HTTP Request
	xhr.send();
}



const populatePendingRequestTable = (listOfPendingRequests) => {
	//the for...of loop is JavaScript's version of the enhanced for loop
	//the for...in loop iterates over every property of a JS object
	for (let request of listOfPendingRequests){
		//create a table cell for each property of the object
		const tdRequestId = document.createElement("td");
		const tdReimbursementAmount = document.createElement("td");
		const tdManagerId = document.createElement("td");
		const tdEmpId = document.createElement("td");
		const tdStatus = document.createElement("td");
		
		//set value of each cell
		tdRequestId.textContent = request.requestId;
		tdReimbursementAmount.textContent = request.reimbursementAmount;
		tdManagerId.textContent = request.managerId;
		tdEmpId.textContent = request.employeeId;
		tdStatus.textContent = request.status;
		
		//Create a row to be appended onto our table
		const row = document.createElement("tr");
		
		//Set the td's to the corresponding order of the table header
		row.appendChild(tdRequestId);
		row.appendChild(tdReimbursementAmount);
		row.appendChild(tdManagerId);
		row.appendChild(tdEmpId);
		row.appendChild(tdStatus);
		
		//Append the row onto table of pendingRequests
		document.getElementById("pendingRequestTable").appendChild(row);
	}
}

const approveRequest = () => {
	//Step 1: create XHR object
	const xhr = new XMLHttpRequest();
	//Step 1.5: Create a helper variable for your form data
	const formData = parseForm();
	//Step2: assign callback function to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		if (xhr === 200 && xhr.readState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	
	//Step 3: open up the request
	xhr.open("POST", "http://localhost:8088/ERSProject/ApprovedReimbursementServlet");
	
	//Step 4: send off the request
	xhr.send(JSON.stringify(formData));
}

const parseForm = () => {
	const requestIdText = document.getElementById("requestId").value;
	const reimbursementText = document.getElementById("reimbursement").value;
	const employeeIdText = document.getElementById("employeeId").value;
	
	return {
		approvedRequestId: requestIdText,
		reimbursementAmount: reimbursementText,
		employeeId: employeeIdText
		
	}
}