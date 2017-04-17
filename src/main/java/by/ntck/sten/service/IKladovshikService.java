package by.ntck.sten.service;

import java.util.List;

import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;

public interface IKladovshikService extends IService<Kladovshik>{
	public  Kladovshik login(String login, String password);
		
	public List<Sklad> SkladBykladovshik(int id_kladovshok);

	public String getRole(int id);
}
