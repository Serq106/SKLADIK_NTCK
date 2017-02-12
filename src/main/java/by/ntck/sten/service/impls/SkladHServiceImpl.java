package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.ISkladHDao;
import by.ntck.sten.model.SkladH;
import by.ntck.sten.service.ISkladHService;

@Service
@Transactional
public class SkladHServiceImpl implements ISkladHService {
	private ISkladHDao daoSkladH;	

	public void setDaoSkladH(ISkladHDao dao) {
		this.daoSkladH = dao;
	}
	@Override
	
	public void add(SkladH skladH) {
		this.daoSkladH.add(skladH);		
	}

	@Override
	public void update(SkladH skladH) {
		this.daoSkladH.update(skladH);		
	}

	@Override
	public void remove(int id) {
		this.daoSkladH.remove(id);		
	}

	@Override
	public SkladH getById(int id) {
		return this.daoSkladH.getById(id);
	}

	@Override
	public List<SkladH> list() {
		return this.daoSkladH.list();
	}
	@Override
	public List<SkladH> skladHById(int sklad_id) {
		return this.daoSkladH.skladHById(sklad_id);
	}
	@Override
	public SkladH Kol(int id){
		return this.daoSkladH.Kol(id);
		
	}
	@Override
	public Double Count(int id_klad) {		
		return this.daoSkladH.Count(id_klad);
	}
}