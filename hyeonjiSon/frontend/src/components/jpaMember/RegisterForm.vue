<template>
  <v-container>
    <form @submit.prevent="onSubmit">
      
      <br> 
      <div class="box change" style="width: 20%">
        <v-radio-group v-model="radioGroup" row>
          <!-- 기존에 사용하던 형식의 문법이 마겨서 아래와 같이 작업해야함
               다소 번거로움이 추가됨 -->
          <v-radio :label="`${kindsOfMember[0]}`" :value="`${kindsOfMember[0]}`"></v-radio>
          <v-radio :label="`${kindsOfMember[1]}`" :value="`${kindsOfMember[1]}`"></v-radio>
        </v-radio-group>
      </div>
      <br>

      <div class="input_area">
        <v-text-field v-model="id" label="아이디" style="width:350px" placeholder=" *ID를 입력해주세요." :rules="rulesId">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="sn" label="닉네임/상호명" style="width:350px"
        placeholder=" *닉네임 혹은 (사업자)상호명을 입력해주세요." :rules="rulesSn">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="city" label="거주 시" style="width:350px"
        placeholder=" *거주 시 입력(예: 서울시, 광주시, 울산시)" :rules="rulesBuis">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="dong" label="거주 동" style="width:350px"
        placeholder=" *거주 동 입력(예: 대방동, 청당동)" :rules="rulesBuis">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="address" label="나머지 주소" style="width:350px"
        placeholder=" *시, 동을 제외한 나머지 주소 입력" :rules="rulesBuis">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field type="password" label="비밀번호" style="width:350px" v-model="pw" placeholder=" *8~14자리로 작성하세요." :rules="rulesPw">
        </v-text-field></div>

      <div class="input_area">
        <v-text-field v-model="pwConfirm" label="비밀번호 질문" style="width:350px" placeholder=" *가장 좋아하는 과일은?" :rules="rulesPwc">
        </v-text-field></div>

      <br>
      
      <div>
        <button type="submit">가입하기</button>
      </div>

      <div>
        <p>이미 계정이 있습니까? &nbsp;
            <router-link style="color: darkKhaki " id="router" :to="{ name: 'memberLoginPage' }">
              로그인 하기
            </router-link>
        </p>

      </div>

    </form>
  </v-container>
</template>

<script>

export default {
  name: "RegisterForm",
  data () {
    return {
      id: '',
      sn: '',
      city: '',
      dong: '',
      address: '',
      pw: '',
      pwConfirm: '',
      radioGroup: 1,
      kindsOfMember: [
        '개인', //0
        '사업자' //1
      ],

      rulesId:[
          v => !!v || 'ID 입력은 필수입니다.'
      ],
      rulesSn:[
          v => !!v || '닉네임/상호명 입력은 필수입니다.',
          v => v.length >= 3 || 'Password must be less than 3 characters'     
      ],
      rulesPw:[
          v => !!v || '비밀번호 입력은 필수입니다.',
          v => v.length >= 8 && v.length <=14 || '8자리 이상 14자리 이하로 입력하세요.'     
      ],
      rulesPwc:[
          v => !!v || '비밀번호 질문의 답은 필수입니다.'
      ],
      rulesBuis:[
          v => !!v || '사업자 회원 필수 입력사항입니다.'
      ],
    }
  },
  methods: {
    onSubmit () {
      const { id, sn, city, dong, address, pw, pwConfirm, radioGroup } = this
      const auth = (radioGroup == '개인' ? '개인' : '사업자')
      this.$emit('submit', { id, sn, city, dong, address, pw, pwConfirm, auth })
    }
  }
}

</script>

<style scoped>
.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }


  .change input, .change progress {
    accent-color: red;
  }

    button {
      margin: 15px;
      height: 50px;
      width: 350px;
      background-color: #ccbce3;

      font-size: 120%;
      color: white;
    }
    a { 
      -webkit-text-stroke: 1px;
      text-decoration: none; } 
</style>