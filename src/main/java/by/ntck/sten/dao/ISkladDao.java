package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.Sklad;

public interface ISkladDao extends IDAO<Sklad> {
    List<Sklad> skladSearch(int sklad_id);
}
