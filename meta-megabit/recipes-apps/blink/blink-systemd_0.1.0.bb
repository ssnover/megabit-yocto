LICENSE = "CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "blink.service"

SRC_URI:append = " file://blink.service"
FILES:${PN} += "${systemd_unitdir}/system/blink.service"

do_install:append() {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/blink.service ${D}/${systemd_unitdir}/system
}