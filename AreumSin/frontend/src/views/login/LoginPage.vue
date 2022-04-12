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
      userId: this.$cookies.get("user"),
    }
  },
  mounted() {
    this.$store.state.userInfo = this.$cookies.get("user")
  },
  methods: {
    async onSubmit(payload) {
        if(localStorage.getItem("session") == null) {
        //if(localStorage.getItem("session") === payload.id || this.checkLoginUser(payload.id)) {
        const {id, pw} = payload;
        await axios.post('http://localhost:7777/join/login', {id, pw})
            .then(res => {
              console.log(res.data)
              if (res.data.id == null) {
                alert('아이디나 비밀번호가 틀렸습니다.')
              } else {
                localStorage.setItem("userInfo", JSON.stringify(res.data))
                localStorage.setItem("session", res.data.id);
                //this.$store.commit('addUser', res.data.id);
                this.$router.push({name: 'PlanView', params: {id: res.data.id}});
              }
            })
            .catch(() => {
              alert('오류다 임마!')
            })
      } else {
        alert('이미 로그인 되어 있습니다.')
      }
    },
/*     checkLoginUser(payloadId){
      if (this.$store.state.userInfo != null){
        for(let i =0;  i < this.$store.state.userInfo.length; i++){
          if(this.$store.state.userInfo[i].id === payloadId){
            return false;
          }
        }
        return true;
      }
    }*/
  },

}
</script>

<style scoped>

</style>