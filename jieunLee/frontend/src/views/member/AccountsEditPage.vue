<template>
  <div>
    <div style="z-index: 1; position: fixed; top: 0; left: 0; right: 0;">
      <menu-bar/>
      <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
    </div>
    <div style="display: flex; justify-content: center;">
      <accounts-category/>
      <accounts-edit-form v-if="member" :member="member" @submit="onSubmit"/>
      <p v-else>로딩중......</p>
    </div>
    <footer-bar style=" text-align: center;"/>
  </div>
</template>

<script>
import AccountsEditForm from '@/components/member/AccountsEditForm.vue'
import AccountsCategory from '@/components/AccountsCategory.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import MenuBar from '@/components/MenuBar.vue'
import FooterBar from '@/components/FooterBar'

export default {
  name: 'AccountsEditPage',

  components: {
    AccountsEditForm,
    AccountsCategory,
    MenuBar,
    FooterBar
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
      const {memberName, memberId, imageName, memberWeb, memberIntro, passwordHint} = payload
      axios.put(`http://localhost:7777/member/${this.memberNo}`, 
      {memberName, memberId, password: this.member.password, passwordHint, imageName, memberWeb, memberIntro, regDate: this.member.regDate})
        .then(res => {
            alert('프로필 수정 성공')
            localStorage.removeItem("userInfo")
            localStorage.setItem("userInfo", JSON.stringify(res.data))
              this.$router.push({
                  name: 'MyProfilePage',
                  params: {memberNo: res.data.memberNo.toString()}
            })
        })
        .catch(()=>{
            alert('프로필 수정 실패')
        })
    },
  }
}
</script>
