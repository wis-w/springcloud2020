package com.edu.springcloud.config;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 21:10
 * 使用seata进行创建
 */
//@Configuration
public class DataSourceProxyConfig {

//    @Value("${mybatis.mapperLocations}")
//    private String mapperLocations;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//
//    @Bean
//    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources(mapperLocations));
//        return bean.getObject();
//    }
}

