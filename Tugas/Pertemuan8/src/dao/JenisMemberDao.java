package dao;

import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisUtil;

import java.util.List;

public class JenisMemberDao {
    private final SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

    public List<JenisMember> selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.JenisMemberMapper.selectAll");
        }
    }

    public JenisMember selectById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("mapper.JenisMemberMapper.selectById", id);
        }
    }

    public void insert(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("mapper.JenisMemberMapper.insert", jenisMember);
            session.commit();
        }
    }

    public void update(JenisMember jenisMember) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("mapper.JenisMemberMapper.update", jenisMember);
            session.commit();
        }
    }

    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("mapper.JenisMemberMapper.delete", id);
            session.commit();
        }
    }
}