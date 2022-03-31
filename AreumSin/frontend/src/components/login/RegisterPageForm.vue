<template>
  <v-card class="spacing-playground pa-6">
    <v-row justify="center">
      <v-card-title style="font-size: 50px; margin-bottom: 15px; margin-top: 15px">회원가입<br/></v-card-title>
    </v-row>
    <v-row justify="center">
      <form @submit="onSubmit">
        <table>
          <tr>
            <td colspan="2">&nbsp;ID</td>
          </tr>
          <tr>
            <td><input type="text" v-model="id"></td>
            <td><v-btn height="40px" id="checkDouble" @click="checkDouble">중복 확인</v-btn></td>
          </tr>

          <tr>
            <td colspan="2">PW</td>
          </tr>
          <tr>
            <td colspan="2"><input type="password" v-model="pw"></td>
          </tr>

          <tr>
            <td colspan="2">이름</td>
          </tr>
          <tr>
            <td  colspan="2"><input type="text" v-model="name"></td>
          </tr>

          <tr>
            <td  colspan="2">생년월일</td>
          </tr>
          <tr>
            <td colspan="2"><input type="text" placeholder=" ex) 940114" v-model="birth"></td>
          </tr>

          <tr>
            <td colspan="2">색상 선택</td>
          </tr>
          <v-card-text>
            <v-row>
              <v-col>
                <v-radio-group v-model="colorGroup">
                  <v-radio value="red" color="red">
                    <template v-slot:label>
                      <div>
                        red <v-icon color="red">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>

                  <v-radio value="pink" color="pink lighten-3">
                    <template v-slot:label>
                      <div>
                      pink <v-icon color="pink lighten-3">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>

                  <v-radio value="yellow" color="yellow">
                    <template v-slot:label>
                      <div>
                      yellow <v-icon color="yellow">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>

                  <v-radio value="blue" color="blue">
                    <template v-slot:label>
                      <div>
                      blue <v-icon color="blue">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>

                  <v-radio value="purple" color="purple">
                    <template v-slot:label>
                      <div>
                      purple <v-icon color="purple">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>

                  <v-radio value="green" color="green">
                    <template v-slot:label>
                      <div>
                      green <v-icon color="green">mdi-rectangle</v-icon>
                      </div>
                    </template>
                  </v-radio>
                </v-radio-group>
              </v-col>
            </v-row>
          </v-card-text>

          <tr>
            <td rowspan="2" colspan="2">
              <v-btn width="100%" height="50px" id="registerBtn" type="submit">가입</v-btn>
            </td>
          </tr>
        </table>
      </form>
    </v-row>
  </v-card>일정
</template>

<script>
export default {
  name: "RegisterPageForm",
  data() {
    return{
      colorGroup: 0,
      id: '',
      pw: '',
      name: '',
      birth: '',
    }
  },
  methods: {
    onSubmit() {
      const { id, pw, name, birth, colorGroup} = this;
      const color = colorGroup;
      this.$emit('submit', {id, pw, name, birth, color})
    },
    checkDouble(){
      const {id} = this;
      this.$emit('check', {id})
    }
  }
}
</script>

<style scoped>
td{
  font-size: 25px;
}
input{
  width: 100%;
  border: 1px solid black;
  margin-bottom: 30px;
}
div{
  font-size: 30px;
}
#registerBtn{
  background-color: deepskyblue;
  font-size: 20px;
  margin-bottom: 30px
}
#checkDouble{
  font-size: 20px;
  margin-bottom: 30px;
}

</style>