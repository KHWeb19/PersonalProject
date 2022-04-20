module.exports={
  configureWebpack:{
    devtool: 'source-map',
  },

  transpileDependencies: [
    'vuetify'
  ]
}

/*const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})*/
