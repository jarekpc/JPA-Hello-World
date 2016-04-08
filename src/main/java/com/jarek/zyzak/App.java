package com.jarek.zyzak;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldCPU");
    	//
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	Message m = new Message();
    	m.setText("mmm");
    	em.persist(m);
    	em.getTransaction().commit();
    	em.close();
    	
    	listAll(emf);//
    }
    
    public static void listAll(EntityManagerFactory emf ){
    	System.out.println("ListAll");
    	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldCPU");
    	//
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	List<Message> messages = em.createQuery("select m from Message m").getResultList();
    	if(messages.isEmpty()){
    		System.out.println("Lista pusta!");
    	}
    	else {
    		System.out.println("Lista pe³na!");
    	}
    	for(Message m: messages){
    		System.out.println(m.getText());
    	}
    	em.getTransaction().commit();
    	em.close();
    }
}
