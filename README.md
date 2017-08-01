# Installation guide:

# 1. Install Maven.
# 2. Install Tomcat.
# 2.1 Add tomcat roles (%CATALINA_HOME%\conf\tomcat-users.xml):

#      <role rolename="manager-gui"/>
#      <role rolename="manager-script"/>
#      <role rolename="manager-jmx"/>
#      <role rolename="manager-status"/>

# 2.2 Add tomcat users (%CATALINA_HOME%\conf\tomcat-users.xml):

#      <user username="manager-gui" password="manager-gui" roles="manager-gui"/>
#      <user username="manager-jmx" password="manager-jmx" roles="manager-jmx"/>
#      <user username="manager-status" password="manager-status" roles="manager-status"/>
#      <user username="manager-script" password="manager-script" roles="manager-script"/>
#      <user username="admin" password="admin" roles="manager-script,manager-gui,manager-status,manager-jmx"/>

# 3. Install MySQL Server.

# 4. Migrate DB structure in MySQL CLI using command:
#      source %YOUR_PROJECT_ROOT%/src/main/db/01_db_structure.sql

# 5(Optional). Migrate sample DB data in MySQL CLI using command:
#      source %YOUR_PROJECT_ROOT%/src/main/db/01_db_structure.sql

# 6. Open project in IDE and create Maven's local settings.xml file. Populate it with the next info:

#      <?xml version="1.0" encoding="UTF-8"?>
#      <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
#                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
#                xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
#      
#          <pluginGroups>
#              <pluginGroup>org.apache.tomcat.maven</pluginGroup>
#          </pluginGroups>
#          <servers>
#              <server>
#                  <id>tomcat7</id>
#                  <username>admin</username> // or any other tomcat user with role 'manager-script'
#                  <password>admin</password>
#              </server>
#          </servers>
#      
#      </settings>

# 7. Start up tomcat using:

#      %CATALINA_HOME%\bin\startup.bat
#      
#      OR
#      
#      %CATALINA_HOME%\bin\catalina.bat start
#      
#      OR (DEBUG mode)
#      
#      %CATALINA_HOME%\bin\catalina.bat jpda start