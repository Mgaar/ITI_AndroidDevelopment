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


# dual boot

create another ext 4 partition mount it and put a rootfs on it 

make a script to ask user to choose which root to boot on but first mount the 2 memory blocks 

```
mkdir mnt/boot
mkdir mnt/rootfs1
mkdir mnt/rootfs2

mount -t ext4 /dev/mmcblk0p1 /mnt/boot
mount -t ext4 /dev/mmcblk0p2 /mnt/rootfs1
mount -t ext4 /dev/mmcblk0p3 /mnt/rootfs2

echo "You have 3 options:"
echo "1) Mount and chroot to rootfs_one"
echo "2) Mount and chroot to rootfs_two"
echo "3) Open initram shell"

read -p "Please choose an option (1-3): " choice

# Handle the user's choice using a case statement
case $choice in
    1)
        chroot /mnt/boot
        ;;
    2)
        chroot /mnt/rootfs1
        ;;
    3)
        /bin/sh
        ;;
    *)
        echo "Invalid option. Please choose 1, 2, or 3."
        ;;
esac

echo "Exiting script."
```

run this script through rcS 
![Uploading Screenshot from 2024-07-29 15-48-53.png…]()


