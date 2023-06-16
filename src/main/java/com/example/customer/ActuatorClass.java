package com.example.customer;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "check")
public class ActuatorClass {
	
	@ReadOperation
	public String check() {
		return "Completed";
	}

}
