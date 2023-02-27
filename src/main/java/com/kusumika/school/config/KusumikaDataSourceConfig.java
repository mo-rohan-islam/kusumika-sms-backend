package com.kusumika.school.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.kusumika.school.mapper.kusumikadb.KusumikaMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value = "com.kusumika.school.mapper.kusumikadb", sqlSessionFactoryRef = "kusumikaSqlSessionFactory")
public class KusumikaDataSourceConfig {

	@Bean
	@Primary
	public KusumikaMapper kusumikaMapper() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(kusumikaSqlSessionFactoryBean());
		return sessionTemplate.getMapper(KusumikaMapper.class);
	}
	
	@Bean(name = "kusumikaSqlSessionFactory")
	@Primary
	public SqlSessionFactory kusumikaSqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(kusumikaDataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/kusumikadb/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "kusumikaDataSource")
	@Primary
	public DataSource kusumikaDataSource() {
		return new HikariDataSource(kusumikaCustomHikariConfig());
	}
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "kusumika.datasource")
	public HikariConfig kusumikaCustomHikariConfig() {
		return new HikariConfig();
	}
}
