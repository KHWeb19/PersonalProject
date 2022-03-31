<template>
  <v-container class="spacing-playground pa-16">
    <register-page-form @submit="onSubmit" @check="checkDouble"></register-page-form>
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
      title: '',
    }
  },
  methods:{
    onSubmit(payload){
      const {id, pw, name, birth, color} = payload
      axios.post('http://localhost:7777/join/register', {id, pw, name, birth, color})
        .then(() => {
          alert('가입완료')
          this.$router.push({name: 'HomeView'})
        })
        .catch(res => {
          alert(res.response.data.message)
        })
    },
    checkDouble(payload){
      const {id} = payload;

      axios.get(`http://localhost:7777/join/${id}`)
      .then((res) => {
        this.check = res;
      })

      if(this.check) {
        alert("중복아님")
      }else{
        alert("중복")
      }

    }
  }
}
</script>

<style scoped>

</style>