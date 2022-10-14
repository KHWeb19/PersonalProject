<template>
  <div>
    <main-form/>
    <mypage-edit-form v-if="userInfo" :userInfo="userInfo" @submit="onSubmit"/>
    <p v-else>로딩중</p>
    <main-bottom/>
  </div>
</template>

<script>
import axios from 'axios'
import MainForm from '@/components/main/MainForm.vue'
import MypageEditForm from '@/components/member/MypageEditForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import { mapActions, mapState } from 'vuex'
export default {
  name: 'MyPage',
  components: {
    MypageEditForm,
    MainForm,
    MainBottom
  },
  props: {
    memberNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['userInfo'])
  },
  created () {
    this.fetchMember(this.$store.member.memberNo)
      .catch(() => {
        alert('회원정보 DB 조회 실패')
      })
  },
  methods: {
    ...mapActions(['fetchMember']),
    onSubmit (payload) {
      const { password, name, birth, phone } = payload
      axios.put(`http://localhost:7777/member/${this.$store.state.userInfo.memberNo}`,
        { id: this.userInfo.id, password, name, birth, phone })
        .then(res => {
          alert('개인 정보가 수정되었습니다.')
          localStorage.removeItem("userInfo")
          localStorage.setItem("userInfo", JSON.stringify(res.data))
          this.$router.push({
            name: 'MyPage',
            params: { memberNo: res.data.memberNo.toString() }
          })
        })
        .catch(() => {
          alert('개인 정보 수정 실패!')
        })
    }
  }
}
</script>
