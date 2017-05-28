package by.ntck.sten.dao;

import java.util.List;
import java.util.Set;

public interface IAjaxAutocompleteDao {
	Set<String> getAutocompleteDocByType(String docType);
}
