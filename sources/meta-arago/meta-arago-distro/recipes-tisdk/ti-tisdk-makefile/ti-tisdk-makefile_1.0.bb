DESCRIPTION = "Package containing Makefile and Rules.make file for TISDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# Build the list of component makefiles to put together to build the
# Makefile that goes into the SDK.  For legacy devices the base Makefile
# will be picked up and will contain everything.
#
# It is assumed that the component makefiles follow the naming
# Makefile_$component.  All Makefiles will be part of the SRC_URI to be
# fetched, but only the listed ones will be used to build the final Makefile

SRC_URI = "\
    file://Makefile \
    file://Rules.make \
    file://Makefile_linux \
    file://Makefile_linux-dtbs \
    file://Makefile_u-boot-legacy \
    file://Makefile_matrix-gui \
    file://Makefile_arm-benchmarks \
    file://Makefile_ti-crypto-examples \
    file://Makefile_am-sysinfo \
    file://Makefile_av-examples \
    file://Makefile_u-boot-spl \
    file://Makefile_matrix-gui-browser \
    file://Makefile_refresh-screen \
    file://Makefile_pru \
    file://Makefile_ti-ocf-crypto-module \
    file://Makefile_qt-tstat \
    file://Makefile_quick-playground \
    file://Makefile_omapconf \
    file://Makefile_oprofile-example \
    file://Makefile_dual-camera-demo \
    file://Makefile_image-gallery \
    file://Makefile_cryptodev \
    file://Makefile_cmem-mod \
    file://Makefile_debugss-module-drv \
    file://Makefile_gdbserverproxy-module-drv \
    file://Makefile_ti-sgx-ddk-km \
    file://Makefile_opencl-examples \
    file://Makefile_boot-monitor \
    file://Makefile_hplib-mod \
    file://Makefile_uio-module-drv \
    file://Makefile_pru-icss \
    file://Makefile_qt-opencv-opencl-opengl-multithreaded \
    file://Makefile_ipsecmgr-mod \
    file://Makefile_openmpacc-examples \
    file://Makefile_linalg-examples \
    file://Makefile_ti-gc320-driver \
    file://Makefile_barcode-roi \
    file://Makefile_sysfw-image \
    file://Makefile_mmwavegesture-hmi \
    file://Makefile_pdm-anomaly-detection \
    file://Makefile_tiovx-app-host \
    file://Makefile_ti-ipc \
    file://Makefile_jailhouse \
"

PR = "r103"

MAKEFILES_MATRIX_GUI = "matrix-gui-browser \
                        refresh-screen \
                        qt-tstat \
"

MAKEFILES_MATRIX_GUI_keystone = ""
MAKEFILES_MATRIX_GUI_omapl138 = ""
MAKEFILES_MATRIX_GUI_j7-evm = ""

MAKEFILES_COMMON = "linux \
                    matrix-gui \
                    arm-benchmarks \
                    am-sysinfo \
                    oprofile-example \
                    ${MAKEFILES_MATRIX_GUI} \
"
MAKEFILES = ""

# This example application should not be used when using non-SGX
QUICK_PLAYGROUND = "${@oe.utils.conditional('ARAGO_QT_PROVIDER','qt4-embedded-gles','quick-playground','', d)}"

# Add device specific make targets

MAKEFILES_append_omap3 = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
"
MAKEFILES_append_am37x-evm = " av-examples \
                               ti-ocf-crypto-module \
"
MAKEFILES_append_am3517-evm = " av-examples \
                                ti-ocf-crypto-module \
"
MAKEFILES_append_ti33x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           ti-crypto-examples \
                           linux-dtbs \
                           cryptodev \
                           ti-sgx-ddk-km \
                           pru-icss \
                           barcode-roi \
                           uio-module-drv \
			   mmwavegesture-hmi \
                           pdm-anomaly-detection \
"
MAKEFILES_append_ti43x = " u-boot-spl \
                           ${QUICK_PLAYGROUND} \
                           ti-crypto-examples \
                           linux-dtbs \
                           cryptodev \
                           dual-camera-demo \
                           image-gallery \
                           ti-sgx-ddk-km \
                           cmem-mod \
                           pru-icss \
                           barcode-roi \
                           uio-module-drv \
			   mmwavegesture-hmi \
                           pdm-anomaly-detection \
"

