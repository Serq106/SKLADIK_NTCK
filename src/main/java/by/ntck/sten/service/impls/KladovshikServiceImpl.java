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
public class KladovshikServiceImpl implements IKladovshikService {
    private IKladovshikDao dao;

    public void setDao(final IKladovshikDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(final Kladovshik kladovshik) {
        this.dao.add(kladovshik);
    }

    @Override
    public void update(final Kladovshik kladovshik) {
        this.dao.update(kladovshik);
    }

    @Override
    public void remove(final int id) {
        this.dao.remove(id);
    }

    @Override
    public Kladovshik getById(final int id) {
        return this.dao.getById(id);
    }

    @Override
    public List<Kladovshik> list() {
        return this.dao.list();
    }

    @Override
    public Kladovshik login(final String login, final String password) {
        return this.dao.login(login, password);
    }

    @Override
    public List<Sklad> SkladBykladovshik(final int id_kladovshok) {
        return this.dao.skladByKladovshik(id_kladovshok);
    }

    @Override
    public String getRole(final int id) {
        return this.dao.getRole(id);
    }

    @Override
    public List<Sklad> SkladBykladovshikSearch(final int id_kladovshok, final int index, final String naim) {
        return this.dao.skladByKladovshikSearch(id_kladovshok, index, naim);
    }

}
