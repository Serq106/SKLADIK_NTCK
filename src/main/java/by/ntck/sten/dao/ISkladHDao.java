package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.SkladH;

public interface ISkladHDao extends IDAO<SkladH> {

    List<SkladH> skladHById(int skladId);

    SkladH Kol(int id);

    Double Count(int id_klad, int id_sklad);

    List<SkladH> Count_uzdel(int id_klad, int id_sklad);

}
