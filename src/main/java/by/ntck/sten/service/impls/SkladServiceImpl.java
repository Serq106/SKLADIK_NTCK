package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.ISkladDao;
import by.ntck.sten.model.Sklad;
import by.ntck.sten.service.ISkladService;

@Service
@Transactional
public class SkladServiceImpl implements ISkladService {
    private ISkladDao daoSklad;

    public void setDaoSklad(final ISkladDao dao) {
        this.daoSklad = dao;
    }

    @Override
    public void add(final Sklad sklad) {
        this.daoSklad.add(sklad);
    }

    @Override
    public void update(final Sklad sklad) {
        this.daoSklad.update(sklad);
    }

    @Override
    public void remove(final int id) {
        this.daoSklad.remove(id);
    }

    @Override
    public Sklad getById(final int id) {
        return this.daoSklad.getById(id);
    }

    @Override
    public List<Sklad> list() {
        return this.daoSklad.list();
    }

    @Override
    public List<Sklad> skladSearch(final int sklad_id) {
        return this.daoSklad.skladSearch(sklad_id);
    }

}
