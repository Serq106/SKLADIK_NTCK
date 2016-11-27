package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.SkladH;

public interface ISkladHService extends IService<SkladH> {
	
	public List<SkladH> skladHById(int sklad_id);
	
	public SkladH Kol(int id);

}
