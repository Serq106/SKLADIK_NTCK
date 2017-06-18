package by.ntck.sten.dao;

import java.util.Set;

public interface IAjaxAutocompleteDao {
    Set<String> getAutocompleteDocByType(String docType);
    
    Set<String> getAutocompleteDocBySklad(String docType);

    Set<String> getAutocompleteNaimenovanie(String name);
}
