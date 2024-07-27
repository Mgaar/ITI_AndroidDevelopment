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
