package by.ntck.sten.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.ntck.sten.dao.IUserDao;
import by.ntck.sten.model.User;
import by.ntck.sten.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private IUserDao dao;

    public void setDao(final IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(final User user) {
        // this.dao.add(user);
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(final User user) {
        // this.dao.update(user);
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(final int id) {
        // this.dao.remove(id);
        throw new UnsupportedOperationException();
    }

    @Override
    public User getById(final int id) {
        return (User) this.dao.getById(id);
    }

    @Override
    public List<User> list() {
        return this.dao.list();
    }
}
