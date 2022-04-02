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
// import {FETCH_COOKIE_MEMBER} from "@/store/mutation-types";

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
  methods: {
    async onSubmit(payload) {
      if (!this.checkUserInfo(payload, this.$store.state.userInfo) && !this.isLogin) {
        //if(!this.isLogin) {
        const {id, pw} = payload;
        await axios.post('http://localhost:7777/join/login', {id, pw})
            .then(res => {
              console.log(res.data)
              if (!res.data.checkId) {
                alert('아이디나 비밀번호가 틀렸습니다.')
              } else {
                //this.$store.state.userInfo = res.data;
                //this.$store.commit([FETCH_COOKIE_MEMBER], payload.id);
                this.$cookies.set("user", res.data.id, 120)
                //this.updateCookie(res.data.id);
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
      /*
      if(userInfo !== null) {
        userInfo.forEach(user => {
          if (user.id === payloadId.id)
            return true;
        })
        return false;
      }*/

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