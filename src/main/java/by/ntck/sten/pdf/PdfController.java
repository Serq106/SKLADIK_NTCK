package by.ntck.sten.pdf;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.SkladH;
import by.ntck.sten.service.ISkladHService;

@Controller
@RequestMapping("sklad")
public class PdfController {
    private ISkladHService skladHService;

    @Autowired(required = true)
    @Qualifier(value = "skladHService")
    public void setSkladHService(final ISkladHService skladHService) {
        this.skladHService = skladHService;
    }

    @RequestMapping(value = "/pdf")
    public String sklad_kladovschik(/* @PathVariable("id") int id, */ final Model model, final HttpServletRequest request,
            final HttpServletResponse response) {
        model.addAttribute("kladovshik", new Kladovshik());

        int sklad_id = ((Sklad) request.getSession().getAttribute("sklad")).getId_sklad();
        try {

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C://PDF2.pdf"));
            final String FONT = "c:/windows/fonts/arial.ttf";
            BaseFont baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, true);
            Font font = new Font(baseFont);
            document.open();
            Paragraph paragraph = new Paragraph("Отчет прихода", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            List<SkladH> skladH_out = skladHService.Count_uzdel(0, sklad_id);

            for (SkladH skladH : skladH_out) {
                Paragraph paragraph1 = new Paragraph("id склада " + skladH.getSklad().getId_sklad()
                        + " название изделия " + skladH.getNaim() + " количества " + skladH.getKol_vo(), font);
                paragraph1.setAlignment(Element.ALIGN_LEFT);
                document.add(paragraph1);

            }

            document.close();
            writer.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "redirect:/skladH/skladsH/" + sklad_id;
    }
}
