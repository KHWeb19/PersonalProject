<template>
    
    <my-profile v-if="member" :member="member"/>
     <p v-else>로딩중......</p>
</template>

<script>
import MyProfile from '@/components/member/MyProfile.vue'
// import axios from 'axios'
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
    MyProfile
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
  // mounted() {
  //   this.fetchMember()
  // },
  methods: {
      ...mapActions(['fetchMember']),
      
      // onDelete() {
      //   const {memberId} = this.member
      //   axios.delete(`http://localhost:7777/member/${memberId}`)
      //     .then(()=> {
      //         alert('삭제 성공')
      //         this.$router.push({name: 'JpaBoardListPage'})
      //     })
      //     .catch(()=> {
      //         alert('삭제실패 문제발생')
      //     })
      // }
    }
}
</script>

<style scoped>





</style>
