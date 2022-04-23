<template>
  <v-container>
    <v-card class="pa-10">
      <v-row justify="center">
        <v-card-title style="font-size: 30px; margin-bottom: 15px">아이디/ 비밀번호 찾기</v-card-title>
      </v-row>

      <hr>

      <v-row justify="center" style="padding-top:60px; padding-bottom: 25px; font-size: 45px">
        <p>아이디 찾기</p>
      </v-row>

      <v-row justify="center">
        <form @submit="searchId">
          <table>
            <tr>
              <td>사용자 이름을 적어주세요</td>
            </tr>

            <tr>
              <td><input type="text" style="border: black solid 1px" v-model="nameId"></td>
            </tr>

            <tr>
              <td style="padding-top: 15px"> 생년 월일을 적어주세요</td>
            </tr>

            <tr>
              <td><input type="text" placeholder=" ex) 940114" style="border: black solid 1px" v-model="birth"></td>
            </tr>

            <tr>
              <td style="padding-top: 10px"><v-btn type="submit" width="100%" color="green">검색</v-btn></td>
           </tr>

          </table>
        </form>
      </v-row>


      <v-row justify="center" style="padding-top:50px; padding-bottom: 25px; font-size: 45px">
        <p>비밀번호 찾기</p>
      </v-row>

      <v-row justify="center">
        <form>
          <table>
            <tr>
              <td>사용자 이름을 적어주세요</td>
            </tr>

            <tr>
              <td><input type="text" style="border: black solid 1px" v-model="namePw"></td>
            </tr>

            <tr>
              <td> 아이디를 적어주세요</td>
            </tr>

            <tr>
              <td><input type="text" style="border: black solid 1px" v-model="id"></td>
            </tr>

            <tr>
              <td style="padding-top: 10px"><v-btn width="100%" color="green" @click="searchPw()">검색</v-btn></td>
            </tr>
          </table>
        </form>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>

export default {
  name: "SearchIdPw",
  data(){
    return{
      nameId: '',
      namePw: '',
      birth: '',
      id: '',
    }
  },
  methods:{
    searchId(){
      const {nameId , birth} = this
      alert(nameId);
      this.$emit('searchId', {nameId, birth})
    },
    searchPw(){
      const {namePw , id} = this
      this.$emit('searchPw', {namePw, id})
    }
  }
}
</script>

<style scoped>
td{
  font-size: 30px;
}
</style>