<template>
<div>
        <v-toolbar-title>
        <div @click="home">로고들어갈자리</div>
         <login-form/>
         <register-form/> 
      </v-toolbar-title>
</div>
</template>

<script>

import router from '@/router'
import LoginForm from '@/components/jpaMember/LoginForm.vue'
import RegisterForm from '@/components/jpaMember/RegisterForm.vue'

export default {
  name: "NavHeader",
  components: {
    LoginForm,
    RegisterForm,
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