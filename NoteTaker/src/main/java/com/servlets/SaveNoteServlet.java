package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SaveNoteServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//tittle content fetch
			
			String tittle = request.getParameter("tittle");
			String content = request.getParameter("content");
			
			/*-------------Creating Note object------------------*/
			Note note = new Note (tittle,content,new Date());
			
			//save data into database using Hibernate
			//hibernate:save
			
			//Get factory
		   SessionFactory factory =FactoryProvider.getFactory();
          
		   //next step to do open session
		   Session s = factory.openSession();
		   
		   //next step to start the transaction to save data permanantly
		   Transaction tx = s.beginTransaction();
		  
		   s.save(note);
		  
		   tx.commit();
		   
		   s.close();
		   
		   //for printing on browser
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   out.println("<h1 style='text-align:center;'>Note is added Successfully!!<h1>");
		   out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes<h1>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
