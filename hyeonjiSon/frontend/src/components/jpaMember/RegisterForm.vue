<template>
<div align="center">
  <v-container>
    <form @submit.prevent="onSubmit">
      
      <br>
      <p>나눔 받는 페이지에 게시글을 작성하고 싶으신가요?</p>

      <br>

      <div class="input_area">
        <v-text-field v-model="id" style="width:350px" placeholder=" *ID를 입력해주세요." :rules="rulesId">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="sn" style="width:350px" placeholder=" *상호명을 입력해주세요." :rules="rulesSn">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field type="password" style="width:350px" v-model="pw" placeholder=" *8~14자리로 작성하세요." :rules="rulesPw">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="pwConfirm" style="width:350px" placeholder=" *가장 좋아하는 과일은?" :rules="rulesPwc">
        </v-text-field></div>

      <br>
      
      <div>
        <button type="submit">가입하기</button>
      </div>

      <div>
        <p>이미 계정이 있습니까? &nbsp;
            <router-link :to="{ name: 'memberLoginPage' }">
              로그인 하기
            </router-link>
        </p>

      </div>

    </form>
  </v-container>
</div>
</template>

<script>

export default {
  name: "RegisterForm",
  data () {
    return {
      id: '',
      sn: '',
      pw: '',
      pwConfirm: '',

      rulesId:[
          v => !!v || 'ID 입력은 필수입니다.'
      ],
      rulesSn:[
          v => !!v || '상호명 입력은 필수입니다.',
          v => v.length >= 3 || 'Password must be less than 3 characters'     
      ],
      rulesPw:[
          v => !!v || '비밀번호 입력은 필수입니다.',
          v => v.length >= 8 && v.length <=14 || '8자리 이상 14자리 이하로 입력하세요.'     
      ],
      rulesPwc:[
          v => !!v || '비밀번호 질문의 답은 필수입니다.'
      ]
    }
  },
  methods: {
    onSubmit () {
      const { id, sn, pw, pwConfirm } = this
      this.$emit('submit', { id, sn, pw, pwConfirm })
    }
  }
}

</script>

<style scoped>
    button {
      margin: 15px;
      height: 50px;
      width: 350px;
      background-color: lightblue;

      font-size: 120%;
      color: white;
    }
    a {
      -webkit-text-stroke: 1px;
      text-decoration: none; } 
</style>