<template>
  <div>
    <div style="display: flex; justify-content: center;">
        <find-password-form v-if="member" :member="member" @submit="onSubmit"/>
        <p v-else>로딩중......</p>
    </div>
    <footer-bar style="padding-top: 75px; text-align: center;"/>
  </div>
</template>

<script>
import FindPasswordForm from '@/components/member/FindPasswordForm.vue'
import FooterBar from '@/components/FooterBar'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
export default {
    name: 'FindPasswordPage',
    components: {
        FindPasswordForm,
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
            const {password} = payload
            axios.put(`http://localhost:7777/member/pw/${this.memberNo}`, 
                {memberName: this.member.memberName, memberId: this.member.memberId, password, passwordHint: this.member.passwordHint, imageName: this.member.imageName, memberWeb: this.member.memberWeb, memberIntro: this.member.memberIntro, regDate: this.member.regDate})
                .then(() => {
                    alert('비밀번호 변경 성공')
                    this.$router.push({name: 'LoginPage'})
                })
                .catch(()=>{
                    alert('비밀번호 변경 실패')
                })
            }
        }
}
</script> 