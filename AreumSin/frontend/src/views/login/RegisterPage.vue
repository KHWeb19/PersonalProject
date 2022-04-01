<template>
  <v-container class="spacing-playground pa-16">
    <register-page-form @submit="onSubmit" @check="checkDouble" v-bind:checkId="checkDoubleId" :checkJoin="checkJoin"></register-page-form>
  </v-container>

</template>

<script>
import RegisterPageForm from "@/components/login/RegisterPageForm";
import axios from "axios";
export default {
  name: "RegisterPage",
  components: {RegisterPageForm},
  data() {
    return{
      checkDoubleId: true,
      checkJoin: false
    }
  },
  methods:{
    onSubmit(payload){
      const {id, pw, name, birth, color} = payload
      try{
        axios.post('http://localhost:7777/join/register', {id, pw, name, birth, color});
        alert('가입 축하드립니다.')
        this.$router.push({name: 'LoginPage'});
      }catch (error){
        console.log(error);
      }
    },
    async checkDouble(payload){
      const {id} = payload;
      let response = await axios.get(`http://localhost:7777/join/${id}`)
        if(response.data === true){
          alert('중복입니다.')
          this.checkDoubleId = true;
        }else{
          alert('중복이 아닙니다.')
          this.checkDoubleId = false;
        }
    }
  }
}
</script>

<style scoped>

</style>