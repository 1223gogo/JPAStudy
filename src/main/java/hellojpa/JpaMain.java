package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			/*update*/
			//Member findmember = em.find(Member.class, 1L);
			//findmember.setName("HelloJPA");
			/*read*/
			//Member findmember = em.find(Member.class, 1L);
			//18 살 이상인 회원 모두 조회 -->JPQL
			//엔티티 객체를 대상으로 검색하는 객체 지향 쿼리
			em.createQuery("select m from Member as m", Member.class)
					.getResultList();
			/*insert*/
			/*Member member = new Member();
			member.setId(1L);
			member.setName("HelloA");
			em.persist(member);*/
			/*delete*/
			//Member findmember = em.find(Member.class, 1L);
			//em.remove(findmember);
			//설정을 바꿈으로써 배치방식으로 사용가능
			//flush(), SQL 실행됨(원래 트랜잭션 커밋 시 실행됨)
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
