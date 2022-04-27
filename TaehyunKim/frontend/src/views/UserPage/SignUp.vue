<template>
 <v-container>
        <v-row>
            <v-col cols="6" align-self="center">
                <img src="https://cdn.dribbble.com/users/483672/screenshots/6607992/browser_illo_3.png" width="100%">
            </v-col>
            
            <v-col cols="6" align-self="center">
              <v-form @submit.prevent="registerUser">
                    <v-row justify="center">
                      <v-col>
                        <v-card outlined>
                          <v-row class="ma-3 pa-3">
                            <v-col cols="12">
                              <div>Create an account</div>
                            </v-col>
                            <v-col cols="6">
                              <label>First Name</label>
                            </v-col>
                            <v-col cols="6">
                              <label>Last Name</label> 
                            </v-col>

                            <v-col cols="6">
                              <input type="text" v-model="first_name" placeholder="First name" @blur="v$.first_name.$touch">
                            <p v-if="v$.first_name.$error">{{v$.first_name.$errors[0].$message}}</p>
                            </v-col>
                            <v-col cols="6">
                              <input type="text" v-model="last_name" placeholder="Last name" @blur="v$.last_name.$touch">
                              <p v-if="v$.last_name.$error">{{v$.last_name.$errors[0].$message}}</p>
                            </v-col>
                            <v-col cols="12">
                              <label>Email</label>
                            </v-col>
                            <v-col cols="12">
                              <input type="text" placeholder="Email" @blur="v$.email.$touch" v-model.lazy="email">
                              <p v-if="v$.email.$errors.length">{{v$.email.$errors[0].$message}}</p>
                            </v-col>
                            <v-col cols="12">
                                <label>Username</label>
                            </v-col>
                            <v-col cols="12">
                                <input type="text" v-model.lazy="username" placeholder="Username" @blur="v$.username.$touch">
                                
                                <p v-if="v$.username.$errors.length">{{v$.username.$errors[0].$message}}</p>
                                
                            </v-col>
                            <v-col cols="12">
                                <label>Password</label>
                            </v-col>
                            <v-col cols="12">
                                <input type="password" v-model="password" placeholder="Password" @blur="v$.password.$touch">
                                <p v-if="v$.password.$error">{{v$.password.$errors[0].$message}}</p>
                            </v-col>
                            <v-col cols="12">
                            <v-btn @click="registerUser" class="primary">Register</v-btn>
                            </v-col>

                          </v-row>
                            
                        </v-card>
                      </v-col>
                  </v-row>
                </v-form>   
                   
            </v-col>
        </v-row>  
    </v-container>  
</template>

<script>
import axios from "axios"
import useVulidate from '@vuelidate/core'
import {required, minLength, maxLength, alpha, helpers} from '@vuelidate/validators'
import router from '@/router'

  const emailregex =  helpers.regex(/^([a-z\d-]{6,30})@([a-z]{2,8})\.([a-z]{2,8})(\.[a-z]{2,8})?$/)

  const isEmailTaken = (value) => axios.get('emailunique', {params: {email: value}}).then(res => {return res.data})
  const isUsernameTaken = (value) => axios.get('userunique', {params: {username: value}}).then(res => {return res.data})

  export default{
    name: 'SignUpPage',
    setup(){
      return {
        v$: useVulidate()
      }
    },

    data() {
        return {
            first_name: '',
            last_name: '',
            email: '',
            username: '',
            password: ''
        }
    },

    validations(){
      
      return {
        first_name: {
          required, alpha, minLength: minLength(2), 
          maxLength: maxLength(30), 
          },
        last_name: {
          required, alpha, minLength: minLength(2), maxLength: maxLength(30)
          },
        email: {
          required, 
          emailregex: helpers.withMessage('Invalid Email Format', emailregex),
          isEmailUnique: helpers.withMessage('Email already taken', helpers.withAsync(isEmailTaken))
        }
        ,
        username: {
          required, minLength: minLength(4), maxLength: maxLength(30),
          isUsernameUnique: helpers.withMessage('Username already taken', helpers.withAsync(isUsernameTaken))
          },
        password: {
          required, minLength: minLength(8), maxLength: maxLength(20)
          }
      }
    },

    methods:{
      async registerUser(){
          const isFormCorrect = await this.v$.$validate()

          if (!isFormCorrect){
            alert("Please check your input fields")
          }
          else{
            console.log("form correct")
            const {first_name, last_name, email, username, password} = this
            const payload = {first_name, last_name, email, username, password}
            axios.post('users/save', payload)
            .then(()=>{
              alert("Register Successful")
              router.push("/login")
            })
            .catch(()=>alert("Register Failed"))
          }
          
      }
    }
  }
</script>

<style scoped src="../../assets/css/signup.css">

</style>