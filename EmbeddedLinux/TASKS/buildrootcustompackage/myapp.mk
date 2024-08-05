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
