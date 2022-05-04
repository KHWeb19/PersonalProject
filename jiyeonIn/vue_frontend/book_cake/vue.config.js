module.exports = {
  transpileDependencies: [
    'vuetify'
  ]
}

const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies:true,
  lintOnSave:false
})