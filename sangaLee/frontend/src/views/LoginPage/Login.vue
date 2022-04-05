<template>
  <div>
    <login-form @submit="onSubmit"/>
    <v-spacer></v-spacer>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

import LoginForm from '@/components/LoginPage/LoginForm.vue'

export default {
  name: 'MainLogin.vue',
  components: {
    LoginForm
  }
}
</script>