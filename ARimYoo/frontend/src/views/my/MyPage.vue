<template>
    <v-container class="title">
        <v-row justify="center">
            <img class="titleImg" src="@/assets/title/MyPageTitle.png" width=250 >
            <v-btn @click="onDelete" class="exit" fab color="red darken-2" ><v-icon color="white"> mdi-minus </v-icon> </v-btn>
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
        },
         onDelete () {
            const { memberNo } = this.userInfo
            //alert('지우는 게시물 번호: ' + boardNo)
            var result = confirm('정말 탈퇴하시겠습니까?')
            if(result) {
            axios.delete(`http://localhost:7777/Member/${memberNo}`)
                    .then(() => {
                        
                        if(result){  
                            alert('탈퇴되었습니다. 안녕히가세요.')
                        localStorage.removeItem("userInfo")
                        localStorage.removeItem("token")
                        this.$router.push({ name: 'MainVellupPage' })
                        history.go(0)
                        }
                      
                    })
                    .catch(() => {
                        alert('탈퇴 실패! 문제 발생!')
                    })
            }
        }
    }
}
</script>

<style scoped>
.title {
    margin-top:3%;
}
.titleImg {
    margin-bottom:20px;
}
.exit {
    position: absolute;
    left: 80%;
    top:4%;
}
@media (max-width:700px){
    .exit {
        top:4%;
        margin-left:10px;
        zoom:70%;
    }
    .titleImg {
        margin-top:10px;
        margin-left:20px;
        width:200px;
    }
}
</style>