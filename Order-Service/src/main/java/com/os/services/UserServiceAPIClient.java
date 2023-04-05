package com.os.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.os.model.User;

@FeignClient(value = "user-service")
@Component
public interface UserServiceAPIClient {

	@GetMapping(value = "user/get/{userId}", produces = "application/json")
	User getUserById(@PathVariable("userId") Long userId);

}
