package by.ntck.sten.pdf;

import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import by.ntck.sten.model.Kladovshik;

@Controller
public class PdfController {
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public @ResponseBody String sklad_kladovschik(/*@PathVariable("id") int id,*/ Model model, HttpServletRequest request, HttpServletResponse response){
			model.addAttribute("kladovshik", new Kladovshik());
		
		
		
	//	model.addAttribute("findUser", id_kladovshik);
		RantPdfView r = new RantPdfView();
		try {
			
			Document document = new Document();
			
			PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream("C://PDF.pdf"));
			r.buildPdfDocument( new HashMap<>(model.asMap()), document, writer, request, response);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sklad/sklads";
	}
}
