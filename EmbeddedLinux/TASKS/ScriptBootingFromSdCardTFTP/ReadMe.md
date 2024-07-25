first mount the virtual sd card 

` sudo losetup -f --show --partscan sd.img`

then partition the sd card 

`sudo mkfs.vfat -F 16 -n boot /dev/loop22p1`

`sudo mkfs.ext4 -L rootfs /dev/loop22p2`

then mount them
` sudo mount /dev/loop22p1 ~/boot`
 `sudo mount /dev/loop22p2 ~/rootfs`

![alt text](./images/image1.png)
