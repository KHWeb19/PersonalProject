<template>
  <v-dialog v-model="dialog" max-width="450">
    <template v-slot:activator="{ on }">
      <v-btn class="pa-6" color="secondary" v-on="on" icon>
        <v-icon>mdi-account-convert</v-icon>
      </v-btn>
    </template>
    <v-card class="rounded-xl pa-4">
      <v-card-title class="headline secondary--text font-weight-bold">
        <p>회원 정보 수정</p>
      </v-card-title>

      <v-card-text>
        <v-text-field ref="pw" color="secondary" label="Password" v-model="pw"
        :rules="pwRules" type="password" :error-messages="errorMessages" required></v-text-field>


        <v-text-field color="secondary" label="Name" v-model="name" 
        :rules="nameRules" required></v-text-field>

        <v-text-field color="secondary" label="Birth" v-model="birth" 
        :rules="birthRules" required></v-text-field>


        <v-text-field color="secondary" label="Email" v-model="email" 
        :rules="emailRules" required></v-text-field>

        <v-text-field color="secondary" label="Phone" v-model="phone" 
        :rules="phoneRules" required></v-text-field>

        <v-text-field color="secondary" label="Address" v-model="address" 
        :rules="addrRules" required></v-text-field>
      </v-card-text>

      <v-divider></v-divider>
      <v-card-actions>
        <v-btn @click="btnCancle" class="secondary--text font-weight-bold" text >
          Cancle
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="btnModify" class="secondary--text font-weight-bold" text>
          Modify
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>


<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
  data () {
    return {
      dialog: false,
      errorMessages: '',
      formHasErrors: false,
      pw: null,
      name: null,
      birth: null,
      email: null,
      phone: null,
      address: null,
    }
  },
  computed: {
    form () {
      return {
        pw: this.pw,
      }
    },
    ...mapState([
      'userInfo',
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
  mounted () {
    this.name = this.userInfo.name
    this.birth = this.userInfo.birth
    this.email = this.userInfo.email
    this.phone = this.userInfo.phone
    this.address = this.userInfo.address
  },
  methods: {
    ...mapActions([ 'fetchUserInfo' ]),
    btnCancle () {
      this.errorMessages = []
      this.formHasErrors = false,

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
      this.dialog = false
    },
    btnModify () {
      const pw = this.pw
      const name = this.name
      const birth = this.birth
      const email = this.email
      const phone = this.phone
      const address = this.address
      const id = this.userInfo.id
      
      axios.patch(`http://localhost:7777/member/mypage/modify/${id}`, { pw, name, birth, email, phone, address }).then(() => {
        alert('회원정보가 수정되었습니다.')

        this.dialog = false

        this.fetchUserInfo(id)

        console.log(this.userInfo.birth)
      })
    }
  }
}
</script>