<template>
   <v-dialog
      v-model="dialog"
      persistent
      max-width="500px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          outlined height="38" text
          color="deep-orange"
          v-bind="attrs"
          v-on="on"
        >
          회원가입
        </v-btn>
      </template>

      <v-card ref="form">
          <v-card-title >
          <span class="text-h5" > 회원 가입 </span>
        </v-card-title>
        <v-card-text>
            <v-container>
            <v-row>
              <v-col
                cols="12"
                sm="6"
              >
          <v-text-field
            ref="userId"
            v-model="userId"
            :rules="[
              () => !!userId || '필수 입력 항목입니다.',
              () => !!userId && userId.length <= 15 || '15자 이내로 입력해주세요.',
              userIdCheck
            ]"
            label="아이디"
            counter
            required
          ></v-text-field>
              </v-col>
              <v-col
                cols="12"
                sm="6"
              >
          <v-text-field
            ref="userPw"
            v-model="userPw"
            :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[() => !!userPw || '필수 입력 항목입니다']"
            :type="passwordShow ? 'text' : 'password'"
            label="비밀번호"
            counter
            @click:append="passwordShow = !passwordShow"
          ></v-text-field>
              </v-col>
              <v-col
                cols="12"
                sm="6"
              >
          <v-text-field
            ref="name"
            v-model="name"
            :rules="[rules.required, rules.name]"
            :error-messages="errorMessages"
            label="이름"
            required
          ></v-text-field>
              </v-col>
<v-col
                cols="12"
                sm="6"
              >
          <v-text-field
            ref="userEmail"
           v-model="email"
            :rules="[rules.required, rules.email, rules.counter]"
            label="이메일"
            required
          ></v-text-field>
</v-col>
<v-col >

          <v-autocomplete
            ref="region"
            v-model="region"
            :rules="[() => !!region || '필수 입력 항목입니다']"
            :items="region"
            label="거래 지역"
            placeholder="선택해주세요"
            required
          ></v-autocomplete>
</v-col>
            </v-row>
            </v-container>
        </v-card-text>
        <v-divider class="mt-8" > </v-divider>
        <v-card-actions>
          <v-btn text @click="dialog = false">
            취소
          </v-btn>
          <v-spacer />
          <v-slide-x-reverse-transition>
            <v-tooltip
              v-if="formHasErrors"
              left
            >
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  icon
                  class="my-0"
                  v-bind="attrs"
                  @click="resetForm"
                  v-on="on"
                >
                  <v-icon>mdi-refresh</v-icon>
                </v-btn>
              </template>
              <span>다시 입력하기</span>
            </v-tooltip>
          </v-slide-x-reverse-transition>
          <v-btn
            color="primary"
            text
            @click="submit" 
          >
            작성 완료
          </v-btn>
        </v-card-actions>
      </v-card>
</v-dialog>

  </template>
<script>
  export default {
    name: 'signUp',
    data: () => ({
      region: ['서울','경기','인천','부산','제주'],
      errorMessages: '',
      userId: null,
      userPw: null,
      name: null,
      formHasErrors: false,
      passwordShow: false,
      dialog: false,

      rules: {
          required: value => !!value || '필수 입력 항목입니다.',
          email: value => {
            const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return pattern.test(value) || '정상적인 이메일 주소를 입력해주세요.'
          },
      }

    }),

    computed: {
      form () {
        return {
          userId: this.userId,
          userPw: this.userPw,
          name: this.name,
          state: this.state,
          zip: this.zip,
          region: this.region,
        }
      },
      
    },

    watch: {
      name () {
        this.errorMessages = ''
      },
    },

    methods: {
      idCheck () {
        this.errorMessages = this.userId && this.userPw
          ? `아이디와 비밀번호를 다르게 입력해주세요.`
          : ''
        return true
      },
      resetForm () {
        this.errorMessages = []
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          this.$refs[f].reset()
        })
      },
      submit () {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          if (!this.form[f]) this.formHasErrors = true
          this.$refs[f].validate(true)
        })
      },
    },
  }
</script>
<style scoped>
</style>