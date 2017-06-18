package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

public interface IKladovshikDao extends IDAO<Kladovshik> {

    Kladovshik login(String login, String password);

    List<Sklad> skladByKladovshik(int idKladovshok);

    List<Sklad> skladByKladovshikSearch(int id_kladovshok, int index, String naim);

    String getRole(int id);

}
