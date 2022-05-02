<template>
<!-- BoardRead페이지를 참고하여 작성 -->
  <div align="center">
    <br>
      <h1>나의 정보 확인하기</h1>
      <my-page-form v-if="userInfo" :userInfo="userInfo"/>
        <p v-else><img src="@/assets/loadRing.gif"/></p> <!-- 로딩 gif -->
      <my-pop-up/>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
//import axios from 'axios'

import MyPageForm from '@/components/jpaMember/MyPageForm.vue'
import MyPopUp from '@/components/jpaMember/MyPopUp.vue'

export default {
   name: "MemberMyPage",
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
  components: {
     MyPageForm,
     MyPopUp
  },
  computed: {
     ...mapState(['userInfo'])
  },
  created() {
     this.fetchMember(this.$store.state.userInfo.memberNo)
            .catch(() => {
               alert('정보 요청 실패!')
            })
  },
  methods: {
      ...mapActions(['fetchMember'])
  }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>