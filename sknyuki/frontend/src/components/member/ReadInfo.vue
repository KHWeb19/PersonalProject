<template>
<v-container>
   <v-row justify="center" >
  <v-card flat>
    <v-card v-if="!isLogin" flat>
      <v-card-text>
        <p class="title">로그인 해주세요.</p>
      </v-card-text>
    </v-card>
    
    <v-card class="ml-6 mr-3 my-3" v-else>
      <v-card-text>
        <v-list-item-title>
          <p>{{ userInfo.name }}님의 회원정보</p>
        </v-list-item-title>
        <v-divider></v-divider>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이름</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.name }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>생일</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.birth }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>이메일</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.email }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>핸드폰</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.phone }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-list-item two-line>
          <v-list-item-content>
            <v-list-item-title>주소</v-list-item-title>
            <v-list-item-subtitle>{{ userInfo.address }}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

      </v-card-text>
      <v-card-actions>
        <modify-info></modify-info>
        
        <v-spacer></v-spacer>
        <remove-info></remove-info>
      </v-card-actions>
    </v-card>
  </v-card>
   </v-row>
</v-container>
</template>


<script>
import ModifyInfo from '@/components/member/ModifyInfo'
import RemoveInfo from '@/components/member/RemoveInfo'
import { mapState } from 'vuex'

export default {
  name:'ReadInfo',
  components: {
    ModifyInfo,
    RemoveInfo
  },
  data () {
    return {
      
    }
  },
  computed: {
    ...mapState([ 'userInfo', 'isLogin' ])
  }
}
</script>