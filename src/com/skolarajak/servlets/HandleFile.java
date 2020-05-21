package com.skolarajak.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet(value = "/vezba-servleti/handleFile.html")
@MultipartConfig
public class HandleFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final int ARBITARY_SIZE = 1048;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = request.getParameter("name");
		
		response.setContentType("image/jpeg");
		//response.setHeader("Content-disposition", "attachment; filename="+fileName);
 

        try(InputStream in = new FileInputStream(new File("c:/tempv/"+fileName));
          OutputStream out = response.getOutputStream()) {
 
            byte[] buffer = new byte[ARBITARY_SIZE];
         
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    System.out.println(description);
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    
	    byte[] buffer = new byte[fileContent.available()];
	    fileContent.read(buffer);
	 
	    File targetFile = new File("c:/tempv/"+fileName);
	    OutputStream outStream = new FileOutputStream(targetFile);
	    outStream.write(buffer);
	    
	}

}
