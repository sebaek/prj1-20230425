package com.example.demo.domain;

import java.time.*;

import lombok.*;

@Data
public class Member {
	private String id;
	private String password;
	private String email;
	private String nickName;
	private LocalDateTime inserted;
}






