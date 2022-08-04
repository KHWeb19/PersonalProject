<template>
    <body>
      <form @submit.prevent="onSubmit">
        <v-container>
          <v-row justify="center">
            <v-col xs="12" sm="6" md="6">
          <v-card class="pa-3">
             <v-subheader style="dark">SIGN UP</v-subheader>
            <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-row>&nbsp;&nbsp;&nbsp;
              <v-text-field
                v-model="id"
                  class ="text-center"
                  label="ID"
                  :rules="user_id_rule"
                  required
              ></v-text-field>&nbsp;&nbsp;&nbsp;&nbsp;
              <v-btn class="white--text" id="BtncheckID" type="button" @click="checkID" v-bind:disabled="id == ''">중복체크</v-btn>
                  </v-row>
                </v-col>
    <v-col cols="12">
      <v-text-field
      v-model="password"
        label="Password"
        type="password"
        :rules="user_pw_rule"
        ></v-text-field>
    </v-col>
     <v-col cols="12">
              <v-text-field
                v-model="name"
                  label="Name"
                  :rules="user_nm_rule"
                  required
              ></v-text-field>
    </v-col>
    <v-col cols="12">
      <v-text-field
      v-model="birth"
        label="Brith Day"
        :rules="user_birth_rule"
        required
        ></v-text-field>
    </v-col>
    <v-col cols="12">
      <v-text-field
      v-model="phone"
        label="Phone Number"
        :rules="user_phone_rule"
        required
        text-align = "center"
        ></v-text-field>
    </v-col>
    <v-col cols="12">
      <v-select
      v-model="auth"
        label="Auth"
        :items="authList"
        item-text="name"
        item-value="value"
        return-object
        :rules="user_auth_rule"
        ></v-select>
    </v-col>
      <div id= "btn">
        <v-btn class="white--text" type="submit" id = "BtnsignUp" v-bind:disabled="BtncheckID == ''">회원가입</v-btn>
      </div><br>
          </v-card>
            </v-col>
          </v-row><br><br><br><br><br>
        </v-container>
    </form>
</body>

</template>

<script>
import axios from 'axios'
export default {
  name: "MemberRegister",
  data () {
    return {
      dialog: false,
      authList: ['개인', '관리자'],
      id: '',
      user_id_rule: [
        v => !!v || '아이디는 필수 입력사항입니다.',
        v => /^[a-zA-Z0-9]*$/.test(v) || '아이디는 영문+숫자만 입력 가능합니다.',
        v => !(v && v.length >= 15) || '아이디는 15자 이상 입력할 수 없습니다.'
      ],
      name: '',
      user_nm_rule: [
        v => !!v || '이름은 필수 입력사항입니다.',
        v => !(v && v.length >= 30) || '이름은 30자 이상 입력할 수 없습니다.',
        v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '이름에는 특수문자를 사용할 수 없습니다.'
      ],
      password: '',
      user_pw_chk: '',
      user_pw_rule: [
        v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
        v => !(v && v.length >= 30) || '패스워드는 30자 이상 입력할 수 없습니다.'
      ],
      auth: '',
      user_auth_rule: [
        v => !!v || '권한은 필수 선택 사항입니다.'
      ],
      birth: '',
      user_birth_rule: [
        v => !!v || '생일은 필수 입력사항입니다.',
        v => (v && v.length === 8) || '생일은 8글자 형식으로 맞추십시오.',
        v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '생일에는 특수문자를 사용할 수 없습니다.'
      ],
      phone: '',
      user_phone_rule: [
        v => !!v || '연락처는 필수 입력사항입니다.',
        v => (v && v.length === 11) || '연락처는 11글자 형식으로 맞추십시오.',
        v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '생일에는 특수문자를 사용할 수 없습니다.'
      ]
    }
  },
  methods: {
    onSubmit () {
      const { id, password, name, birth, phone, auth } = this
      this.$emit('submit', { id, password, name, birth, phone, auth })
    },
    checkID () {
      const { id } = this
      axios.post('http://localhost:7777/member/checkId', { id })
        .then(res => {
          if (res.data) {
            alert('사용가능한 ID입니다')
          } else {
            alert('사용할 수 없는 ID입니다. 다시 입력하세요.')
          }
        })
        .catch(res => {
          alert('ID를 입력하세요')
        })
    }
  }
}
</script>

<style scoped>
#v-text-field { text-align: center;}
#btn { text-align: center; font-size: 20px; }
#BtncheckID { background-color: navy; width: 130px; height: 40px;}
#BtnsignUp { background-color: navy; width: 500px; height: 55px;}
h2 { text-align: center;}
.text-center { text-align: center; }
</style>
