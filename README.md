# spring-boot-all

- spring-boot-dynamic-datasource
- spring-boot-unified-response

## spring-boot-dynamic-datasource

Dynamic Route DataSource to Create SqlSessionFactory with custom Annotation.

- Configure Druid(or Hikari) for DataSource.

- Extends AbstractRoutingDataSource and Override determineCurrentLookupKey().

- Configure Mybatis to Create SqlSessionFactory.

- Create custom Annotation(@Dynamic) with DataSource key.

- Configure AOP to Intercept @Dynamic and set value to ThreadLocal.

- Use @Dynamic to mark @Service method.

## spring-boot-unified-response

Unified Global ResponseBody for different Result with custom Exception.

- Create unified and global response Entity and Enum.

- Extends RuntimeException to Create Custom Exception.

- Use @ControllerAdvice and @ExceptionHandler to Intercept Exception.class.

- Assemble response Entity with different Exception Instance.

- Return success or error ResponseBody.