<template>
  <div>
    <v-container>
      <v-card>
        <v-card-title> 회원가입 </v-card-title>
        <v-card-text>
          <validation-observer ref="observer" v-slot="{ invalid }">
            {{ invalid }}
            <v-form @submit,prevent="submit">
              <validation-provider
                rules="max:12|required"
                v-slot="{ errors }"
                name="아이디"
              >
                <v-text-field
                  type="text"
                  v-model="id"
                  label="아이디"
                  :counter="12"
                  :error-messages="errors"
                >
                </v-text-field>
              </validation-provider>

              <validation-provider
                v-slot="{ errors }"
                name="비밀번호"
                :rules="{
                  required: true,
                  max: 15,
                }"
              >
                <v-text-field
                  type="password"
                  v-model="pw"
                  label="비밀번호"
                  :counter="15"
                  :error-messages="errors"
                ></v-text-field>
              </validation-provider>

              <validation-provider>
                <v-text-field label="비밀번호 확인"></v-text-field>
              </validation-provider>

              <validation-provider
                v-slot="{ errors }"
                name="이메일"
                :rules="{
                  required: true,
                  email: true,
                }"
              >
                <v-text-field
                  v-model="email"
                  label="이메일"
                  :error-messages="errors"
                ></v-text-field>
              </validation-provider>

              <v-btn
                type="submit"
                class="mr-4"
                color="orange lighten-1"
                :disabled="invalid"
                >가입</v-btn
              >
              <v-btn>취소</v-btn>
            </v-form>
          </validation-observer>
        </v-card-text>
      </v-card>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "SignUpPage",

  data() {
    return {
      id: null,
      pw: null,
      email: null,
    };
  },
  methods: {
    submit() {
      this.$refs.observer.validate().then((res) => {
        if (res) {
          alert("가입 완료");
        }
      });
    },
  },
};
</script>
