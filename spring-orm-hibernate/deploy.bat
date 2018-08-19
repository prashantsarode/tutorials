clear
del C:\apache-tomcat-7.0.90\webapps\spring-orm-hibernate.war
rmdir C:\apache-tomcat-7.0.90\webapps\spring-orm-hibernate /s /q
copy C:\Projects\tutorials\spring-orm-hibernate\target\spring-orm-hibernate.war C:\apache-tomcat-7.0.90\webapps\
cd C:\apache-tomcat-7.0.90\logs\
del * /q
cd C:\apache-tomcat-7.0.90\bin
./startup.bat