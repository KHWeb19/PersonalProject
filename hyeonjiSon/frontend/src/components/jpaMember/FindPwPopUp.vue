<template>
   <div>
      <v-layout justify-center>
         <p>비밀번호를 잊어버렸나요?
            <v-dialog  v-model="findPw" resisten max-width="500px">
               <template v-slot:activator="{ on }">
               <v-btn id="findPw" v-on="on">
                  비밀번호 찾기
               </v-btn>
               </template>
               <v-card >
               <v-card-title>
                  가입정보를 대조하여 비밀번호를 찾습니다.
               </v-card-title>
               <input id="findPwInput" v-model="id" type="text" placeholder="  *ID를 입력하세요">
               <input id="findPwInput" v-model="pwConfirm" type="text" placeholder="  *가장 좋아하는 과일은?">

               <br>
               <v-btn color="blue" text @click.native="btn_click($event)">
                     비밀번호 찾기
               </v-btn>
               </v-card>
            </v-dialog>
         </p>
      </v-layout>
   </div>
</template>

<script>
import axios from 'axios'

export default {
   name: "FindPwPopUp",
   methods: {
   btn_click (payload) {
       const { id, pwConfirm } = payload
      axios.post('http://localhost:7777/vueJpaMember/findPw', { id, pwConfirm }) //Spring Controller에 연동하여 전달
      .then(res => { //then 정상적으로 데이터를 받았을 경우 동작
         alert(' 비밀번호는 ' + res)
      })
      .catch(res => { //에러 캐치한 경우 동작
         alert('잘못된 정보입니다.' + res)
      })
      //finally 동작 여부와 무관하게 무조건 실행됨
   }
   }
    
}
</script>

<style scoped>
    #findPwInput {
      width: 300px;
      margin: 10px;
      border: 2px solid;
      font-size: 100%;
    }
    #findPw {
      font-size: 100%;
      height: 0px;
      color: blue;
      -webkit-text-stroke: 1px;
    }
</style>