SVC_USER="svc"

do_install:append() {
    # Hacky way to add sudoer commented below
    # sed -i 's/^#\s*\(%sudo\s*ALL=(ALL:ALL)\s*ALL\)/\1/'  ${D}/${sysconfdir}/sudoers

    printf "Cmd_Alias PASSWD = /usr/bin/passwd\n${SVC_USER} ALL=(ALL:ALL) ALL, !PASSWD" > ${D}${sysconfdir}/sudoers.d/${SVC_USER}
}

FILES_${PN} += " ${sysconfdir}/sudoers.d/${SVC_USER}"