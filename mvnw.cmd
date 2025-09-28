@ECHO OFF
setlocal
set BASE_DIR=%~dp0
set WRAPPER_JAR=%BASE_DIR%\.mvn\wrapper\maven-wrapper.jar
set MAVEN_PROJECTBASEDIR=%BASE_DIR%

"%JAVA_HOME%\bin\java" -Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR% -cp %WRAPPER_JAR% org.apache.maven.wrapper.MavenWrapperMain %*
