<template>
    <v-container>
      <v-card class="pa-10">
        <v-row justify="center">
          <v-card-title style="font-size: 30px; margin-bottom: 15px">비밀번호 변경</v-card-title>
        </v-row>

        <v-row justify="center">
          <form>
            <table>
              <tr>
                <td style="font-size: 25px">변경하실 비밀번호를 적어주세요</td>
              </tr>

              <tr>
                <td style="padding-left: 15px"><input type="password" style="border: black solid 1px; font-size: 22px" v-model="pw"></td>
              </tr>

              <tr>
                <td style="padding-top: 10px;"><v-btn width="100%" color="green" @click="changePw()">확인</v-btn></td>
              </tr>
            </table>
          </form>
        </v-row>
      </v-card>
    </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "ChangePw",
  data(){
    return{
      pw: ''
    }
  },
  props:{
    id: {
      type: String,
      default : ''
    },
  },
  methods:{
    changePw(){
      const {id, pw} = this;
      console.log(id +', '+pw);

      axios.put('http://localhost:7777/search/changePw',{id, pw})
        .then(() =>{
          //alert(res.data)
          this.$router.push({name: 'LoginPage'})
        })
    }
  },
  created() {
    //alert(this.id)
  }
}
</script>

<style scoped>

</style>