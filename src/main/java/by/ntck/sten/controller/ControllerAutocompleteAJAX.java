package by.ntck.sten.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import by.ntck.sten.service.IAjaxAutocompleteService;

@Controller
@RequestMapping("ControllerAutocompleteAJAX")
public class ControllerAutocompleteAJAX {
    private IAjaxAutocompleteService ajaxAutocompleteService;

    @Autowired(required = true)
    @Qualifier(value = "ajaxAutocompleteService")
    public void setBookService(final IAjaxAutocompleteService ajaxAutocompleteService) {
        this.ajaxAutocompleteService = ajaxAutocompleteService;
    }

    @ResponseBody
    @RequestMapping(value = "/doc-ajax-autocomplete", method = RequestMethod.GET)
    public void userData(final Model model, final HttpServletRequest request, final HttpServletResponse response) {

        String term = request.getParameter("term");

        response.setContentType("application/json");
        try {
            System.out.println("Data from ajax call " + term);

            Set<String> list = ajaxAutocompleteService.getAutocompleteDocByType(term);

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/doc-ajax-autocomplete-sklad", method = RequestMethod.GET)
    public void userDataSklad(final Model model, final HttpServletRequest request, final HttpServletResponse response) {

        String term = request.getParameter("term");

        response.setContentType("application/json");
        try {
            System.out.println("Data from ajax call " + term);

            Set<String> list = ajaxAutocompleteService.getAutocompleteDocByType(term);

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/doc-ajax-autocomplete-naimenovanie", method = RequestMethod.GET)
    public void autocompleteNaimenovanie(final Model model, final HttpServletRequest request, final HttpServletResponse response) {

        final String term = request.getParameter("term");

        response.setContentType("application/json");
        try {
            System.out.println("Data from ajax call " + term);

            Set<String> list = ajaxAutocompleteService.getAutocompleteDocBySklad(term);

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
