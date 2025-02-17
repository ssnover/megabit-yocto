SUMMARY = "Blink an LED"
HOMEPAGE = "git://github.com/ssnover/pi-blink"
LICENSE = "MIT"
#PROVIDES = "blink"

inherit cargo_bin

do_compile[network] = "1"

SRC_URI = "git://github.com/ssnover/pi-blink.git;protocol=https;branch=main"
SRCREV = "78f88e4b4973ef8ba7f92f0f8968b6ece3030710"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://LICENSE;6b8112064d3d99c58aa5d7aa6eed79d8"