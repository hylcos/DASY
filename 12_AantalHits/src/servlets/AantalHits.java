package servlets;

//AantalBezoekers.java

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AantalHits extends HttpServlet {
	private int aantal = 0;
	PrintWriter writer2;
	FileReader file;

	public void init() throws ServletException {
		super.init();
		log("servlet init");
		try {
			String line;
			BufferedReader br = new BufferedReader(new FileReader("D:\\value.txt"));
			line = br.readLine();		
			System.out.println(line);
			aantal = Integer.parseInt(line);
			System.out.println("Opened a file");
		} catch (Exception e) {
			System.out.println(e);
			try {
				PrintWriter writer = new PrintWriter("D:/value.txt", "UTF-8");
				writer.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		try {
			writer2 = new PrintWriter("D:/value.txt", "UTF-8");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void destroy() {
		log("servlet destroy");
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String s1 = "<html>\n" + "   <head>\n" + "       <title>\n" + "          Aantal hits page\n"
				+ "       </title>\n" + "   </head>\n" + "   <body bgcolor=\"#8AAFED\">\n" + "      <center>\n"
				+ "         <h1>\n";

		String s2 = "";
		synchronized (this) {
			s2 = "            Aantal hits: " + ++aantal + "\n";
			writer2 = new PrintWriter("D:/value.txt", "UTF-8");
			writer2.write(Integer.toString(aantal));
			writer2.close();
			
		}
		String s3 = "         </h1>\n" + "      </center>\n" + "   </body>\n" + "</html>\n";
		out.print(s1 + s2 + s3);

	}
}
