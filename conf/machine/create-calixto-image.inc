create_am335x_versa_image () {

CALIXTO_IMAGE_PATH_SDCARD="${DEPLOY_DIR}/../../../calixto-images/${MACHINE}/sdcard"

rm -rf ${CALIXTO_IMAGE_PATH_SDCARD}
mkdir -p ${CALIXTO_IMAGE_PATH_SDCARD}

cp ${DEPLOY_DIR}/../../../meta-calixto-ti/recipes-bsp/am335x-versa-flasher/files/MLO ${CALIXTO_IMAGE_PATH_SDCARD}/MLO
cp ${DEPLOY_DIR}/../../../meta-calixto-ti/recipes-bsp/am335x-versa-flasher/files/MLO.byteswap ${CALIXTO_IMAGE_PATH_SDCARD}/MLO.byteswap
cp ${DEPLOY_DIR}/../../../meta-calixto-ti/recipes-bsp/am335x-versa-flasher/files/u-boot.img ${CALIXTO_IMAGE_PATH_SDCARD}/u-boot.img

cp ${DEPLOY_DIR}/../../../meta-calixto-ti/recipes-bsp/am335x-versa-flasher/files/create-sdcard-boot.sh ${CALIXTO_IMAGE_PATH_SDCARD}/create-sdcard-boot.sh

}
