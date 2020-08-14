require linux-processor-sdk-4.19.inc

PR_append = ".9"

KERNEL_GIT_URI = "git://github.com/aaeon-kunyi/SRG52-kernel.git"
BRANCH = "dev_srg3352"
SRCREV = "1f4ee3d716b36d7807d6f59898aa9d066af42fbc"
PV = "4.19.59+git${SRCPV}"
