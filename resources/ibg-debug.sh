#! /bin/bash

#TWSUSERID=jack0121
TWSUSERID=zjhcxx322
#TWSPASSWORD=jacktang009
TWSPASSWORD=zjhc1234567
TWSAPIPORT=4001
IBCTRLPORT=7462

TWSDIR=../lib/ibg-b963
TWSCP=$TWSDIR/jts4launch-963.jar:$TWSDIR/locales.jar:$TWSDIR/log4j-api-2.5.jar:$TWSDIR/log4j-core-2.5.jar:$TWSDIR/total-2015c.jar:$TWSDIR/twslaunch-963.jar:$TWSDIR/twslaunch-install4j-1.8.jar
IBCINI='./IBController.ini'
JAVAOPTS='-Xmx768M -XX:MaxPermSize=256M'

~/Applications/IB\ Gateway\ 963/.install4j/jre.bundle/Contents/Home/jre/bin/java -cp  $TWSCP:./IBController-3.3.0-ibg-b963.jar $JAVAOPTS ibcontroller.IBGatewayController $IBCINI $TWSUSERID $TWSPASSWORD $TWSAPIPORT paper
