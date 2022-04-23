<template>
  <v-container style="height: 100%">
    <form @submit.prevent="onSubmit">
      <div>
        <v-stepper v-model="e1">
          <v-stepper-header>
            <v-stepper-step :complete="e1 > 1" step="1"
              >개인정보 수집∙이용 동의</v-stepper-step
            >

            <v-divider></v-divider>

            <v-stepper-step step="2">사용자 정보 입력</v-stepper-step>
          </v-stepper-header>

          <v-stepper-items>
            <v-stepper-content step="1">
              <v-card class="card-box" color="grey lighten-1">
                <h5>
                  개인정보처리자는 다음의 어느 하나에 해당하는 경우에는
                  개인정보를 수집할 수 있으며 그 수집 목적의 범위에서 이용할 수
                  있습니다 (「개인정보 보호법」 제15조제1항). 정보주체의 동의를
                  받은 경우 법률에 특별한 규정이 있거나 법령상 의무를 준수하기
                  위하여 불가피한 경우 공공기관이 법령 등에서 정하는 소관 업무의
                  수행을 위하여 불가피한 경우 정보주체와의 계약의 체결 및 이행을
                  위하여 불가피하게 필요한 경우 정보주체 또는 그 법정대리인이
                  의사표시를 할 수 없는 상태에 있거나 주소불명 등으로 사전
                  동의를 받을 수 없는 경우로서 명백히 정보주체 또는 제3자의
                  급박한 생명, 신체, 재산의 이익을 위하여 필요하다고 인정되는
                  경우 개인정보처리자의 정당한 이익을 달성하기 위하여 필요한
                  경우로서 명백하게 정보주체의 권리보다 우선하는 경우. 이 경우
                  개인정보처리자의 정당한 이익과 상당한 관련이 있고 합리적인
                  범위를 초과하지 않은 경우에 한함 ※ 이를 위반하여 개인정보를
                  수집한 자는 5천만원 이하의 과태료를 부과받습니다(「개인정보
                  보호법」 제75조제1항제1호).
                </h5>
              </v-card>
              <div class="btn-size">
                <v-btn
                  width="320"
                  height="50"
                  type="submit"
                  color="blue"
                  style="float: left; margin-top: 6%"
                  class="white--text"
                  rounded
                  @click="e1 = 2"
                >
                  Continue
                </v-btn>

                <v-btn
                  width="320"
                  height="30"
                  color="blue darken-4"
                  style="float: left; margin-top: 6%"
                  class="white--text"
                  route
                  :to="'/hawul'"
                  text
                  plain
                  >Cancel</v-btn
                >
              </div>
            </v-stepper-content>
            <v-stepper-content step="2">
              <v-card class="card-box">
                <h2>Create Account</h2>
                <p>Please enter your information</p>
                <div justify-center>
                  <v-container style="width: 90%">
                    <v-text-field
                      solo
                      flat
                      v-model="userName"
                      type="text"
                      required
                      height="3vh"
                      dense
                      label="Name"
                      :rules="rules_name"
                    ></v-text-field>
                    <v-text-field
                      solo
                      flat
                      v-model="userId"
                      type="text"
                      required
                      height="3vh"
                      dense
                      label="ID (not Email Format)"
                      :rules="rules_id"
                    ></v-text-field>
                    <v-text-field
                      solo
                      flat
                      v-model="password"
                      type="Password"
                      required
                      height="3vh"
                      dense
                      label="Password"
                      :rules="rules_pw"
                    ></v-text-field>
                    <v-text-field
                      solo
                      flat
                      v-model="passwordReInput"
                      type="Password"
                      required
                      height="3vh"
                      dense
                      label="Repeat-Password"
                      :rules="rules_pw2"
                    ></v-text-field>
                    <v-text-field
                      solo
                      flat
                      v-model="userPhone"
                      type="text"
                      required
                      height="3vh"
                      dense
                      label="Phone"
                      :rules="rules_call"
                    ></v-text-field>

                    <div class="btn-size">
                      <v-btn
                        width="300"
                        height="50"
                        type="submit"
                        color="blue"
                        style="float: left; margin-top: 6%"
                        class="white--text"
                        rounded
                      >
                        SIGN UP
                      </v-btn>
                      <v-btn
                        width="300"
                        height="30"
                        color="blue darken-4"
                        style="float: left; margin-top: 6%"
                        class="white--text"
                        route
                        :to="'/hawul'"
                        text
                        plain
                      >
                        Cancel
                      </v-btn>
                    </div>
                  </v-container>
                </div>
              </v-card>
            </v-stepper-content>
          </v-stepper-items>
        </v-stepper>
      </div>
    </form>
  </v-container>
</template>

<script>
export default {
  name: "MemberRegisterForm",
  data() {
    return {
      e1: 1,
      kindsOfMember: ["개인", "사업자"],
      id: "",
      pw: "",
    };
  },
  methods: {
    onSumnit() {
      const { userName, userId, password, passwordReInput, userPhone, auth } =
        this;
      this.$emit("submit", {
        userName,
        userId,
        password,
        passwordReInput,
        userPhone,
        auth,
      });
    },
  },
};
</script>

<style scoped>
register-box {
  border: 1px solid;
  float: left;
  width: 500px;
  height: 500px;
}
.btn-size {
  position: relative;
  left: 13%;
}
.card-box {
  height: 100%;
  text-align: center;
}
body {
  font-family: "Montserrat", sans-serif;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: -20px 0 50px;
  margin-top: 20px;
}
h1 {
  font-weight: bold;
  margin-bottom: 2%;
  font-family: "Questrial";
}
h2 {
  font-weight: bold;
  margin-bottom: 2%;
  font-family: "Questrial";
}
p {
  margin-bottom: 2%;
}
</style>