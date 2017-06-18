package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

public interface IKladovshikService extends IService<Kladovshik> {
    Kladovshik login(String login, String password);

    List<Sklad> SkladBykladovshik(int id_kladovshok);

    List<Sklad> SkladBykladovshikSearch(int id_kladovshok, int index, String naim);

    String getRole(int id);
}
