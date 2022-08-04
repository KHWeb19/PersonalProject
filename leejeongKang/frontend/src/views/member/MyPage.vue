<template>
  <div>
    <main-form/>
    <mypage-form v-if="userInfo" :userInfo="userInfo"/>
    <p v-else>로딩중</p>
    <main-bottom/>
  </div>
</template>

<script>
import MainForm from '@/components/main/MainForm.vue'
import MypageForm from '@/components/member/MypageForm.vue'
import { mapActions, mapState } from 'vuex'
import MainBottom from '@/components/main/MainBottom.vue'
export default {
  name: 'MyPage',
  components: {
    MypageForm,
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
    ...mapActions(['fetchMember'])
  }
}
</script>
