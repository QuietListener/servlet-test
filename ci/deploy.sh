source ~/.bash_profile

cp -r   /Users/junjun/Documents/项目/java/bcz_online/servlet-test/target/classes/servlet-1/web.xml  /Users/junjun/Documents/安装程序/免安装版/apache-tomcat-7.0.96/webapps/servlet-1/WEB-INF/
cp -r   /Users/junjun/Documents/项目/java/bcz_online/servlet-test/target/classes /Users/junjun/Documents/安装程序/免安装版/apache-tomcat-7.0.96/webapps/servlet-1/WEB-INF/
cp  /Users/junjun/Documents/项目/java/bcz_online/servlet-test/src/main/resources/jsp/* /Users/junjun/Documents/安装程序/免安装版/apache-tomcat-7.0.96/webapps/servlet-1/

cd /Users/junjun/Documents/安装程序/免安装版/apache-tomcat-7.0.96/
./bin/shutdown.sh & ./bin/startup.sh