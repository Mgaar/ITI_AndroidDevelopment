first install busy box

`git clone https://github.com/mirror/busybox.git`

`cd busybox`

`export CROSS_COMPILE=path/to/compiler/arm-cortexa9_neon-linux-musleabihf-`

`export ARCH=arm`

`make menuconfig`

to make sure it is staticly compiled then `make` and `make install`

output : `file busybox`

busybox: ELF 32-bit LSB executable, ARM, EABI5 version 1 (SYSV), statically linked, stripped

You will probably need to make your busybox binarysetuid root to ensure all configured applets will work properly.'


![Screenshot from 2024-07-28 00-13-53](https://github.com/user-attachments/assets/e75bd772-4f97-49fd-9bbe-599aaced2da0)

now make a local directory to prepare the root file system on it before copying it to sd card 

`mkdir staticrootfs`

then make the root directories 

copy the directories under _install 

and `mkdir boot dev etc home mnt proc root srv sys`

copy the so libraries from cross tool sysetm root 

~/x-tools/arm-cortexa9_neon-linux-musleabihf/arm-cortexa9_neon-linux-musleabihf/sysroot/lib

~/x-tools/arm-cortexa9_neon-linux-musleabihf/arm-cortexa9_neon-linux-musleabihf/sysroot/usr

we need to mount the proc and sys 

`ll use the busy box init process to automate those mounting every time 

under etc make configure file inittab file 

```
{
 # inittab file 
#-------------------------------------------------------
#When system startup,will execute "rcS" script
::sysinit:/etc/init.d/rcS
#Start"askfirst" shell on the console (Ask the user firslty to press any key) 
ttyAMA0::askfirst:-/bin/sh
#when restarting the init process,will execute "init" 
::restart:/sbin/init
}
```

the inittab file is a configuration file to the initprocess located at /sbin/init 

the init script called by this file is rcS script /etc/init.d/rcS

we will use this script to mount sys and proc 


```
{
#!/bin/sh
mount -t proc nodev /proc
mount -t sysfs nodev /sys
}
```

this script must be executable 

now we are allmost done final thing is all those files owned by user chown to root 

![Screenshot from 2024-07-28 01-53-00](https://github.com/user-attachments/assets/259a6069-611b-47eb-9aab-3e36852dd5a7)

and finally mount the sd card copy / rsync the rootfs to the ext4 and make sure zImage and dtb file are in the fat part