#                            debugss-module-drv 
#                            gdbserverproxy-module-drv 
MAKEFILES_append_dra7xx = " cryptodev \
                            opencl-examples \
                            openmpacc-examples \
                            qt-opencv-opencl-opengl-multithreaded \
                            linalg-examples \
                            tiovx-app-host \
"

MAKEFILES_append_omap-a15 = " u-boot-spl \
                              ${QUICK_PLAYGROUND} \
                              omapconf \
                              linux-dtbs \
                              ti-sgx-ddk-km \
                              cmem-mod \
                              pru-icss \
                              ti-gc320-driver \
                              barcode-roi \
                              uio-module-drv \
			      mmwavegesture-hmi \
                              pdm-anomaly-detection \
                              ti-ipc \
"
MAKEFILES_append_omapl138 = " linux-dtbs \
                              u-boot-spl \
                              ti-ipc \
"

MAKEFILES_append_keystone = " u-boot-spl \
                              linux-dtbs \
                              boot-monitor \
                              cmem-mod \
                              cryptodev \
                              ti-crypto-examples \
                              hplib-mod \
                              uio-module-drv \
                              ipsecmgr-mod \
                              barcode-roi \
                              ti-ipc \
"

#                              gdbserverproxy-module-drv 
#                              debugss-module-drv 
MAKEFILES_append_k2hk = " opencl-examples \
                              openmpacc-examples \
                              linalg-examples \
"

#                             gdbserverproxy-module-drv 
#                             debugss-module-drv 
MAKEFILES_append_k2l = " opencl-examples \
                             openmpacc-examples \
"

#                             gdbserverproxy-module-drv 
#                             debugss-module-drv 
MAKEFILES_append_k2e = " opencl-examples \
                             openmpacc-examples \
"

MAKEFILES_append_k2g = " pru-icss"

MAKEFILES_append_k3 = " u-boot-spl \
                        linux-dtbs \
                        cryptodev \
                        sysfw-image \
                        ti-ipc \
                        jailhouse \
"

MAKEFILES_append_am65xx = " \
                        pru-icss \
                        ti-sgx-ddk-km \
                        barcode-roi \
                        mmwavegesture-hmi \
                        pdm-anomaly-detection \
"

MAKEFILES_append_j7-evm = " pru-icss \
"

# Use this to export kernel arch to ARCH
#
# We need to be very careful here. This class will also overwrite UBOOT_ARCH
# even though it may be set in the machine configuration.
inherit kernel-arch

# Use ARCH format expected by the makefile
PLATFORM_ARCH = "${ARMPKGARCH}"
PLATFORM_ARCH_arm = "armv7-a"
PLATFORM_ARCH_omapl138 = "armv5te"

# ti-sgx-ddk-km configurations
# See meta-ti/recipes-bsp/powervr-drivers/ti-sgx-ddk-km_1.17.4948957.bb
TI_SGX_TARGET_PRODUCT = "jacinto6evm"
TI_SGX_TARGET_PRODUCT_ti33x = "ti335x"
TI_SGX_TARGET_PRODUCT_ti43x = "ti437x"
TI_SGX_TARGET_PRODUCT_k3 = "ti654x"

TI_SGX_TARGET_ARCH = "armhf"
TI_SGX_TARGET_ARCH_k3 = "aarch64"

PLATFORM_DEBUGSS = ""
PLATFORM_DEBUGSS_dra7xx = "DRA7xx_PLATFORM"
PLATFORM_DEBUGSS_keystone = "KEYSTONE_PLATFORM"

PLATFORM_GDBSERVERPROXY = ""
PLATFORM_GDBSERVERPROXY_dra7xx = "DRA7xx_PLATFORM"
PLATFORM_GDBSERVERPROXY_keystone = "KEYSTONE_PLATFORM"

PRU_ICSS_INSTALL_TARGET = "pru-icss_install_none"
PRU_ICSS_INSTALL_TARGET_ti33x = "pru-icss_install_am335x"
PRU_ICSS_INSTALL_TARGET_ti43x = "pru-icss_install_am437x"
PRU_ICSS_INSTALL_TARGET_omap-a15 = "pru-icss_install_am572x"
PRU_ICSS_INSTALL_TARGET_k2g = "pru-icss_install_k2g"
PRU_ICSS_INSTALL_TARGET_am65xx = "pru-icss_install_am65x"
PRU_ICSS_INSTALL_TARGET_j7-evm = "pru-icss_install_j721e"

