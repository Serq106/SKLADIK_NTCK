package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.Sklad;

public interface ISkladService extends IService<Sklad> {
    List<Sklad> skladSearch(int sklad_id);
}
