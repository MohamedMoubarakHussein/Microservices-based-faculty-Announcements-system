FROM mysql

ENV MYSQL_ROOT_PASSWORD=1234

EXPOSE 2060

# mysql deamon used as main process in container
CMD ["mysqld"]
