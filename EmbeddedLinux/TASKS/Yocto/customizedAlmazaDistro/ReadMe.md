under `yourlayer/conf/distro/almaza.conf`

include meta-poky/conf/distro/poky.conf

and configure the Distro 

```
includ meta-poky/conf/distro/poky.conf 

DISTRO = "almaza"
DISTRO_NAME = "Almaza"
#DISTRO_VERSION = "3.4+snapshot-${METADATA_REVISION}"
DISTRO_VERSION = "4.0.20"
DISTRO_CODENAME = "kirkstone"


MAINTAINER = "elgaarxyz@gmail.com"

```

change distro name in `poky/build/conf/local.conf`


### ping script 

```
 #!/bin/sh


PIN_NUMB=17
IP_ADDRESS=192.168.1.6

if [[ ! -d /sys/class/gpio/gpio${PIN_NUMB} ]];then

echo ${PIN_NUMB} > /sys/class/gpio/export
sleep 1
echo "out" > /sys/class/gpio/gpio$PIN_NUMB}/direction 

fi

sleep 1

if ping -c 3 "${IP_ADDRESS}" ;then
echo 0 > /sys/class/gpio/gpio${PIN_NUMB}/value
else
echo 1 > /sys/class/gpio/gpio${PIN_NUMB}/value
fi
```
