package com.crud.springboot.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.springboot.model.EmpDetails;
import com.crud.springboot.model.EmpLeaveType;
import com.crud.springboot.model.InwardDetails;
import com.crud.springboot.model.LeaveSanctioned;
import com.crud.springboot.model.LoanSansed;
import com.crud.springboot.model.Managerlogins;
import com.crud.springboot.model.TeamLead;
import com.crud.springboot.model.hrlogin;
import com.crud.springboot.repo.EmpDetailsRepository;
import com.crud.springboot.repo.LeaveTypeRepositrory;
import com.crud.springboot.service.EmpDetailsService;
import com.crud.springboot.service.InwardDetailService;
import com.crud.springboot.service.LeaveSanctionedService;
import com.crud.springboot.service.LeaveService;
import com.crud.springboot.service.LeaveTypeService;
import com.crud.springboot.service.LoanService;
import com.crud.springboot.service.LoanssansedService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")

public class EmpDetailsController {

	@Autowired
	EmpDetailsService empdetailsservice;

	@Autowired
	LeaveTypeService leaveTypeService;
	@Autowired
	InwardDetailService inwardservice;
	@Autowired
	LeaveSanctionedService leaveSanctionedService;
	@Autowired
	private LeaveService leaveservice;
	@Autowired
	LoanssansedService loanssansedService;
	@Autowired
	LeaveTypeRepositrory leaveTypeRepositrory;
	@Autowired
	LoanService loanservice;
	@Autowired
	EmpDetailsRepository empDetailsRepository;

	@GetMapping("/")
	public String getAllEmpDetails(Model model) {

		List<EmpDetails> empDetailsList = empdetailsservice.getAllEmpDetails();
		System.out.println("heloo");
		model.addAttribute("empDetailsList", empDetailsList);
		return "emp-details"; // Assuming you have an HTML template named emp-details.html

	}

	@GetMapping("/dummy")
	public String all(Model model) {

		return "dropdown";
	}

	@GetMapping("/dummy1")
	public String allll(HttpSession session,Model model) {
		 String authenticatedUsername = (String) session.getAttribute("authenticatedUsername");
	        int authenticatedEmpno = (int) session.getAttribute("authenticatedEmpno");

	        if (authenticatedUsername != null) {
	            model.addAttribute("authenticatedEmpno", authenticatedEmpno);
	            EmpDetails empDetails = empdetailsservice.findByUsername(authenticatedUsername);
	            model.addAttribute("empDetails", empDetails);

	      
		return "leaveloanform";
	        } else {
	            return "redirect:/login";
	        
	    }

	}

	@PostMapping("/dummy2")
	public String applyLeave(@RequestParam("empNo") int empId, @RequestParam("leaveType") String leaveType,
			@RequestParam("leaveSubtype") String leaveSubtype,

			@RequestParam("numberofdays") int numberofdays, @RequestParam("fromdate") Date fromdate,
			@RequestParam("todate") Date todate, Model model,HttpSession session) {
		if (numberofdays < 0) {
			model.addAttribute("leaveApplied", "Number of leave days cannot be negative");
			return "leaveloanform";
		}
		   
		String leaveApplied = leaveTypeService.applyLeave(empId, leaveType, leaveSubtype, numberofdays, fromdate,
				todate,session);

		model.addAttribute("leaveApplied", leaveApplied);
		if ("Leave request submitted successfully".equals(leaveApplied)) {
			return "redirect:/empdetails";// Redirect to another JSP page for success
		}
		return "leaveloanform";
	}

	@GetMapping("/loanapplied")
		public String loanapplied(HttpSession session,Model model) {
			 String authenticatedUsername = (String) session.getAttribute("authenticatedUsername");
		        int authenticatedEmpno = (int) session.getAttribute("authenticatedEmpno");

		        if (authenticatedUsername != null) {
		            model.addAttribute("authenticatedEmpno", authenticatedEmpno);
		            EmpDetails empDetails = empdetailsservice.findByUsername(authenticatedUsername);
		            model.addAttribute("empDetails", empDetails);

		      
			return "loanform";
		        } else {
		            return "redirect:/login";
		        
		    }

		
	}

	@PostMapping("/loanapplied")
	public String applyLoan(@RequestParam("empNo") int empId, @RequestParam("loanType") String loanType,
			@RequestParam("loanSubtype") String loanSubtype, @RequestParam("loanamount") int loanamount, Model model,HttpSession session) {
		if (loanamount < 0) {
			System.out.println("bdbjhbhjbh");
			model.addAttribute("leaveApplied", "Number of leave days cannot be negative");
			return "loanform";
		}
		String leaveApplied = leaveTypeService.applyLoan(empId, loanType, loanSubtype, loanamount,session);

		model.addAttribute("leaveApplied", leaveApplied);
		if ("Loan request submitted successfully".equals(leaveApplied)) {
			return "redirect:/inward";// Redirect to another JSP page for success
		}
		return "loanform";
	}

