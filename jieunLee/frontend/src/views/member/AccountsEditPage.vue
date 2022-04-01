<template>
    <accounts-edit-form v-if="member" :member="member"/>
</template>

<script>
import AccountsEditForm from '../../components/member/AccountsEditForm.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  name: 'AccountsEditPage',
  props: {
    memberNo: {
        type: String,
        required: true
    }
  },
  components: {
    AccountsEditForm
  },
  computed: {
    ...mapState(['member'])
  },
  created() {
    this.fetchMember(this.memberNo)
      .catch(()=>{
          alert('회원정보 요청 실패')
          this.$router.push()
      })
  },
  methods: {
      ...mapActions(['fetchMember']),
      onDelete() {
        const {memberNo} = this.member
        axios.delete(`http://localhost:7777/member/${memberNo}`)
          // .then(()=> {
          //     alert('삭제 성공')
          //     this.$router.push({name: 'JpaBoardListPage'})
          // })
          // .catch(()=> {
          //     alert('삭제실패 문제발생')
          // })
      }
    }
}
</script>

<style scoped>





</style>
