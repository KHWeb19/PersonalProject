<template>
  <v-sheet>
    <v-dialog v-model="dialog" max-width="450">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" icon class="float-right">
          <h2>Login</h2>
        </v-btn>
      </template>
    
      <v-card ref="form" class="rounded-xl pa-4" >
        <v-card-title>
          <span class="headline secondary--text font-weight-bold">Login</span>
        </v-card-title>
        <v-card-text>
          <v-text-field ref="id" color="secondary" label="Id" v-model="id" 
          :rules="idRules" :error-messages="errorMessages" required></v-text-field>
          <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
          :rules="pwRules" type="password" required></v-text-field>
        </v-card-text>

        <signup></signup>
        
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text>cancel</v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="btnLogin" class="secondary--text font-weight-bold" text>login</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-sheet>
</template>


<script>
import axios from 'axios'
import Signup from '@/views/member/Signup'
import { mapActions, mapState } from 'vuex'


export default {
  name: 'LoginPage',
  components: {
    Signup
  },
  data () {
    return {
      dialog: false,
      id: null,
      pw: null,
      errorMessages: '',
      formHasErrors: false,
    }
  },
  mounted () {
    this.fetchSession(this.$cookies.get('session'))
    
    if (this.session != null) {
      this.$store.state.isLogin = true
      this.$store.state.userInfo = this.fetchUserInfo(this.$cookies.get('session')) 
    }
  },
  computed: {
    form () {
      return {
        id: this.id,
        pw: this.pw
      }
    },
    ...mapState([ 'idRules', 'pwRules', 'session' ])
  },
  watch: {
    id () {
      this.errorMessages = ''
    }
  },
  methods: {
    ...mapActions ([ 'fetchUserInfo', 'fetchSession' ]),

    btnLogin () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true

        this.$refs[f].validate(true)
      })

      const id = this.id
      const pw = this.pw
      
      axios.post('http://localhost:7777/member/login', { id, pw }).then(res => {
        
        if (res.data) {
          
          this.$store.commit('USER_LOGIN', res.data)
         
          
          this.fetchUserInfo(id)
         // this.$cookies.set("session", {id , pw}, 30)
          this.dialog = false
          alert('로그인이 완료되었습니다!')
          
          // recommend(together) 로 보냄
         // this.$emit('onLogin')


        } else if (res.data == false) {
          alert('아이디와 비밀번호를 확인해주세요!')

          console.log('isLogin: ' + res.data)
        }
        
      }).catch(err => {
        alert(err)
      })
      
    },
    btnCancle () {
      this.errorMessages = []
      this.formHasErrors = false,

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    }
  }
}  
</script>

