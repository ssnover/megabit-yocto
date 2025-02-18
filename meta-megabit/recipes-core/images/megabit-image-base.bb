SUMMARY = "Headless image for megabit hardware"
LICENSE = "MIT"
IMAGE_FEATURES += "splash ssh-server-openssh"
#DEPENDS = "user-config"

IMAGE_INSTALL:append = " blink blink-systemd"

inherit core-image
inherit extrausers

#
# Add a user for service access.
#
IMAGE_INSTALL:append = " sudo "

# Password generated with `openssl passwd -6 PASSWORD` and then escapes added.
PASSWD = "\$6\$ffEoii/MGxmievry\$w4qQjY3jv79fTLm06fjU3Vb7i4b3D.HjzIkAjZez6FJHoK6ZYijCVIiQQRo3DnXr4hw7YzI7sMpS/iHXV6PTa0"
NEW_USER = "svc"

EXTRA_USERS_PARAMS:append = "\
    useradd -u 1200 -d /home/${NEW_USER} -s /bin/sh -p '${PASSWD}' ${NEW_USER}; \
    usermod -a -G sudo ${NEW_USER}; \
    "

#
# Disable root-login
#
EXTRA_USERS_PARAMS:append = "\
    usermod -L -e 1 root; \
    usermod -s /sbin/nologin root; \
    "

#
# Enable systemd
#
DISTRO_FEATURES:append = " systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"