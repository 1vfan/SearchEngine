# spring-boot-all

- spring-boot-dynamic-datasource

## spring-boot-dynamic-datasource

Dynamic Route DataSource to Create SqlSessionFactory with custom Annotation.

- Configure Druid(or Hikari) for DataSource.

- Extends AbstractRoutingDataSource and Override determineCurrentLookupKey().

- Configure Mybatis to Create SqlSessionFactory.

- Create custom Annotation(@Dynamic) with DataSource key.

- Configure AOP to Intercept @Dynamic and set value to ThreadLocal.

- Use @Dynamic to mark @Service method.