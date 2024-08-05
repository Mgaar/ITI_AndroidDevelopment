go to `cd buildroot/package` to create the directory of your package `mkdir myapp`

first create your application 

`touch myapp.c`

a simple c program 

```

#include "stdio.h"

int main ()
{
printf("hello build root");

    return 0;
}

```
then we create the Config.in containing the snippet of Kconfig code required to make the package visible in the configuration menu

`mkdir Config.in`

```

config BR2_PACKAGE_myapp
bool "myapp"

help
simple program that prints Hello World! 

```

then we need the make file to tell build root how to compile our app 

`touch myapp.mk`

```
MYAPP_VERSION = 1.0
MYAPP_SITE = $(TOPDIR)/package/myapp
MYAPP_SITE_METHOD = local# Other methods like git,wget,scp,file etc. are also available.

define MYAPP_BUILD_CMDS
    $(MAKE) CC="$(TARGET_CC)" LD="$(TARGET_LD)" -C $(@D)
endef

define MYAPP_INSTALL_TARGET_CMDS
    $(INSTALL) -D -m 0755 $(@D)/myapp  $(TARGET_DIR)/usr/bin
endef

$(eval $(generic-package))

```
Next, link the new package into the Target Packages menu by editing
package/Config.in and sourcing the configuration file

and append 

```
menu "My programs"
source "package/myapp/Config.in"
endmenu
```

then when u `make menuconfig`

u will find a menu called "My programs"

under it there is your check box 

![Screenshot from 2024-08-06 02-27-38](https://github.com/user-attachments/assets/6ced0a2d-abda-43ed-8dc9-4348aa84f76f)
