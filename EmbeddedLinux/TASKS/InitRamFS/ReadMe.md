to create initram first archive the rootfs

by running `find . | cpio -H newc -ov --owner root:root > ../initramfs.cpio` in the static root file system 

then compress `gzip initramfs.cpio`

and convert to a uboot image so that uboot could decompress and run it in ram 

`mkimage -A arm -O linux -T ramdisk -d initramfs.cpio.gz uRamdisk`

put the img in boot partition and run qemu 

set uboot env variables and load image fdt and the uRamdisk in ram 

```
setenv initramfs 0x60800000


fatload mmc 0:1 $kernel_addr_r zImage
fatload mmc 0:1 $fdt_addr_r vexpress-v2p-ca9.dtb
fatload mmc 0:1 $initramfs uRamdisk


setenv bootargs "console=ttyAMA0 rdinit=/bin/sh"


bootz $kernel_addr_r $initramfs $fdt_addr_r

```

![Screenshot from 2024-07-28 16-56-48](https://github.com/user-attachments/assets/bcda658d-abaf-456d-8614-b7a3ea815293)


