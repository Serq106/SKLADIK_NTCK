package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

public interface ISkladDao extends IDAO<Sklad> {
	public List<Kladovshik> kladovshikBySklad(int id_sklad);
}
