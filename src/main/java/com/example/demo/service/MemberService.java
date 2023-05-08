package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MemberMapper mapper;

	public boolean signup(Member member) {
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
		
		if (oldMember.getPassword().equals(member.getPassword())) {
			// 암호가 같으면?
			
			cnt = mapper.deleteById(member.getId());
		}
		
		return cnt == 1;
	}

	public boolean modify(Member member, String oldPassword) {
		Member oldMember = mapper.selectById(member.getId());

		int cnt = 0;
		if (oldMember.getPassword().equals(oldPassword)) {
			
			cnt = mapper.update(member);
		}
		
		return cnt == 1;
	}
}




