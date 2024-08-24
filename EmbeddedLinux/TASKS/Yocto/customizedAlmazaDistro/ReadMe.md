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

script explantation :

it is a sh script that takes a gpio pin and a IP address to ping on and see if it is avaliable on network 

the script checks if the gpio pin is exported if not it exports it and sets pin direction to out 

then tries to ping on IP 3 times if failed to ping sets gpio pin to high else sets to low 

now we need to create our reciepe to include this script to our rfs 

```
SUMMARY = "meta -iti layers recipe"
DESCRIPTION = "a simple sh script to turn led on if failed to ping"

LICENSE = "CLOSED"

SRC_URI = "file://${THISDIR}/pingscript.sh"
FILESPATH:append = " /home/mohamed/Desktop/Yocto/meta-iti/recipes-pingled/pingled/"
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE = "myservice.service"

do_install (){
    mkdir -p /home/mohamed/Desktop/Yocto/poky/build/tmp-glibc/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/pingled/1.0-r0/image/usr/bin/
    cp ${THISDIR}/pingscript.sh ${D}${bindir}/
    install -d ${D}/${sysconfdir}/systemd/system/
    install -m 0755 ${THISDIR}/myservice.service ${D}/${sysconfdir}/systemd/system/
}




```

systemd service 

myservice.service 

```
[Unit]


[Service]
Type=simple
ExecStart=/usr/bin/pingled.sh
Restart=always


[Install]
WantedBy=multi-user.target

```

now `bitbake -k core-image-sato` and test the output on raspberrypi
