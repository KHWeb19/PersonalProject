<template>
  <v-container class="spacing-playground pa-16">
    <login-page-form @submit="onSubmit"></login-page-form>
  </v-container>
</template>

<script>
import LoginPageForm from "@/components/login/LoginPageForm";
import axios from "axios";
import cookies from 'vue-cookies'
import Vue from "vue";

Vue.use(cookies)

export default {
  name: "LoginPage",
  components: {LoginPageForm},
  data(){
    return{
      isLogin: false,
      count: 1
    }
  },
  mounted() {
    this.$store.state.userInfo = this.$cookies.get("user")

    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    } else {
      this.isLogin = false
    }
  },
  methods:{
    onSubmit(payload){
      if(!this.checkUserInfo(payload.id, this.$store.state.userInfo)) {
      //if(!this.isLogin) {
        const {id, pw} = payload;
        axios.post('http://localhost:7777/join/login', {id, pw})
            .then(res => {
              console.log(res.data)
              this.$store.state.cookieNum += this.count;
              console.log(this.$store.state.cookieNum);
              if (!res.data.checkId) {
                alert('아이디나 비밀번호가 틀렸습니다.')
              } else {
                this.$store.state.userInfo = res.data;
                this.$cookies.set("user", res.data.id, 120)
                this.isLogin = true
                this.$router.push({name: 'HomeView'})
              }
            })
            .catch(res => {
              alert(res.response.data.message)
            })
      } else {
        alert('이미 로그인 되어 있습니다.')
      }
    },
    checkUserInfo(payloadId, userInfo) {
      if(userInfo !== null){
        if(userInfo === payloadId){
          return true;
        }
        return false;
      }
      return false;
    }
  }
}
</script>

<style scoped>

</style>