DESCRIPTION = "Linux Kernel for ti processors"
LICENSE = "GPL-2.0-only"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit kernel

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://git@github.com/eaglelinuxplatform/calixto-ti-linux.git;branch=6.1.46;protocol=ssh;" 
           
SRC_URI += "file://defconfig \
            file://am335x-calixto-nxt256.dts \
            file://am335x-calixto-nxt512.dts \
            file://am335x-calixto-nxt1024.dts \
"

S = "${WORKDIR}/git"

SRCREV = "261fafa83f844f293d6da10078ccc178c7cb0cee"

FILESEXTRAPATHS:append = "${THISDIR}/files:"

do_configure:append() {  
    if [ "${MACHINE}" = "am335x-versa-nxt256" ]; then    
        cp ${WORKDIR}/am335x-calixto-nxt256.dts ${WORKDIR}/git/arch/arm/boot/dts/am335x-calixto-nxt.dts
        dts_base="am335x-calixto-nxt" 
               
    elif [ ${MACHINE} = "am335x-versa-nxt512" ]; then
        cp ${WORKDIR}/am335x-calixto-nxt512.dts ${WORKDIR}/git/arch/arm/boot/dts/am335x-calixto-nxt.dts
        dts_base="am335x-calixto-nxt" 
               
    elif [ ${MACHINE} = "am335x-versa-nxt1024" ]; then
        cp ${WORKDIR}/am335x-calixto-nxt1024.dts ${WORKDIR}/git/arch/arm/boot/dts/am335x-calixto-nxt.dts
        dts_base="am335x-calixto-nxt"
    fi
    
    
    if ! grep -q "dtb-$(CONFIG_SOC_IMX6UL) += ${dts_base}.dtb" "${S}/arch/arm/boot/dts/Makefile"; then
        echo "dtb-$(CONFIG_SOC_IMX6UL) += ${dts_base}.dtb" >> "${S}/arch/arm/boot/dts/Makefile"
    fi
}
