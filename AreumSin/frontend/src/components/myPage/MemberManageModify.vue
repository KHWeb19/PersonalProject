<template>
  <v-container>
    <v-row justify="end" style="margin-bottom: 20px">
      <v-btn class="green white--text" @click="returnPage">돌아가기</v-btn>
      <v-btn class="red white--text" @click="modify">수정 완료</v-btn>
    </v-row>
    <v-row justify="center">
      <v-col cols="3">
        <v-icon style="font-size: 190px; margin-left: 55px">
          mdi-account
        </v-icon>
      </v-col>
    </v-row>

    <v-row style="margin-top: 50px; margin-bottom: 15px">
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">
        이름
      </v-col>
      <v-col cols="6" style="font-size: 35px;">
        <input type="text" v-model="name">
      </v-col>
    </v-row>

    <v-row style="margin-bottom: 15px;">
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">
        아이디
      </v-col>
      <v-col cols="6" style="font-size: 35px;">
        {{myPage.id}}
      </v-col>
    </v-row>

    <v-row style="margin-bottom: 15px;">
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">
        비밀번호
      </v-col>
      <v-col cols="6" style="font-size: 35px;">
        <input type="password" v-model="pw">
      </v-col>
    </v-row>

    <v-row style="margin-bottom: 15px;">
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">
        생년월일
      </v-col>
      <v-col cols="6" style="font-size: 35px;">
        <input type="text" v-model="birth">
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">컬러</v-col>
      <v-col cols="6" style="font-size: 35px;">
        <input type="text" v-model="color">
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "MemberManageModify",
  props: {
    myPage: {
      type: Array,
    }
  },
  data(){
    return {
      name: '',
      birth: '',
      color: '',
      pw: '',
    }
  },
  methods: {
    returnPage(){
      this.$router.push({name: 'MyPage'})
    },
    modify() {
      const {pw, name, birth, color} = this;

      this.$emit('modify', {pw, name, birth, color})
    }
  },
  created() {
    this.name = this.myPage.name
    this.birth = this.myPage.birth
    this.color = this.myPage.color
  }
}
</script>

<style scoped>

</style>