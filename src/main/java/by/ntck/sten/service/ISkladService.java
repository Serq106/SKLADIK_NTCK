package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

public interface ISkladService extends IService<Sklad>{
	public List<Kladovshik> kladovshikBySklad(int id_sklad);
}
