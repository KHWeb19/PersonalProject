<template>
<div>
    <v-container>
        <form name="emailReport">

      <br>
      <p> 새로운 분리수거 정보와 건의사항을 <br> 관리자에게 제보해보세요. </p>

      <br>

            <div class="input_area">
                <v-text-field type="text" v-model="sendName" style="width:350px" label="발신자명">
                </v-text-field>
            </div>
           
            <div class="input_area">
                <v-text-field type="text" value="sustka46@gmail.com" label="수신자(관리자)메일 주소" style="width:350px" readonly/>
            </div>

            <table>
                <tr>
                    <td class="guide">본문</td>
                </tr>
                <tr>

                    <td>
                        <textarea cols="43" rows="15" v-model="content" placeholder=" *내용을 작성해주세요.">
                        </textarea>
                    </td>
                </tr>
            </table>

      <div>
        <button id="login" @click="massage">전송하기</button>
      </div>

        </form>
    </v-container>
</div>
</template>

<script>
export default {
    name:'emailForm',
    methods: {
        massage(){
            alert('전송 완료!')
            this.$router.push({ name: 'emailReportPage',})
        }
    }
    
}
</script>

<style scoped>
.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }

.guide{
    font-weight: bold;
    color: #907bb0;
}
textarea {
    width: 100%;
    margin: 0px;
    outline-color: #ccbce3;
    resize: none; /* 크기 조절 없앰 */
}
    button {
      margin: 15px;
      height: 50px;
      width: 350px;
      background-color: #ccbce3;

      font-size: 120%;
      color: white;
    }
</style>