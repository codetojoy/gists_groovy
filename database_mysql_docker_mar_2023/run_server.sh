docker run -d --name my-standalone-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=abc123 mysql:5.7.41-debian --default-authentication-plugin=mysql_native_password
