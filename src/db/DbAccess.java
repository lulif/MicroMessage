package db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//�������ݿ���
public class DbAccess {
public SqlSession getSqlSession() throws IOException {
	//ͨ�������ļ���ȡ���ݿ����������Ϣ
	Reader reader=Resources.getResourceAsReader("config/Configuration.xml");
	//ͨ��������Ϣ����SqlSessionFactory
	SqlSessionFactory sqlSessionFacrory=new SqlSessionFactoryBuilder().build(reader);
	//ͨ��SqlSessionFactory�����ݿ�Ự
	SqlSession sqlSession=sqlSessionFacrory.openSession();
	return  sqlSession;
}
}
