<template>
   <div >
      <v-layout justify-center>
         <p>비밀번호를 잊어버렸나요?
            <v-dialog  v-model="findPw" resisten max-width="500px">
               <template v-slot:activator="{ on }">
               <v-btn style="color: darkKhaki " id="findPw" v-on="on">
                  비밀번호 찾기
               </v-btn>
               </template>
               <v-card align="center">
                  <v-card-title id="title">
                     가입정보를 대조하여 비밀번호를 찾습니다.
                  </v-card-title>
                        <v-flex xs10>
                           <v-text-field label="아이디" v-model="id" type="text" placeholder="  *ID를 입력하세요">
                           </v-text-field>
                        </v-flex>                  
                        <v-flex xs10>
                           <v-text-field label="비밀번호 질문" v-model="pwConfirm" type="text" placeholder="  *가장 좋아하는 과일은?">
                           </v-text-field>
                        </v-flex>                  
               <br>
                  <v-card-actions>
                     <v-spacer></v-spacer>
                     <v-btn style="color: darkKhaki " text @click.native="btn_click($event)">
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
#title{
   color: #907bb0;
   font-weight: bold;
}
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
    .v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }
</style>