package com.example.service;

import com.example.entity.Student;
import com.example.feignclient.AddressClient;
import com.example.model.AddressResponse;
import com.example.model.StudentRequest;
import com.example.model.StudentResponse;
import com.example.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	/*@Autowired
	WebClient webClient;*/

	@Autowired
	AddressClient addressClient;

	@Autowired
	CommonService commonService;

	public StudentResponse createStudent(StudentRequest createStudentRequest) {
		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());

		student = studentRepository.save(student);
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		//studentResponse.setAddressResponse(addressClient.getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		//studentResponse.setAddressResponse(addressClient.getAddressById(student.getAddressId()));
		return studentResponse;
	}

	/*public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> mono = webClient.get().uri("/" + addressId).retrieve().bodyToMono(AddressResponse.class);
		return mono.block();
	}*/
}
