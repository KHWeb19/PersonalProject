<template>
  <v-container>
    <v-row justify="end" style="margin-bottom: 20px">
      <v-btn class="red white--text" @click="modify">수정</v-btn>
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
        {{myPage.name}}
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
        생년월일
      </v-col>
      <v-col cols="6" style="font-size: 35px;">
        {{myPage.birth}}
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="3" style="font-size: 35px;">컬러</v-col>
      <v-col cols="6" style="font-size: 35px;">
        {{myPage.color}}
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "MemberManage",
  props: {
    myPage: {
      type: Array
    }
  },
  methods: {
    modify(){
      this.$router.push({name: 'MyPageModify'})
    }
  }
}
</script>

<style scoped>

</style>