# Path to toolchains for the various cores in TI SOCs
#
# These are provided by the TI RTOS SDK and used to build firmwares used by the
# IPC Linux examples.
IPC_TOOLS_PATHS_C66 = "ti.targets.elf.C66="\$\(C6X_GEN_INSTALL_PATH\)""
IPC_TOOLS_PATHS_M4  = "ti.targets.arm.elf.M4="\$\(TOOLCHAIN_PATH_M4\)" ti.targets.arm.elf.M4F="\$\(TOOLCHAIN_PATH_M4\)""
IPC_TOOLS_PATHS_R5F  = "ti.targets.arm.elf.R5F="\$\(TOOLCHAIN_PATH_R5\)""
IPC_TOOLS_PATHS_C674 = "ti.targets.elf.C674="\$\(C6X_GEN_INSTALL_PATH\)""

IPC_TOOLS_PATHS = ""
IPC_TOOLS_PATHS_append_keystone = " ${IPC_TOOLS_PATHS_C66}"
IPC_TOOLS_PATHS_append_omap-a15 = " ${IPC_TOOLS_PATHS_C66} ${IPC_TOOLS_PATHS_M4}"
IPC_TOOLS_PATHS_append_omapl138 = " ${IPC_TOOLS_PATHS_C674}"
IPC_TOOLS_PATHS_append_k3 = "${IPC_TOOLS_PATHS_R5F}"

# Populate Jailhouse config header
JH_PLATFORM = "${MACHINE}"
JH_PLATFORM_k3 = "k3"

# If it's not defined at all, like for zImage case
UBOOT_LOADADDRESS ?= "0"

KERNEL_BUILD_CMDS = "${@oe.utils.conditional('KERNEL_IMAGETYPE','uImage','LOADADDR=${UBOOT_LOADADDRESS}','',d)} ${KERNEL_IMAGETYPE}"

DEFCONFIG = "tisdk_${MACHINE}${ARAGO_KERNEL_SUFFIX}_defconfig"

AMSDK_DEFCONFIG = "singlecore-omap2plus_defconfig"

DEFCONFIG := "${@oe.utils.conditional('ARAGO_BRAND','amsdk','${AMSDK_DEFCONFIG}','${DEFCONFIG}',d)}"

EXTERNAL_TOOLCHAIN_BINDIR = "/usr/bin"
INTERNAL_TOOLCHAIN_BINDIR = "/usr/bin/${TARGET_ARCH}${TARGET_VENDOR}-${TARGET_OS}"

