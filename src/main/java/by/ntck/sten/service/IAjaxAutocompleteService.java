package by.ntck.sten.service;

import java.util.Set;

public interface IAjaxAutocompleteService {
    Set<String> getAutocompleteDocByType(String docType);
    
    Set<String> getAutocompleteDocBySklad(String docType);
    
    Set<String> getAutocompleteNaimenovanie(String name);
    
    
}
