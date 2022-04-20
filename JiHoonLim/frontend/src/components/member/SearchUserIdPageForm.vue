<template>
  <div class="grey lighten-3" style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1240px">
      <v-row justify="center">
        <v-col cols="auto" style="padding-bottom: 90px">
          <router-link to="/">
            <v-img
              :src="require('@/assets/img/logo.png')"
              width="120"
              class="mx-auto mb-6"
            ></v-img>
          </router-link>
          <v-card width="460">
            <v-card-text class="text-center px-12 py-16">
              <validation-observer ref="observer" v-slot="{ invalid }">
                <v-form @submit.prevent="onSubmit">
                  <div class="text-h4 font-weight-black mb-10">ID 찾기</div>

                  <validation-provider
                    v-slot="{ errors }"
                    name="이메일"
                    :rules="{ email: true, required: true }"
                  >
                    <v-text-field
                      v-model="email"
                      label="이메일"
                      clearable
                      prepend-icon="mdi-email"
                      :error-messages="errors"
                    />
                  </validation-provider>
                  <v-btn
                    block
                    x-large
                    rounded
                    color="orange lighten-1"
                    class="mt-6"
                    @click="findUserId"
                    :disabled="invalid"
                  >
                    찾기</v-btn
                  >
                </v-form>
              </validation-observer>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "SearchUserIdPageForm",
  data() {
    return {
      email: "",
    };
  },
  methods: {
    findUserId() {
      const { email } = this;
      axios
        .post("http://localhost:7777/member/findUserId", { email })
        .then((res) => {
          this.userId = res.data;
          if (this.userId != "") {
            alert(`아이디는 ${this.userId} 입니다.`);
            this.$router.push("/login");
          } else {
            alert("찾으시는 아이디가 없습니다.");
          }
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
</style>
