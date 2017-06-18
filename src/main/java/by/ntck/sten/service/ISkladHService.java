package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.SkladH;

public interface ISkladHService extends IService<SkladH> {

    List<SkladH> skladHById(int sklad_id);

    SkladH Kol(int id);

    Double Count(int id_klad, int id_sklad);

    List<SkladH> Count_uzdel(int id_klad, int id_sklad);

}