	@PostMapping("/hello")
	public String savedataedit(InwardDetails inward, Model model, RedirectAttributes redirectAttributes) {
		inwardservice.Saveall(inward);

		return "redirect:/inward";
	}

	@PostMapping("/leaveloan")
	public String saveleavetype(EmpLeaveType empLeaveType, Model model, RedirectAttributes redirectAttributes) {
		leaveTypeService.Saveall(empLeaveType);

		return "redirect:/leavetype";
	}

	@GetMapping("/inward")
	public String gettAllinward(Model model) {
		List<InwardDetails> inward = inwardservice.getAllInward();
			model.addAttribute("inwardDetailsList", inward);
			model.addAttribute("username","inwarddeails");
			
		return "inward-details";
	}

	@GetMapping("/leavetype")
	public String getAlleaveType(Model model) {
		List<EmpLeaveType> leavetype = leaveTypeService.getAllLeavetype();
		System.out.println("heloo");
		model.addAttribute("leaveTypeList", leavetype);

		return "leave-types";

	}

	@GetMapping("/leaverequest")
	public String getleaves(Model model) {
		List<InwardDetails> inward = inwardservice.findLeaveRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "leaverequest";
	}

	@GetMapping("/loanrequest")
	public String getloans(Model model) {
		List<InwardDetails> inward = inwardservice.findLoanRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "loanrequest";
	}

	@GetMapping("/assistant")
	public String assistant(Model model) {
		List<InwardDetails> inward = inwardservice.findLoanRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "assiant";
	}

	@GetMapping("/assistantmanager")
	public String assistantmanager(Model model) {
		List<InwardDetails> inward = inwardservice.findLoanRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "assistantmanager";
	}

	@GetMapping("/Loanmanager")
	public String Loanmanager(Model model) {
		List<InwardDetails> inward = inwardservice.findLoanRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "loanManager";
	}

	@GetMapping("/hr")
	public String Hr(Model model) {
		List<InwardDetails> inward = inwardservice.findLeaveRequests();
		model.addAttribute("inwardDetailsList", inward);
		model.addAttribute("user","hrllo");
			
		return "hrrequest";
	}

	@GetMapping("/manager")
	public String manager(Model model) {
		List<InwardDetails> inward = inwardservice.findLeaveRequests();
		model.addAttribute("inwardDetailsList", inward);

		return "managerrequest";
	}

	@GetMapping("/leaveform")
	public String getleave(Model model) {
		return "index";
	}

	@GetMapping("/sansed")
	public String leavesans(Model model) {
		List<LeaveSanctioned> inward = leaveSanctionedService.getAllLeaveSanctioned();
		model.addAttribute("leaveSanctionedList", inward);
		return "leavesans";
	}

	@GetMapping("/loan")
	public String loansans(Model model) {
		List<LoanSansed> loan = loanssansedService.getAllLoanSanctioned();
		model.addAttribute("loanSanctionedList", loan);
		return "loansansed";
	}

	@GetMapping("/approve")
	public String approve() {
		System.out.println("hello");
		return "index";
	}

	@GetMapping("/leaveform/{inwardNo}")
	public String del(@PathVariable int inwardNo, RedirectAttributes redirectAttributes) {
		inwardservice.getdetailsbyEmpNo(inwardNo);
		System.out.println(inwardNo);
		return "index";

	}

	@PostMapping("/leave/{empNo}")
	public String leaveAction(@PathVariable int empNo) {

		System.out.println("leave");

		leaveservice.leaveAction(empNo);
		System.out.println("leaveaction");
		//return "redirect:/hr";
		return "redirect:/leaverequest";


	}
	@PostMapping("/teamlead/{empNo}")
	public String leaverejectAction(@PathVariable int empNo) {

		System.out.println("leave");

		leaveservice.leaverejectAction(empNo);
		System.out.println("leaveaction");
		return "redirect:/leaverequest";

	}

	@PostMapping("/loan/{empNo}")
	public String Action(@PathVariable int empNo) {

		System.out.println("leave");
		loanservice.loanAction(empNo);

		System.out.println("leaveaction");
		return "redirect:/assistant";

	}

	@PostMapping("/assistant/{empNo}")
	public String loanAction(@PathVariable int empNo) {

		System.out.println("leave");
		loanservice.asstantAction(empNo);

		// leaveservice.leaveAction(empNo);
		System.out.println("leaveaction");
		return "redirect:/assistantmanager";

	}

