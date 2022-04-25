<template>
   <div >
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
                  <v-card-actions>
                     <v-btn color="blue" text @click.native="btn_click($event)">
                           비밀번호 찾기
                     </v-btn>
                  </v-card-actions>
               </v-card>
            </v-dialog>
         </p>
      </v-layout>
   </div>
</template>

<script>

export default {
   name: "FindPwPopUp",
   methods: {
   btn_click () {
      
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