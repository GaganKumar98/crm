package com.gagan.springcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gagan.springcms.dao.CustomerDAO;
import com.gagan.springcms.entity.Customer;
import com.gagan.springcms.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CutomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		List<Customer> theCustomer = customerService.getCustomers();
		theModel.addAttribute("customers", theCustomer);
		System.out.println("theCustomer : " + theCustomer);
		return "list-customer";
	}

	@GetMapping("/addcustomer")
	public String addcustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/savecustomer")
	public String SaveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updatecustomer")
	public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel) {

		Customer thecustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", thecustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteRecord(@RequestParam("customerId") int theId, Model theModel) {
		System.out.println("theId : " + theId);
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
