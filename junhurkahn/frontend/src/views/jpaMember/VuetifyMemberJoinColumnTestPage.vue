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

    <vuetify-member-join-column-test-form @submit="onSubmit"/>

    <!-- 사업자 권한을 가진 사람들만 뽑아보자! -->
    <look-business-member-form/>
  </div>
</v-app>
</template>

<script>

import VuetifyMemberJoinColumnTestForm from '@/components/jpaMember/VuetifyMemberJoinColumnTestForm.vue'
import LookBusinessMemberForm from '@/components/jpaMember/LookBusinessMemberForm.vue'
import axios from 'axios'
import router from '@/router'

export default {
  name: "VuetifyMemberJoinColumnTestPage",
  components: {
    VuetifyMemberJoinColumnTestForm,
    LookBusinessMemberForm
  },
  methods: {
    onSubmit (payload) {
      const { id, pw, auth } = payload
      axios.post('http://localhost:7777/vueJpaMemberAuth/register', { id, pw, auth })
        .then(res => {
          alert('등록 성공! - ' + res)
            router.push({name : 'LoginTestPage'})
        })
        .catch(res => {
          alert(res.response.data.message)
           router.push({name : 'LoginTestPage'})
           
          
          
        })
    }
  }
}

</script>


<style scoped>
h3{color: white;}
</style>
