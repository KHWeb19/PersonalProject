<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit">
      <v-row justify="center">
            <v-col xs="12" sm="6" md="6">
          <v-card class="pa-3">
             <v-subheader style="dark">EDIT MY INFORM</v-subheader>
            <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-text-field :value="userInfo.id" label="ID" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="password" label="Password" :rules="user_pw_rule" required type="password"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="name" label="Name" required :rules="user_nm_rule"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="birth" label="Birth Day" :rules="user_birth_rule" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="phone" label="Phone Number" :rules="user_phone_rule" required></v-text-field>
                </v-col>
      <div id= "btn">
        <v-btn class="white--text" id="BtnModify" type="submit">회원 정보 수정</v-btn>
      </div><br>
          </v-card>
            </v-col>
      </v-row><br><br><br><br><br>
    </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: 'MypageEditForm',
  props: {
    member: {
      type: Object,
      required: true
    },
    userInfo: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      password: '',
      user_pw_rule: [
        v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
        v => !(v && v.length >= 30) || '패스워드는 30자 이상 입력할 수 없습니다.'
      ],
      name: '',
      user_nm_rule: [
        v => !!v || '이름은 필수 입력사항입니다.',
        v => !(v && v.length >= 30) || '이름은 30자 이상 입력할 수 없습니다.',
        v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '이름에는 특수문자를 사용할 수 없습니다.'
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
      const { password, name, birth, phone } = this
      this.$emit('submit', { password, name, birth, phone })
    }
  },
  created () {
    this.password = this.userInfo.password
    this.name = this.userInfo.name
    this.birth = this.userInfo.birth
    this.phone = this.userInfo.phone
  }
}
</script>

<style scoped>
#btn { text-align: center; font-size: 20px; }
#BtnModify { background-color: navy; width: 450px; height: 50px; }
</style>
