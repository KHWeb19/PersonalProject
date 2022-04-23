<template>
  <div>
    <v-dialog v-model="dialog" max-width="450">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" text>회원가입</v-btn>
      </template>
    
      <v-card ref="form" class=" rounded-xl pa-0" >
        <v-card-title>
          <span class="headline secondary--text font-weight-bold">Signup</span>
        </v-card-title>
        
        <v-card-text>
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          :rules="idRules" :error-messages="errorMessages" required></v-text-field>
          <!--
          <v-btn @click="checkId">아이디 확인</v-btn>
          -->

          <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
          :rules="pwRules" type="password" required></v-text-field>

          <!--
          <v-text-field ref="mpw" color="secondary" label="Password" v-model="mpw"
          :rules="matchPwRules" type="password" required></v-text-field>
          -->

          <v-text-field ref="name" color="secondary" label="Name" v-model="name" 
          :rules="nameRules" required></v-text-field>

          <!--
          <v-text-field ref="birth" color="secondary" label="Birth" v-model="birth" 
          :rules="birthRules" required></v-text-field>
          -->

          <v-menu ref="menu" v-model="menu" :close-on-content-click="false"
            :return-value.sync="date" transition="scale-transition" offset-y min-width="auto">
            <template v-slot:activator="{ on }">
              <v-text-field ref="birth" color="secondary" label="Birth" v-model="date"
                v-on="on" append-icon="mdi-calendar" :rules="birthRules" required></v-text-field>
            </template>
            <v-date-picker color="secondary" v-model="date" no-title scrollable>
              
              <v-btn text color="secondary" @click="menu = false">
                Cancel
              </v-btn>
              <v-spacer></v-spacer>
              <v-btn text color="secondary" @click="$refs.menu.save(date)">
                OK
              </v-btn>
            </v-date-picker>
          </v-menu>

          <v-text-field ref="email" color="secondary" label="Email" v-model="email" 
          :rules="emailRules" required></v-text-field>

          <v-text-field ref="phone" color="secondary" label="Phone" v-model="phone" 
          :rules="phoneRules" required></v-text-field>

          <v-text-field ref="address" color="secondary" label="Address" v-model="address" 
          :rules="addrRules" required></v-text-field>

    

        </v-card-text>
      
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn @click="resetForm" class="secondary--text font-weight-bold" text>cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnSignup" class="secondary--text font-weight-bold" text>signup</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>


<script>
import { mapState } from 'vuex'
import axios from 'axios'

export default {
  name: 'SignupForm',
  data () {
    return {
      dialog: false,
      id: null,
      pw: null,
      name: null,
      //birth: null,
      date: null,
      email: null,
      phone: null,
      address: null,
      errorMessages: '',
      formHasErrors: false,
      menu: false
    }
  },
  computed: {
    form () {
      return {
        id: this.id,
        pw: this.pw,
        name: this.name,
        //birth: this.birth,
        birth: this.date,
        email: this.email,
        phone: this.phone,
        address: this.address
      }
    },
    ...mapState([
      'idRules',
      'pwRules',
      'matchPwRules',
      'nameRules',
      'birthRules',
      'emailRules',
      'phoneRules',
      'addrRules'
    ])
  },
  watch: {
    id () {
      this.errorMessages = ''
    }
  },
  methods: {
    resetForm () {
      this.errorMessages = []
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    },
    btnSignup () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true

        this.$refs[f].validate(true)
      })
        
      axios.post('http://localhost:7777/member/signup', this.form)
      .then(() => {
        alert('회원가입이 완료되었습니다.')

        this.dialog = false
      }).catch(res => {
        alert(res)
      })
      
    },
    checkId () {
      
    }
  }
}
  </script>
