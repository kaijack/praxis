module.exports = {                                                                                                                                                                                                                                                            
  outputDir: 'build/js',
  devServer: {
      proxy: {
        "/api": {
          target: "http://localhost:8090"
        }
      }
  },
  configureWebpack: {
    resolve: {
      alias: {
        '@': __dirname + '/src/main/js'
      }
    },
    entry: {
      app: './src/main/js/main.js'
    }
  }
}
