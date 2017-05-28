package by.ntck.sten.service.impls;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IAjaxAutocompleteDao;
import by.ntck.sten.dao.IUserDao;
import by.ntck.sten.service.IAjaxAutocompleteService;

@Service
@Transactional
public class AjaxAutocompleteServiceImpl implements IAjaxAutocompleteService {

	private IAjaxAutocompleteDao dao;

	public void setDao(IAjaxAutocompleteDao dao) {
		this.dao = dao;
	}

	@Override
	public Set<String> getAutocompleteDocByType(String docType) {
		return dao.getAutocompleteDocByType(docType);
	}

}
