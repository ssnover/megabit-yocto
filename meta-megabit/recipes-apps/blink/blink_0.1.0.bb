SUMMARY = "Blink an LED"
HOMEPAGE = "git://github.com/ssnover/pi-blink"
LICENSE = "MIT"
#PROVIDES = "blink"

inherit cargo_bin

do_compile[network] = "1"

SRC_URI = "git://github.com/ssnover/pi-blink.git;protocol=https;branch=main"
SRCREV = "80ac9c33bd7bd77ff33445734a0c30b143a89f3f"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6b8112064d3d99c58aa5d7aa6eed79d8"