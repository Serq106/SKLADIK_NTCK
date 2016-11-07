package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IKladovshikDao;
import by.ntck.sten.model.Kladovshik;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.service.IKladovshikService;

@Service
@Transactional
public class KladovshikServiceImpl implements IKladovshikService{
	private IKladovshikDao dao;

	public void setDao(IKladovshikDao dao) {
		this.dao = dao;
	}
		
	@Override
	public void add(Kladovshik kladovshik) {
		this.dao.add(kladovshik);		
	}

	@Override
	public void update(Kladovshik kladovshik) {
		this.dao.update(kladovshik);
	}

	@Override
	public void remove(int id) {
		 this.dao.remove(id);
	}

	@Override
	public Kladovshik getById(int id) {
		return this.dao.getById(id);
	}

	@Override
	public List<Kladovshik> list() {
		return this.dao.list();
	}
	
	@Override
	public Kladovshik login(String login, String password) {
		return this.dao.login(login, password);
	}

	@Override
	public List<Kladovshik> kladovshikBySklad(int id_sklad) {		
		return this.dao.kladovshikBySklad(id_sklad);
	}

	@Override
	public List<Sklad> SkladBykladovshik(int id_kladovshok) {
		return this.dao.SkladBykladovshik(id_kladovshok);
	}
}

