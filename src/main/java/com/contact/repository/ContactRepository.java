package com.contact.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.baeldung.Contact;

@Component
public class ContactRepository {
	
	private static final Map<Long, Contact> contacts = new HashMap<>();
	
	@PostConstruct
    public void initData() {
        // initialize countries map
		contacts.put((long) 12, new Contact((long) 1, "abc@gmail.com", "jaswanth", (long)12));
    }

    public static Contact findContact(Long userId) {
        return contacts.get(userId);
    }
    
}
