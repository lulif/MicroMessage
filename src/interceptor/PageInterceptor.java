package interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import entity.Page;

/**
 * ��ҳ������
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {
	
	private String test;
	
	@Override
	public void setProperties(Properties properties) {
		//�������ļ����ֵ
	
		this.test = properties.getProperty("test");	
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		// �����ļ���SQL����ID		
		String id = mappedStatement.getId();
		if(id.matches(".+ByPage$")) {
			BoundSql boundSql = statementHandler.getBoundSql();
			// ԭʼ��SQL���
			String sql = boundSql.getSql();
			// ��ѯ��������SQL���
			String countSql = "select count(*) from (" + sql + ")a";
			Connection connection = (Connection)invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			//��ȡ��sql������������
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			//countStatement��Ϊ��sql��������������
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();
			//��ȡ���ò���
			Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
			Page page = (Page)parameter.get("page");
			if(rs.next()) {
				//Ϊpage����������ֵ
				page.setTotalNumber(rs.getInt(1));
			}
			// ��������ҳ��ѯ��SQL���
			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}
}



