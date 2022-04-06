<template>
  <div>
    <menu-bar/>
              <div style="display: flex; justify-content: center;">
    <accounts-category/>
    <accounts-edit-form v-if="member" :member="member" @submit="onSubmit"/>
      <p v-else>로딩중......</p>
              </div>
  </div>
</template>

<script>
import AccountsEditForm from '@/components/member/AccountsEditForm.vue'
import AccountsCategory from '@/components/AccountsCategory.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import MenuBar from '../../components/MenuBar.vue'

export default {
  name: 'AccountsEditPage',
  props: {
    memberNo: {
        type: String,
        required: true
    }
  },
  components: {
    AccountsEditForm,
    AccountsCategory,
    MenuBar
  },

  computed: {
    ...mapState(['member']),
    
  },
  methods: {
    ...mapActions(['fetchMember']),
    onSubmit(payload) {
      const {memberName, memberId} = payload
      axios.put(`http://localhost:7777/member/${this.memberNo}`, {memberName, memberId, password: this.member.password})
        .then(res => {
            alert('회원정보 수정 성공')
            this.$router.push({
                name: 'MyProfilePage',
                params: {memberNo: res.data.memberNo.toString()}
            })
        })
        .catch(()=>{
            alert('회원정보 수정 실패')
        })
      },
  created() {
    this.fetchMember(this.memberNo)
      .catch(()=>{
          alert('회원정보 요청 실패')
          this.$router.back()
      })
  },
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
