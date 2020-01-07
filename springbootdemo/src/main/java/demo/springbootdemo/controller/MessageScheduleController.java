package demo.springbootdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.springbootdemo.model.Message;
import demo.springbootdemo.service.MessageScheduleService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Message Service")
public class MessageScheduleController {
	
	@Autowired
	private MessageScheduleService service;
	
	@PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> message(@RequestBody @Valid Message message) {
		try {
			service.scheduleMessage(message);
			return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
