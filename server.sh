#!/bin/bash

window=false
if [ "$OSTYPE" = "msys" ] ; then
  window=true;
elif [[ "$OSTYPE" == "cygwin" ]]; then
  window=true;
elif [[ "$OSTYPE" == "win32" ]]; then
  window=true;
fi

function has_opt() {
  OPT_NAME=$1
  shift
  #Par the parameters
  for i in "$@"; do
    if [[ $i == $OPT_NAME ]] ; then
      echo "true"
      return
    fi
  done
  echo "false"
}

bin=`dirname "$0"`
bin=`cd "$bin"; pwd`

JAVACMD="$JAVA_HOME/bin/java"

function start() {
  CLEAN_OPT=$(has_opt "-clean" $@ )
  echo "Clean: $CLEAN_OPT"
  if [ "$CLEAN_OPT" = "true" ]
  then
   gradle clean
  fi
  gradle build
  exec "$JAVACMD" -jar ./build/libs/training-spring-0.0.1-SNAPSHOT.jar
}

function stop() {
  STOP_OPT=$(has_opt "-stop" $@ )
  PID=`cat $PID_FILE`
  kill -9 $PID
  echo "Stopped processs $PID"
}

COMMAND=$1;
shift

if [ "$COMMAND" = "start" ] ; then
  start $@
elif [ "$COMMAND" = "stop" ] ; then
  stop $@
else
  echo "Usage: "
  echo "  To start the server"
  echo "    ./server.sh start "
  echo "  To stop the daemon server"
  echo "    ./server.sh -stop "
fi
