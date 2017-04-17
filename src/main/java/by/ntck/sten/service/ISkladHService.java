package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.Sklad;
import by.ntck.sten.model.SkladH;

public interface ISkladHService extends IService<SkladH> {
	
	public List<SkladH> skladHById(int sklad_id);
	
	public SkladH Kol(int id);
	
	public Double Count(int id_klad, int id_sklad); 
	
	public List<SkladH> Count_uzdel(int id_klad, int id_sklad);

}
