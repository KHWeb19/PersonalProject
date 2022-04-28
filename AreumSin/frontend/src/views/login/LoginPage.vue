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
import {mapState} from "vuex";

Vue.use(cookies)

export default {
  name: "LoginPage",
  components: {LoginPageForm},
  data(){
    return{
      userId: this.$cookies.get("user"),
      isLogin: false,
      user: ''
    }
  },
  mounted() {
    this.user = this.$cookies.get("user")

/*    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    } else {
      this.isLogin = false
    }*/

  },
  methods: {
    async onSubmit(payload) {
      console.log("payload.id" + payload.id);
        if(localStorage.getItem("session") == null || localStorage.getItem("session") === undefined) {
        //if(this.checkLoginUser(payload.id)) {
        //if(!this.isLogin) {
        //if(this.checkLoginUser(payload.id)) {
        const {id, pw} = payload;
        await axios.post('http://localhost:7777/join/login', {id, pw})
            .then(res => {
              if(res.data) {
                localStorage.setItem("session", res.data.id);

                /*console.log(this.userInfo);

              if(this.userInfo !== null) {
                for (let i = 0; i < this.userInfo.length; i++) {
                  this.user[i] = this.userInfo[i];
                }
              }
              this.user.push(res.data.id);
              console.log(this.user);

              this.$store.commit("addUser", this.user);*/
                this.$cookies.set("user", res.data, 30);
                this.$router.push({name: 'PlanListView', params: {id: res.data.id}});
              }else {
                alert('로그인 실패')
                this.$router.push({name: 'LoginPage'});
                this.$router.go();
              }
            })
            .catch((res) => {
              alert(res + "로그인 실패")
            })
      }/* else {
        alert('이미 로그인 되어 있습니다.')
      }*/
    },
/*     checkLoginUser(payloadId){
      console.log(this.userData)
      if (this.userData != null){
        for(let i = 0;  i < this.userData.length; i++){
          if(this.userData[i].id === payloadId){
            console.log("checkLoginUser() " + this.userData[i].id);
            return false;
          }
        }
        return true;
      }
      return true;
    }*/
  },
  computed: {
    ...mapState(['userInfo'])
  }

}
</script>

<style scoped>

</style>