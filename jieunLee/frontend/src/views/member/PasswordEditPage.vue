<template>
  <div>
    <menu-bar/>
    <div style="display: flex; justify-content: center;">
      <accounts-category/>
      <password-edit-form v-if="member" :member="member" @submit="onSubmit"/>
      <p v-else>로딩중......</p>
    </div>
  </div>
</template>

<script>
import PasswordEditForm from '@/components/member/PasswordEditForm.vue'
import AccountsCategory from '@/components/AccountsCategory.vue'
import MenuBar from '@/components/MenuBar.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
export default {
  name: 'AccountsEditPage',
  components: {
    PasswordEditForm,
    AccountsCategory,
    MenuBar
  },
        props: {
        memberNo: {
            type: String,
            require: true
        }
        
    },
    computed: {
    ...mapState(['member']),
  },
  methods: {
    ...mapActions(['fetchMember']),
        onSubmit(payload) {
      const {password} = payload
      axios.put(`http://localhost:7777/member/${this.memberNo}`, 
      {memberName: this.member.memberName, memberId: this.member.memberId, password, imageName: this.member.imageName, memberWeb: this.member.memberWeb, memberIntro: this.member.memberIntro, regDate: this.member.regDate})
        .then((res) => {
            alert('비밀번호 수정 성공')
            // localStorage.removeItem("userInfo")
            // localStorage.setItem("userInfo", JSON.stringify(res.data))
              this.$router.push({
                  name: 'MyProfilePage',
                  params: {memberNo: res.data.memberNo.toString()}
            })
        })
        .catch(()=>{
            alert('비밀번호 수정 실패')
        })
      }
  }
}
</script>