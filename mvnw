#!/bin/sh
# Apache Maven Wrapper startup script (simplified)
MVNW_REPOURL=""
BASE_DIR=$(cd "$(dirname "$0")"; pwd -P)
WRAPPER_JAR="$BASE_DIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_PROPERTIES="$BASE_DIR/.mvn/wrapper/maven-wrapper.properties"
MAVEN_PROJECTBASEDIR=${MAVEN_BASEDIR:-$BASE_DIR}

if [ -z "$JAVA_HOME" ]; then
  JAVA_CMD="java"
else
  JAVA_CMD="$JAVA_HOME/bin/java"
fi

exec "$JAVA_CMD" -Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR \
  -cp "$WRAPPER_JAR" org.apache.maven.wrapper.MavenWrapperMain "$@"
