package com.salt.smayouth;

import com.salt.smayouth.domain.member.Member;
import com.salt.smayouth.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		Member member = new Member();
		member.setUesrname("memberA");
		Long savedId = memberRepository.save(member);

		Member findMember = memberRepository.find(savedId);

		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUesrname()).isEqualTo(member.getUesrname());
		Assertions.assertThat(findMember).isEqualTo(member);  //엔티티 동일성 보장
	}
}
