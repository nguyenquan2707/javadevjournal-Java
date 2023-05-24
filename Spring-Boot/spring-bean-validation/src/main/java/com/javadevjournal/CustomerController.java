package com.javadevjournal;

import com.javadevjournal.data.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class CustomerController {


    @GetMapping("/customer")
    public String getCustomer(final Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/customer")
    public String createCustomer(@Valid Customer customer, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            return "customer";
        }
        model.addAttribute("msg", "Customer added");
        model.addAttribute("customer", customer);
        return "customer";
    }

}
