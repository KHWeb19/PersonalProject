<template>
   <div >
      <v-layout justify-center>

            <v-dialog  v-model="findPw" resisten max-width="500px">
               <template v-slot:activator="{ on }">
               <v-btn id="findPw" v-on="on">
                  회원 탈퇴
               </v-btn>
               </template>
               <v-card >
                  <v-card-title>
                     정말 탈퇴하시겠습니까?
                  </v-card-title>
               <br>
                  <v-card-actions>
                     <v-btn color="blue" text @click="onDelete">
                           예
                     </v-btn>
                     <v-btn color="blue" text @click="location.href=''">
                           아니오
                     </v-btn>
                  </v-card-actions>
               </v-card>
            </v-dialog>
      </v-layout>
   </div>
</template>

<script>
import axios from 'axios'

export default {
   name: "FindPwPopUp",
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
   methods: {
       pwCheck(){

       },
       onDelete(){
           const{ memberNo } = this.$store.state.userInfo
           axios.delete(`http://localhost:7777/jpaMember/${memberNo}`)
                .then(() => {
                    alert('탈퇴가 완료 되었습니다!')
                    localStorage.removeItem("userInfo")
                    localStorage.removeItem("token")
                     this.$cookies.remove("user")
                     this.isLogin = false
                     this.$store.state.userInfo = null
                    this.$router.push({ name: 'Home' })
                    history.go(0)
                })
                .catch(() => {
                    alert('탈퇴 실패! 문제가 발생했습니다.')
                })
       }
   }
    
}
</script>

<style scoped>
    #comparePw {
      width: 300px;
      margin: 10px;
      border: 2px solid;
      font-size: 100%;
    }
</style>