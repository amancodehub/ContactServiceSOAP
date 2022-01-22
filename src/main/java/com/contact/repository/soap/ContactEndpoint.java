package com.contact.repository.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.baeldung.GetContactRequest;
import com.baeldung.GetContactResponse;
import com.contact.repository.ContactRepository;

@Endpoint
public class ContactEndpoint {
	private static final String NAMESPACE_URI = "http://www.baeldung.com";
	
	private ContactRepository contactRepository;
	
	@Autowired
    public ContactEndpoint(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactRequest")
    @ResponsePayload
    public GetContactResponse getContact(@RequestPayload GetContactRequest request) {
        GetContactResponse response = new GetContactResponse();
        response.setContact(ContactRepository.findContact(request.getUserId()));
        return response;
    }
	
}