<template>
<div>
    <v-list-item-action> 
        <v-icon> mdi-login </v-icon>
    </v-list-item-action>
    
  </div>
</template>

<script>
import router from '@/router'

export default {
    name: "LoginForm",
    data() {

    },
    methods: {
      loginmethond () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
      }
    }
}
</script>