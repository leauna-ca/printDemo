package demo.springbootdemo.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springbootdemo.model.Message;
import demo.springbootdemo.repository.MessageRepository;

@Service
public class MessageScheduleService {

	@Autowired
	private MessageRepository messageRepository;
	
	private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

	public void scheduleMessage(Message message) throws Exception {
		long delay = message.getScheduleTime().getTime() - System.currentTimeMillis();
		if(delay <= 0) {
			throw new Exception("Delivery time is earlier than current time.");
		}
		message = messageRepository.insert(message);
		
		schedule(message, delay);
	}
	
	private void schedule(final Message message, long delay) {
		scheduler.schedule(new Runnable() {
			public void run() {
				System.out.println(message.getMessage());
				messageRepository.delete(message);
			}
		}, delay/1000, TimeUnit.SECONDS);
	}
}
