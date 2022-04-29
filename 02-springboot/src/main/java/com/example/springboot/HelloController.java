package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example")
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1L, "hanako");
	}

	// @PostMapping(value = "/users")
	// public User createUser(User user) {
	// }

	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable("id") String id) {
		if (id != null) {
			return new User(id, "hanako");
		} else {
			throw new RuntimeException("x");
		}
	}

	// @GetMapping("users/{id}")
	// public ResponseEntity<User> getById(@PathVariable long id) {
	// 	Optional<User> user = userService.getById(id);
	// 	if (user.isPresent()) {
	// 		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	// 	} else {
	// 		throw new RecordNotFoundException();
	// 	}
	// }

	// @PostMapping(path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<User> create(@RequestBody User newUser) {
	// 	User user = userService.save(newUser);
	// 	if (user == null) {
	// 		throw new ServerException();
	// 	} else {
	// 		return new ResponseEntity<>(user, HttpStatus.CREATED);
	// 	}
	// }
}