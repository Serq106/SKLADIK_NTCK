package by.ntck.sten.dao;

import java.util.List;

import by.ntck.sten.model.SkladH;

public interface ISkladHDao extends IDAO<SkladH> {
	
	public List<SkladH> skladHById(int sklad_id);
	
	public SkladH Kol(int id);

}
