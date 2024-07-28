first install nfs package `sudo apt install nfs-kernel-server`

create server directory `sudo mkdir /srv/nfs-share`

copy the root file system to the server directory `sudo cp -r ~/staticrootfs/* ./ `

configure the ip address and server path to the file /etc/exports

```
vim /etc/exports
/srv/nfs-share 192.168.1.10(rw,no_root_squash,no_subtree_check)
```

update the qemu script with the new ip address and open qemu

```
setenv serverip 192.168.1.4
setenv ipaddr 192.168.1.10
setenv bootargs 'console=ttyAMA0  root=/dev/nfs ip=192.168.1.10:::::eth0 nfsroot=192.168.1.4:/srv/nfs-share,nfsvers=3,tcp rw init=/sbin/init'
```
set kernel and fdt addresses 
```
setenv $kernel_addr_r 60000000
setenv $fdt_addr_r 65000000 
```

load zimage and fdt by tftp 
```
tftp $kernel_addr_r /srv/tftp/zImage
tftp $fdt_addr_r /srv/tftp/vexpress-v2p-ca9.dtb
```

finally boot kernel

 `bootz $kernel_addr_r - $fdt_addr_r`
 
![Screenshot from 2024-07-28 13-31-28](https://github.com/user-attachments/assets/da33f3ad-7674-4d2c-9412-23a589d8a2ec)

 
