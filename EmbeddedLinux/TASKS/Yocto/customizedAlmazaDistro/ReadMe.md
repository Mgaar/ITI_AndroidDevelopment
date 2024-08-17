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