	@PostMapping("/assistantmanager/{empNo}")
	public String AssistantmanagerloanAction(@PathVariable int empNo) {

		System.out.println("leave");
		loanservice.managerAction(empNo);

		// leaveservice.leaveAction(empNo);
		System.out.println("leaveaction");
		return "redirect:/Loanmanager";

	}

	@PostMapping("/loanManager/{empNo}")
	public String loanManagerloanAction(@PathVariable int empNo) {
		System.out.println("manager action success or not");

		System.out.println("leave");
		loanservice.ManagerAction(empNo);
		// leaveservice.leaveAction(empNo);
		System.out.println("manager action success or not");
		return "redirect:/loan";

	}

	@PostMapping("/hr/{empNo}")
	public String HrAction(@PathVariable int empNo) {
		System.out.println("heloo cyghdjkdcgdhddx");
		leaveservice.HrAcction(empNo);

		//return "redirect:/manager";
return "redirect:/hr";
	}

	/*
	 * @PostMapping("/hrreject/{empNo}") public String Hrrejection(@PathVariable int
	 * empNo) { System.out.println("heloo cyghdjkdcgdhddx");
	 * leaveservice.Hrreject(empNo);
	 * 
	 * return "redirect:/hr";
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/manager/{empNo}") public String managerAction(@PathVariable
	 * int empNo,String subject,String text,String employeeEmail) {
	 * System.out.println("manageraction madhuri");
	 * 
	 * leaveservice.ManagerAction(empNo,subject,text,employeeEmail);
	 * 
	 * 
	 * return "redirect:/sansed";
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/managerleavereject/{empNo}") public String
	 * managerleavereject(@PathVariable int empNo) { System.out.println("rejected");
	 * leaveservice.ManagerrjectAction(empNo);
	 * 
	 * return "redirect:/manager";
	 * 
	 * }
	 */

	@PostMapping("/assistantloanereject/{empNo}")
	public String assistantloanvereject(@PathVariable int empNo) {

		loanservice.Assistantreject(empNo);

		return "redirect:/loanrequest";

	}

	@PostMapping("/assistantmanagerloanereject/{empNo}")
	public String assistantManagerLoanveReject(@PathVariable int empNo) {

		loanservice.Assistantmanagerreject(empNo);

		return "redirect:/loanrequest";

	}

	@PostMapping("/managerloanereject/{empNo}")
	public String ManagerLoanveReject(@PathVariable int empNo) {

		loanservice.Managerreject(empNo);

		return "redirect:/loanrequest";

	}



	@PostMapping("/loanreject/{empNo}")
	public String loanreject(@PathVariable int empNo) {

		leaveservice.reject(empNo);

		return "redirect:/loanrequest";

	}

//	@PostMapping("/approve/{empNo}")
//	public String approveInward(@PathVariable int empNo, Model model) {
//		System.out.println("approve2334344fggth");
//		List<InwardDetails> inwardList = inwardservice.getAllInward();
//		System.out.println("inwardsize is " + inwardList.size());
//		 for (InwardDetails inward : inwardList) {
//		        String requestType = inward.getRequestType();
//		        
//		        if ("Leave".equals(requestType)) {
//		            // Redirect to the leave request page
//		            return "redirect:/leaverequest"; // Change the URL to the actual leave request page
//		        } else if ("Loan".equals(requestType)) {
//		            // Redirect to the loan request page
//		            return "redirect:/loanrequest"; // Change the URL to the actual loan request page
//		        }
//		    }
//		    
//		    // Handle other request types or errors here
//		    return "redirect:/error"; // Change the URL to the error page
//		}

	@GetMapping("/emplogin")
	public String loginPage() {
		return "emplogin"; // You should create a corresponding login HTML page
	}

	@GetMapping("/home")
	public String homePage() {
		return "home"; // You should create a corresponding login HTML page
	}
	@PostMapping("/forgot")
	public String pforgot() {
		return "forgot"; // You should create a corresponding login HTML page
	}

	@PostMapping("/emplogin")
	public String login(@RequestParam String username, @RequestParam String Password, HttpSession session, Model model) {
		EmpDetails employee = empdetailsservice.findByUsername(username);
		 Managerlogins manager = empdetailsservice.findByManagerUsername(username);
		   hrlogin hr = empdetailsservice.findByhrUsername(username);
		 TeamLead  team=empdetailsservice.findBytemaleadUsername(username);
		if (employee != null &&employee.getPassword().equals(Password)) {
      
			 session.setAttribute("authenticatedUsername", username);
	            session.setAttribute("authenticatedEmpno", employee.getEmpNo());
	            session.setAttribute("user", employee);
	            model.addAttribute("username",username);

		return "redirect:/leaveform";
		}
		else if (manager != null) {
			 session.setAttribute("ManagerUsername", username);
		     
            // Manager login
            session.setAttribute("user", manager);
            //return "redirect:/manager";
            model.addAttribute("username",username);
            
            return "redirect:/modified";
		}
		 else if (hr != null) {
	            // HR login
			 session.setAttribute("HrUsername", username);
			  
	            session.setAttribute("user", hr);
	            model.addAttribute("username",username);

	            return "redirect:/modifiedhr";
	            
	        }
		 else if (team != null) {
	            // HR login
			 session.setAttribute("TeamLeadUsername", username);
			  
	            session.setAttribute("user", hr);
	            model.addAttribute("username",username);

	            return "redirect:/modifiedteamlead";
	            
	        }
		

		else {
            // Authentication failed, set an error message in the model
            model.addAttribute("error", "Invalid username or password");
            return "emplogin";
        }
		// Login failed, return to login page
	}


