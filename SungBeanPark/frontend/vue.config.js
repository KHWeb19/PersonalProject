module.exports = {
  css: {
    loaderOptions: {
      scss: {
        additionalData: `
        @import "@/assets/scss/abstracts.scss";
    `,
      },
    },
  },
}
