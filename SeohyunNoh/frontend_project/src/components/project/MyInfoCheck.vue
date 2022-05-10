<template>
    <div>
      <v-card outlined>
        <div align = center class="mt-3">
          <v-toolbar-title class="font-weight-bold"> {{ userInfo.id }} 님 환영합니다!</v-toolbar-title>
        
          <v-divider></v-divider>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>이름</v-list-item-title>
              <v-list-item-subtitle>{{ userInfo.name }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>아이디</v-list-item-title>
              <v-list-item-subtitle>{{ userInfo.id }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>생년월일</v-list-item-title>
              <v-list-item-subtitle>{{ userInfo.birth }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>

          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title>주소</v-list-item-title>
              <v-list-item-subtitle>{{ userInfo.address }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </div>

        <modify-my-page/>

      </v-card>             
    </div>
</template>


<script>
import ModifyMyPage from '@/components/project/ModifyMyPage.vue'

import { mapState } from 'vuex'


export default {
  components: {
    ModifyMyPage
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  }
}
</script>

<style scoped>

</style>