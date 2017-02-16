TWSUSERID=ibzzy123
TWSPASSWORD=ibzzy1234
TWSAPIPORT=4001
IBCTRLPORT=7462

TWSDIR=../lib/ibg-b963
TWSCP=$TWSDIR/log4j-core-2.5.jar:$TWSDIR/log4j-api-2.5.jar:$TWSDIR/twslaunch-963.jar:$TWSDIR/jts4launch-963.jar:$TWSDIR/rss.jar:$TWSDIR/hsqldb.jar:$TWSDIR/httpcore-4.3.jar:$TWSDIR/httpclient-4.3.jar:$TWSDIR/total.2015c.jar
IBCINI='./IBController.ini'
JAVAOPTS='-Xmx768M -XX:MaxPermSize=256M'

java -cp  $TWSCP:./IBController-3.2.0-ibg-b963.jar $JAVAOPTS ibcontroller.IBGatewayController $IBCINI $TWSUSERID $TWSPASSWORD $TWSAPIPORT paper
