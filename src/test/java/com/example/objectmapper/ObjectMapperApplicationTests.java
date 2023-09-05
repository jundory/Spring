package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("-----------");

		// object-mapper는 text 형태의 JSON을 object로, 그 반대의 경우에도 마찬가지로 변환해줌

		var objectMapper = new ObjectMapper();

		//obj -> json(text)
		// object mapper는 get method 를 활용한다.
		var user = new User("steve", 20, "010-1234-1234");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text); //json


		//json(text) -> obj
		//object mapper는 default 생성자를 필요로 한다.
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser); //object
	}

}
