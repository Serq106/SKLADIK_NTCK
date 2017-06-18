package by.ntck.sten.service.impls;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IAjaxAutocompleteDao;
import by.ntck.sten.service.IAjaxAutocompleteService;

@Service
@Transactional
public class AjaxAutocompleteServiceImpl implements IAjaxAutocompleteService {

    private IAjaxAutocompleteDao dao;

    public void setDao(final IAjaxAutocompleteDao dao) {
        this.dao = dao;
    }

    @Override
    public Set<String> getAutocompleteDocByType(final String docType) {
        return dao.getAutocompleteDocByType(docType);
    }

    @Override
    public Set<String> getAutocompleteDocBySklad(String docType) {
        return dao.getAutocompleteDocBySklad(docType);
    }

    @Override
    public Set<String> getAutocompleteNaimenovanie(String name) {       
        return dao.getAutocompleteNaimenovanie(name);
    }

}
