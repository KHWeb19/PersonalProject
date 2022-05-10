<template>
<!-- BoardRead페이지를 참고하여 작성 -->
  <div align="center">
    <br>
      <h1>나의 정보 확인하기</h1>
      <my-page-form v-if="userInfo" :userInfo="userInfo" @submit="onSubmit"/>
        <p v-else><img src="@/assets/loadRing.gif"/></p> <!-- 로딩 gif -->
    <v-container>
      <v-row justify="center">

        &ensp;&ensp;
        <my-pop-up/>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

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
      ...mapActions(['fetchMember']),
        onSubmit (payload) {
            const { sn, city, dong, address } = payload
            axios.put(`http://localhost:7777/jpaMember/${this.$store.state.userInfo.memberNo}`,
                { id: this.$store.state.userInfo.id, sn, city, dong, address })
                    .then(res => {
                        alert('회원정보 수정 성공!')
                        localStorage.removeItem("userInfo")
                        localStorage.setItem("userInfo", JSON.stringify(res.data))
                        history.go(0)
                    })
                    .catch(() => {
                        alert('회원정보 수정 실패!')
                    })
        }
  }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>