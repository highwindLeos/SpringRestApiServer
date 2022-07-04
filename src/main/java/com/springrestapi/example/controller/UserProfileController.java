package com.springrestapi.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.example.mapper.UserProfileMapper;
import com.springrestapi.example.model.UserProfile;



@RestController
public class UserProfileController {
	
	/*
	 * private Map<String, UserProfile> userMap;
	 * 
	 * @PostConstruct public void init() { userMap = new HashMap<String,
	 * UserProfile>();
	 * 
	 * userMap.put("1", new UserProfile("1", "�솉湲몃룞1", "111-1111", "�꽌�슱�떆 媛뺣궓援� ��移섎룞1"));
	 * userMap.put("2", new UserProfile("2", "�솉湲몃룞2", "222-2222", "�꽌�슱�떆 媛뺣궓援� ��移섎룞2"));
	 * userMap.put("3", new UserProfile("3", "�솉湲몃룞3", "333-3333", "�꽌�슱�떆 媛뺣궓援� ��移섎룞3"));
	 * userMap.put("4", new UserProfile("4", "�솉湲몃룞4", "444-4444", "�꽌�슱�떆 媛뺣궓援� ��移섎룞4"));
	 * 
	 * }
	 * 
	 */
	
	private UserProfileMapper mapper;

	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return mapper.getUserProfile(id);
	} // �듅�젙 �븘�씠�뵒 媛� 媛��졇�삤湲�
	
	@GetMapping("user/all")
	public List<UserProfile> getUserProfileList() {
		return mapper.getUserProfileList();
	} // �쟾泥� 媛��졇�삤湲�
	
	@PostMapping("user/{id}")
	public void postUserProfile(@PathVariable("id") String id, 
							    @RequestParam("name") String name, 
							    @RequestParam("phone") String phone, 
							    @RequestParam("address") String address ) {
		mapper.insertUserProfile(id, name, phone, address);
	} // 異붽��떆
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, 
							   @RequestParam("name") String name, 
							   @RequestParam("phone") String phone, 
							   @RequestParam("address") String address ) {
		
		mapper.updateUserProfile(id, name, phone, address);
	} // �닔�젙�떆 
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
	} // �궘�젣�떆
					
}
