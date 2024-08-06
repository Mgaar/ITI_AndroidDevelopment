first we must source oe-init-build-env so that it update the PATH and create our build enviroment 

then to create our layer `bitbake-layers create-layer ../meta-iti` this commaand will create a template meta layer 

![Screenshot from 2024-08-07 00-52-42](https://github.com/user-attachments/assets/0d53b192-af93-4215-b40d-7730534b5ce2)

now we must add our layer so `cd build`

`bitbake-layers add-layer ../../meta-iti`

![Screenshot from 2024-08-07 01-12-14](https://github.com/user-attachments/assets/27b22d91-6293-4b9f-8981-d528b04b3d99)

now to create our recipe `cd ../meta-iti` and `mkdir recipes-myrecipe` `mkdir myrecipe` and inside `touch myrecipe.bb`

we implement our simple recipe 

```
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");

    bb.plain("*  Example recipe created by Mohamed Elg3ar   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build

```

now just 

`bitbake myrecipe`

![Screenshot from 2024-08-07 01-14-19](https://github.com/user-attachments/assets/27a00f1b-1b12-43e6-8c0e-2b8620a4076a)
