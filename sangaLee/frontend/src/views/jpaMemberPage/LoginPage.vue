<template>
  <div>
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

import LoginForm from '@/components/jpaMember/LoginForm.vue'
import SignUpForm from '@/components/jpaMember/SignUpForm.vue'

export default {
  name: 'LoginPage.vue',
  components: {
    LoginForm
  }
}
</script>