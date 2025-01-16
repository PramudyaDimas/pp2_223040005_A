package dao;

import model.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.MyBatisUtil;

import java.util.List;

public class MemberDao {
    private final SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

    public List<Member> selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("mapper.MemberMapper.selectAll");
        }
    }

    public Member selectById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("mapper.MemberMapper.selectById", id);
        }
    }

    public void insert(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("mapper.MemberMapper.insert", member);
            session.commit();
        }
    }

    public void update(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("mapper.MemberMapper.update", member);
            session.commit();
        }
    }

    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("mapper.MemberMapper.delete", id);
            session.commit();
        }
    }
}