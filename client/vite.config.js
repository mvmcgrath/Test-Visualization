import { defineConfig, transformWithOxc } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [
    {
      name: 'treat-js-as-jsx',
      enforce: 'pre',
      async transform(code, id) {
        if (!id.match(/src\/.*\.js$/)) return null
        return transformWithOxc(code, id, { lang: 'jsx' })
      }
    },
    react()
  ],
  server: {
    proxy: { '/api': 'http://localhost:8080' }
  }
})
