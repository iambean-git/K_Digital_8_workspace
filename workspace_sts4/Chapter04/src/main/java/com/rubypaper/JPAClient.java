package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public final class JPAClient {
	
	private static void insertQuery(EntityManagerFactory emf) {
		//EntityManager 생성
		EntityManager em = emf.createEntityManager();
		
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			
			
			for(int i=1; i<=10; i++) {
				//DB에 저장할 객체 생성
				Board board = new Board();
				board.setTitle("제목" + i);
				board.setWriter("작성자" + i);
				board.setContent(i+"번째 글입니다");
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				//글 등록
				em.persist(board);
			}
			
			// Transaction commit
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			
			//Transaction rollback
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	private static void searchQuery(EntityManagerFactory emf, long num) {
		//EntityManager 생성
		EntityManager em = emf.createEntityManager();
		
		try {
			Board searchBoard = em.find(Board.class, num);
			System.out.println("--->" + searchBoard.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	private static void searchJPQL(EntityManagerFactory emf) {
		//EntityManager 생성
		EntityManager em = emf.createEntityManager();
				
		try {
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board brd : boardList) {
				System.out.println("---> " + brd.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void main(String[] args) {
		
		//EntityManagerFactor 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		//insertQuery(emf);		//삽입
		//searchQuery(emf, 2L);	//검색
		searchJPQL(emf);
		emf.close();
	}
}
