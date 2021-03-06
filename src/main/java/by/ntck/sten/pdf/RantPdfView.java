package by.ntck.sten.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import by.ntck.sten.service.ISkladHService;

public class RantPdfView extends AbstractPdfView {

    private ISkladHService skladHService;

    @Autowired(required = true)
    @Qualifier(value = "skladHService")
    public void setSkladHService(final ISkladHService skladHService) {
        this.skladHService = skladHService;
    }

    public void buildPdfDocument(final Map model, final Document document, final PdfWriter pdfWriter, final HttpServletRequest request,
            final HttpServletResponse response) throws Exception {
        final String FONT = "c:/windows/fonts/arial.ttf";
        BaseFont baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, true);
        Font font = new Font(baseFont);
        skladHService.getById(1).getNaim();
        String String1 = "asdasd";
        document.open();
        Paragraph paragraph = new Paragraph(String1, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        document.close();

        document.close();

    }

}