# This step will stitch together the final Makefile based on the supported
# make targets.
do_install () {
    install -d ${D}/

    # Start with the base Makefile
    install  ${WORKDIR}/Makefile ${D}/Makefile

    # Remember the targets added so we can update the all target
    targets=""
    clean_targets=""
    install_targets=""

    # Now add common build targets
    for x in ${MAKEFILES_COMMON}
    do
        cat ${WORKDIR}/Makefile_${x} >> ${D}/Makefile
        targets="$targets""$x\ "
        clean_targets="$clean_targets""$x""_clean\ "
        install_targets="$install_targets""$x""_install\ "
    done

    # Now add device specific build targets
    for x in ${MAKEFILES}
    do
        cat ${WORKDIR}/Makefile_${x} >> ${D}/Makefile
        targets="$targets""$x\ "
        clean_targets="$clean_targets""$x""_clean\ "
        install_targets="$install_targets""$x""_install\ "
    done

    # Update the all, clean, and install targets if we added targets
    if [ "$targets" != "" ]
    then
        sed -i -e "s/__ALL_TARGETS__/$targets/" ${D}/Makefile
        sed -i -e "s/__CLEAN_TARGETS__/$clean_targets/" ${D}/Makefile
        sed -i -e "s/__INSTALL_TARGETS__/$install_targets/" ${D}/Makefile
    fi

    sed -i -e "s/__KERNEL_ARCH__/${ARCH}/" ${D}/Makefile
    sed -i -e "s/__KERNEL_IMAGE_TYPE__/${KERNEL_IMAGETYPE}/" ${D}/Makefile
    sed -i -e "s/__KERNEL_BUILD_CMDS__/${KERNEL_BUILD_CMDS}/" ${D}/Makefile
    sed -i -e "s/__SDKMACHINE__/${SDKMACHINE}/g" ${D}/Makefile

    sed -i -e "s/__TI_SGX_TARGET_PRODUCT__/${TI_SGX_TARGET_PRODUCT}/" ${D}/Makefile
    sed -i -e "s/__TI_SGX_TARGET_ARCH__/${TI_SGX_TARGET_ARCH}/" ${D}/Makefile
    sed -i -e "s/__PLATFORM_DEBUGSS__/${PLATFORM_DEBUGSS}/g" ${D}/Makefile
    sed -i -e "s/__PLATFORM_GDBSERVERPROXY__/${PLATFORM_GDBSERVERPROXY}/g" ${D}/Makefile
    sed -i -e "s/__BOOT_MONITOR_MAKE_TARGET__/${BOOT_MONITOR_MAKE_TARGET}/g" ${D}/Makefile
    sed -i -e "s/__PRU_ICSS_INSTALL_TARGET__/${PRU_ICSS_INSTALL_TARGET}/g" ${D}/Makefile
    sed -i -e "s/__IPC_TOOLS_PATHS__/${IPC_TOOLS_PATHS}/g" ${D}/Makefile
    sed -i -e "s/__JH_PLATFORM__/${JH_PLATFORM}/" ${D}/Makefile
    sed -i -e "s/__TISDK_VERSION__/${TISDK_VERSION}/g" ${D}/Makefile

    cat ${D}/Makefile | grep "__DTB_DEPEND__" > /dev/null

    if [ "$?" == "0" ]
    then
        sed -i -e "s|__KERNEL_DEVICETREE__|${KERNEL_DEVICETREE}|" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND__/linux-dtbs/" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND_INSTALL__/linux-dtbs_install/" ${D}/Makefile
    else
        sed -i -e "s/__DTB_DEPEND__//" ${D}/Makefile
        sed -i -e "s/__DTB_DEPEND_INSTALL__//" ${D}/Makefile
    fi


    install  ${WORKDIR}/Rules.make ${D}/Rules.make

    # fixup Rules.make values
    sed -i -e "s/__PLATFORM__/${MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__DEFCONFIG__/${DEFCONFIG}/" ${D}/Rules.make
    sed -i -e "s/__ARCH__/${PLATFORM_ARCH}/" ${D}/Rules.make
    sed -i -e "s/__TOOLCHAIN_PREFIX__/${TOOLCHAIN_SYS}-/" ${D}/Rules.make
    sed -i -e "s/__UBOOT_MACHINE__/${UBOOT_MACHINE}/" ${D}/Rules.make
    sed -i -e "s/__CFLAGS__/${TARGET_CC_ARCH}/" ${D}/Rules.make
    sed -i -e "s/__SDKMACHINE__/${SDKMACHINE}/" ${D}/Rules.make

    if [ "${TOOLCHAIN_TYPE}" = "internal" ]; then
        sed -i -e "s|__TOOLCHAIN_BINDIR__|${INTERNAL_TOOLCHAIN_BINDIR}|" ${D}/Rules.make
    else
        sed -i -e "s|__TOOLCHAIN_BINDIR__|${EXTERNAL_TOOLCHAIN_BINDIR}|" ${D}/Rules.make
    fi

}

K3_UBOOT_MACHINE_R5 = ""
K3_UBOOT_MACHINE_R5_am65xx-evm = "am65x_evm_r5_defconfig"
K3_UBOOT_MACHINE_R5_am65xx-hs-evm = "am65x_hs_evm_r5_defconfig"
K3_UBOOT_MACHINE_R5_j7-evm = "j721e_evm_r5_config"

do_install_append_k3() {
    cat >> ${D}/Rules.make << __EOF__

# Add CROSS_COMPILE and UBOOT_MACHINE for the R5
export CROSS_COMPILE_ARMV7=\$(LINUX_DEVKIT_PATH)/sysroots/${SDKMACHINE}-arago-linux/usr/bin/arm-linux-gnueabihf-
UBOOT_MACHINE_R5=${K3_UBOOT_MACHINE_R5}
__EOF__
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "/*"
