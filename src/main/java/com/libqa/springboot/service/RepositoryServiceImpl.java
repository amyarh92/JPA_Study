package com.libqa.springboot.service;

import com.libqa.springboot.entity.Department;
import com.libqa.springboot.entity.Member;
import com.libqa.springboot.entity.Team;
import com.libqa.springboot.repository.DepartmentRepository;
import com.libqa.springboot.repository.MemberRepository;
import com.libqa.springboot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by coupang on 2015. 11. 4..
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private DepartmentRepository departmentRepository;


	@Override
	public void saveMember() {
		Department department1 = new Department("CTO");
		Department department2 = new Department("여헹/레저");

		Team bali = new Team("Bali", department1);
		Team creta = new Team("Creta", department1);
		Team titan = new Team("Titan", department1);
		Team travel = new Team("여행", department2);
		Team leisure = new Team("레져", department2);

		Member amy = new Member("Amy", bali);
		Member dooboo = new Member("Dooboo", bali);
		Member coel = new Member("Coel", creta);
		Member pudding = new Member("Pudding", titan);
		Member yesman = new Member("Yesman", travel);
		Member noman = new Member("Noman", leisure);

		departmentRepository.save(department1);
		departmentRepository.save(department2);

		teamRepository.save(bali);
		teamRepository.save(creta);
		teamRepository.save(titan);
		teamRepository.save(travel);
		teamRepository.save(leisure);

		memberRepository.save(amy);
		memberRepository.save(dooboo);
		memberRepository.save(coel);
		memberRepository.save(pudding);
		memberRepository.save(yesman);
		memberRepository.save(noman);

	}

	@Override
	@Transactional // Team 의 내부 컬랙션이 Lazy 전략이기 때문에 Transactional 이 적용 되어야 한다.
	public void print() {
		List<Department> departments = departmentRepository.findAll();
		List<Team> teams = teamRepository.findAll();

		for (Department department : departments) {
			System.out.printf("**********************************");
			System.out.println(" department = " + department);

			for (Team lazyTeam : department.getTeams()) {
				System.out.printf("**********************************");
				System.out.println(" lazyTeam : " + lazyTeam);
			}
		}

		for (Team team : teams) {
			System.out.printf("**********************************");
			System.out.println(" team = " + team);

			for (Member lazyMember : team.getMembers()) {
				System.out.printf("**********************************");
				System.out.println(" lazyMember : " + lazyMember);
			}
		}

	}

	@Override public void lazyEntityPrint() {
		// Lazy 엔티티를 호출하지 않으므로 @Transactional 어노테이션이 없어도 된다.
		List<Member> member = memberRepository.findAll();
		for (Member lazyMember : member) {
			System.out.println("===============================");
			System.out.println("## lazyMember : " + lazyMember);
		}
	}

	@Override public void deletContraintKey() {
		// team과 member간에 양방향 관계 constraint 를 삭제하기 위해 team을 지워준다.
		// member 는 부모의 키가 삭제 될때 같이 삭제 되어야 한다.
		departmentRepository.deleteAll();
		System.out.println("삭제 완료");

	}
}
