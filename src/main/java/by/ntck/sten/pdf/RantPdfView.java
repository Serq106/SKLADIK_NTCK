package by.ntck.sten.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import by.ntck.sten.model.User;


public class RantPdfView extends AbstractPdfView {
		public void buildPdfDocument(Map model, Document document, PdfWriter pdfWriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//List rants = (List) model.get("rants");
	/*	Table rantTable = new Table(4); // Создание таблицы
		rantTable.setWidth(90);
		rantTable.setBorderWidth(1);
		rantTable.addCell("State"); // Добавление строки заголовков
		rantTable.addCell("Plate");
		rantTable.addCell("Date Posted");
		rantTable.addCell("Text");
		*/
		List<User> users = new ArrayList<>();
		users.add(new User("as","asda"));
		users.add(new User("123","asda333"));
		users.add(new User("a3333s","asda"));
		users.add(new User("a2222222s","a222sda"));
		
		 document.open();
		 
		Paragraph paragraph = new Paragraph("This is right aligned text");
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        // Centered
        for(User user :users){       

        	 paragraph = new Paragraph("login :"+ user.getLogin());
        	 
             paragraph.setAlignment(Element.ALIGN_CENTER);
             paragraph = new Paragraph("User :"+ user.getFullname());
             paragraph.setAlignment(Element.ALIGN_CENTER);
             
        }
        document.add(paragraph);
        // Left
        paragraph = new Paragraph("This is left aligned text");

        
        document.add(paragraph);
        document.close();

 /*
        
		for (User user : users) {
			
			rantTable.addCell(user.getLogin());
			rantTable.addCell(user.getFullname()); // каждого
			
		}
		document.add(rantTable);*/
	}
	
	
	
	
	public static void main(String[] args) {
	
	}
	
}