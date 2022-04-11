<template>


<v-app id="inspire">
    <v-app-bar app clipped-right color="blue" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>
        <router-link style="text-decoration: none;"  :to="{ name: '' }">
     <h3>스마트 노트</h3>
    </router-link>
      </v-toolbar-title>
    </v-app-bar>

  <div>
    <div align="center">
      <h2>회원 가입</h2>
    </div>

    <vuetify-member-register-form @submit="onSubmit"/>
  </div>
</v-app>
</template>

<script>

import VuetifyMemberRegisterForm from '@/components/jpaMember/VuetifyMemberRegisterForm.vue'
import axios from 'axios'

export default {
  name: "VuetifyMemberRegisterPage.vue",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    VuetifyMemberRegisterForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw } = payload
      axios.post('http://localhost:7777/vueJpaMember/register', { id, pw })
        .then(res => {
          alert('등록 성공! - ' + res)
        })
        .catch(res => {
          alert(res.response.data.message)
        })
    }
  }
}

</script>

<style scoped>
h3{color: white;}
</style>
