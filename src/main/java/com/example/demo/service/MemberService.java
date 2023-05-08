package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean signup(Member member) {
		
		// 암호 암호화
		String plain = member.getPassword();
		member.setPassword(passwordEncoder.encode(plain));
		
		int cnt = mapper.insert(member);
		return cnt == 1;
	}

	public List<Member> listMember() {
		
		return mapper.selectAll();
		
	}

	public Member get(String id) {
		return mapper.selectById(id);
	}

	public boolean remove(Member member) {
		Member oldMember = mapper.selectById(member.getId());
		int cnt = 0;
		
		if (passwordEncoder.matches(member.getPassword(), oldMember.getPassword())) {
			// 암호가 같으면?
			
			cnt = mapper.deleteById(member.getId());
		}
		
		return cnt == 1;
	}

	public boolean modify(Member member, String oldPassword) {
		
		// 패스워드를 바꾸기 위해 입력했다면...
		if (!member.getPassword().isBlank()) {
			
			// 입력된 패스워드를 암호화
			String plain = member.getPassword();
			member.setPassword(passwordEncoder.encode(plain));
		}
		
		Member oldMember = mapper.selectById(member.getId());

		int cnt = 0;
		
		if (passwordEncoder.matches(oldPassword, oldMember.getPassword())) {
			// 기존 암호와 같으면
			cnt = mapper.update(member);
		}
		
		return cnt == 1;
	}
}




