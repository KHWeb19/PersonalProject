<template>
  <div>
      <menu-bar :member="member"/>
      <my-profile v-if="member" :member="member"/>
      <p v-else>로딩중......</p>
  </div>
</template>

<script>
import MyProfile from '@/components/member/MyProfile.vue'
import MenuBar from '@/components/MenuBar.vue'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'MyProfilePage',
  props: {
    memberNo: {
        type: String,
        required: true
    }
  },
  components: {
    MyProfile,
    MenuBar
  },

  computed: {
    ...mapState(['member']),
    
  },
  created() {
    this.fetchMember(this.memberNo)
      .catch(()=>{
          alert('로그인 정보 요청 실패')
          this.$router.push()
      })
  },
  methods: {
      ...mapActions(['fetchMember']),
    }
}
</script>

<style scoped>





</style>
