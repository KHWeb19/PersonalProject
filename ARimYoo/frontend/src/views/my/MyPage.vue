<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="align-center" src="@/assets/title/MyPageTitle.png" width=250 >
        </v-row>
        <br/>
        <v-divider/>
        <br/>
        <v-row>
            <member-info :userInfo="userInfo" @submit="onSubmit"/>
        </v-row>
    </v-container>
</template>

<script>
import MemberInfo from '@/components/form/MemberInfo.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'

export default  {
    name:'MyPage',
    components: {
        MemberInfo
    },
     computed: {
        ...mapState(['userInfo'])
    },
    created() {
        this.fetchMember(this.$store.state.userInfo.memberNo)
        .catch(() => {
            alert ('유저정보 불러오기 실패 !')
        })
    },
   
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            const { pw, name, birth, intro } = payload

            axios.put(`http://localhost:7777/Member/${this.$store.state.userInfo.memberNo}`,
                { id: this.$store.state.userInfo.id, pw, name, birth, intro})
                    .then(res => {
                        alert('회원정보 수정 성공!')
                        localStorage.removeItem("userInfo")
                        localStorage.setItem("userInfo", JSON.stringify(res.data))
                        history.go(0)
                    })
                    .catch(() => {
                        alert('회원정보 수정 실패!')
                    })
        }
    }
}
</script>

<style scoped>
.title {
    margin-top:3%;
}
</style>