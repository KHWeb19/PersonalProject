<template>
<div>
  <login-form/>
</div>
</template>

<script>

import router from '@/router'
import LoginForm from '../jpaMember/LoginForm.vue'


export default {
  name: "NavHeader",
  components: {
    LoginForm
   },
  data () {
    return {
      left: false
    }
  },
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    }
  }
}

</script>
<style>
</style>