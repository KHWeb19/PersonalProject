<template>
  <div>
    <menu-bar :member="member"/>
              <div style="display: flex; justify-content: center;">
    <accounts-category/>
    <accounts-edit-form v-if="member" :member="member" @submit="onSubmit" @image="onImage"/>
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

  components: {
    AccountsEditForm,
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
  created() {
    this.fetchMember(this.memberNo)
      .catch(()=>{
          alert('프로필 요청 실패')
          this.$router.back()
      })
  },
  methods: {
    ...mapActions(['fetchMember']),
    onSubmit(payload) {
      const {memberName, memberId, imageName, memberWeb, memberIntro} = payload
      axios.put(`http://localhost:7777/member/${this.memberNo}`, 
      {memberName, memberId, password: this.member.password, imageName, memberWeb, memberIntro, regDate: this.member.regDate})
        .then(res => {
            alert('프로필 수정 성공')
            // localStorage.removeItem("userInfo")
            // localStorage.setItem("userInfo", JSON.stringify(res.data))
              this.$router.push({
                  name: 'MyProfilePage',
                  params: {memberNo: res.data.memberNo.toString()}
            })
        })
        .catch(()=>{
            alert('프로필 수정 실패')
        })
    },
    onImage(payload) {
    const {imageName} = payload
    axios.put(`http://localhost:7777/member/${this.memberNo}`, 
    {memberName:this.member.memberName, memberId:this.member.memberId, password: this.member.password, imageName, memberWeb:this.member.memberWeb, memberIntro:this.member.memberIntro, regDate: this.member.regDate})
      .then(res => {
          alert('프로필사진 수정 성공')
          // localStorage.removeItem("userInfo")
          // localStorage.setItem("userInfo", JSON.stringify(res.data))
            this.$router.push({
                name: 'MyProfilePage',
                params: {memberNo: res.data.memberNo.toString()}
          })
      })
      .catch(()=>{
          alert('프로필사진 수정 실패')
      })
    }
  }
}
</script>

<style scoped>





</style>
