package by.ntck.sten.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.User;
import by.ntck.sten.service.IAjaxAutocompleteService;
import by.ntck.sten.service.IService;

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
            // String term = request.getParameter("term");
            System.out.println("Data from ajax call " + term);

            Set<String> list = ajaxAutocompleteService.getAutocompleteDocByType(term);
            /*
             * new ArrayList<>(); list.addAll(Arrays.asList(new String[] { "qqqq", "234", "12312312" }));
             */

            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        /*
         * model.addAttribute("user", new User()); model.addAttribute("findUser", userService.getById(id)); return "user/user_data";
         */
    }
}