	@GetMapping("/empdetails")
	public String empdetails() {
		return "employeedetails"; // You should create a corresponding login HTML page
	}
	@GetMapping("/managerscreen")
	public String managerscreen() {
		return "managerpage"; // You should create a corresponding login HTML page
	}
	@GetMapping("/forgot")
	public String forgot() {
		return "forgot"; // You should create a corresponding login HTML page
	}
	
	
	 @GetMapping("/emp")
	    public String viewEmployeeDetails(HttpSession session, Model model) {
		 int authenticatedEmpnumber = (int) session.getAttribute("authenticatedEmpno");

	        if (authenticatedEmpnumber != -1) {
	            List<EmpLeaveType> leaveRequests = leaveTypeRepositrory.findByempNo(authenticatedEmpnumber);
	            model.addAttribute("authenticatedEmpno", authenticatedEmpnumber);
	            model.addAttribute("leaveTypeList", leaveRequests);
	            return "leave-types";
	        } else {
	            return "redirect:/login";
	        }
	    }
	 @GetMapping("/modified")
	 public String modified(HttpSession session, Model model) {
				List<InwardDetails> inward = inwardservice.Manager();
				model.addAttribute("inwardDetailsList", inward);
				 String username = (String) session.getAttribute("ManagerUsername");
	             System.out.println(username);
			model.addAttribute("username","Welcome  "+username);

				return "inward-details";
	 }
	 @GetMapping("/modifiedhr")
	 public String modifiedhr(HttpSession session, Model model) {
			List<InwardDetails> inward = inwardservice.hr();
			model.addAttribute("inwardDetailsList", inward);
			 String username = (String) session.getAttribute("HrUsername");
          System.out.println(username);
		model.addAttribute("username","Welcome  "+username);

			return "inward-details";
}
	 @GetMapping("/modifiedteamlead")
	 public String modifiedteamlead(HttpSession session, Model model) {
			List<InwardDetails> inward = inwardservice.teamlead();
			model.addAttribute("inwardDetailsList", inward);
			 String username = (String) session.getAttribute("TeamLeadUsername");
          System.out.println(username);
		model.addAttribute("username","Welcome  "+username);

			return "inward-details";
}
	  @PostMapping("/processApproval/{empNo}")
	    public String processApproval(@RequestParam String status,@RequestParam String requestType, @RequestParam String action,@PathVariable int empNo,String subject,String text,String employeeEmail) {
	        System.out.println("Status: " + status); // Check if the status is received correctly

	        if ("approve".equals(action)) {
	            if ("waiting for hr".equals(status)) {
	            	leaveservice.HrAcction(empNo);
	                return "redirect:/modifiedhr";
	            } else if( "waiting for manager".equals(status)) {
	            	leaveservice.ManagerAction(empNo,subject,text,employeeEmail);
	    			

	    			return "redirect:/sansed";
	            	
	                // Handle other cases if needed
	            }else if("pending".equals(status) && ("Loan".equals(requestType) || "Leave".equals(requestType))) {
	            	  if ("Loan".equals(requestType)) {
	                      return "redirect:/loanrequest";
	            	  }
	                    	
	            	  else if ("Leave".equals(requestType)) {
	            		  leaveservice.leaveAction(empNo);
	                      return "redirect:/modifiedteamlead";
	                  }
       		    
	            	return "error";
	            }
	        } else if ("reject".equals(action)) {
	            if ("rejected by manager".equals(status)){
	            	leaveservice.ManagerrjectAction(empNo);

	            	return "redirect:/modified";
	            } else if("rejected by hr".equals(status)){
	            	leaveservice.Hrreject(empNo);
	           	  
	           	  return "redirect:/modifiedhr";
	           	 
	            	
	                // Handle other cases if needed
	            }
	            else {
	            	
	            }
	        }

	        // Default redirect if no conditions are met
	        return "redirect:/defaultPage";
	    }
	 
	 
}

