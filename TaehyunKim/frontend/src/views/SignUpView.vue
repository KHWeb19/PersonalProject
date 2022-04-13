<template>
  <sign-up-component @submitted="sending"></sign-up-component>
</template>

<script>
import SignUpComponent from "../components/SignUpComponent.vue"
import axios from "axios"

  export default{
    name: 'SignUpView',
    
    components: {
        SignUpComponent
    },

    methods:{
      sending(payload){
          axios.post('http://localhost:1234/api/users/save', payload)
          .then(()=>alert("Register Successful"))
          .catch(()=>alert("Register Failed"))
      }
    }
  }
</script>
