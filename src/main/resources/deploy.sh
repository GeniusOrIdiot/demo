#!/usr/bin/env bash
PID="./logs/java.pid"
CATALINA_BASE=`pwd`

JAVA_HOME=/apps/java/jdk1.8.0_91
$JAVA_HOME/bin/java -version

if [ ! -d "webapp" ]; then
    mkdir webapp
fi
if [ ! -d "config" ]; then
    mkdir config
    cp /apps/template/env.conf ./config/
fi
if [ ! -d "logs" ]; then
    mkdir logs
fi

JAVA_OPTS=`sed 's/"//g' ./config/env.conf |awk '/^[^#]/'| tr "\n" ' '`

echo "=============================="
echo "CATALINA_BASE:$CATALINA_BASE"
echo "JAVA_OPTS:$JAVA_OPTS"
echo "=============================="

case $1 in
start)
    echo "Starting application ... "
    if [ -f "$PID" ]; then
      if kill -0 `cat "$PID"` > /dev/null 2>&1; then
        echo $command already running as process `cat "$PID"`.
        exit 0
      fi
    fi
    $JAVA_HOME/bin/java $JAVA_OPTS -DCATALINA_BASE=$CATALINA_BASE -jar application.war --spring.config.location=./config/application.yml --logging.config=./config/logback.xml > ./logs/console.log  &
    if [ $? -eq 0 ]
    then
      if /bin/echo -n $! > "$PID"
      then
        sleep 1
        echo "application started"
      else
        echo "application started,but can't write pid file!"
        exit 1
      fi
    else
      echo "server did not start!"
      exit 1
    fi
    ;;
update)
    echo "update application ... "

    APPNAME=`ls -ltr webapp|tail -n 1|awk '{print $9}'`

    if [ ! -f "./webapp/$APPNAME" ]; then
    	echo "no application in ./webapp dir ! please upload first!"
    	exit 1
    else
    	ln -sf ./webapp/$APPNAME application.war
    fi
    echo "update application complete "
    ;;
stop)
    echo "Stopping application ... "
    if [ ! -f "$PID" ]
    then
      echo "no application to stop (could not find file $PID)"
    else
      kill $(cat "$PID")
      rm "$PID"
      echo "application stoped"
    fi
    exit 0
    ;;
restart)
    shift
    sh "$0" stop ${@}
    sleep 3
    sh "$0" start ${@}
    ;;
*)
  echo "Usage: $0 {start|stop|restart|update}"

esac