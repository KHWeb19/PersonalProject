<template>
    <div>
      <v-dialog v-model="dialog" width="500">
        <template v-slot:activator="{ on, attrs }" >
          <v-btn
            color="white"
            height="20"
            v-bind="attrs"
            v-on="on"
          >
            Login
          </v-btn>
        </template>

        <v-card>
          <v-card-title class="text-h4 grey lighten-2">
            <img id="loginTitle" src="@/assets/main/Login.png">
          </v-card-title>
          <br/>
          <v-card-text>
              <v-container>
                <form name="loginForm" @submit.prevent="onSubmit">
                  <table>
                    <tr>
                      <td>I D</td>
                      <td><input class="underline" name="id" type="text" v-model="id"></td>
                    </tr>
                    <br/>
                    <tr>
                      <td>PASSWORD</td>
                      <td><input class="underline" name="pw" type="password" v-model="pw"></td>
                    </tr>
                  </table>
                </form>
              </v-container>
            <div class="loginImg">
            <img src="@/assets/main/homebanner_ghost.png" height="80">
            </div>
          </v-card-text>

          <v-divider></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="red darken-3"
              text
              type="submit"
              @click="checkValue"
            >
              ENTER
            </v-btn>
            <v-btn
              color="black"
              text
              @click="dialog = false"
            >
              CANCLE
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
  </div>
</template>

<script>
export default {

    name: 'LoginButton',
    data: () => ({
      dialog: false,
    }),
    methods: {
        checkValue () {
          var inputForm = eval("document.loginForm")

          if(!inputForm.id.value){
            alert ("아이디를 입력하세요")
            inputForm.id.focus()
            return false
          } else if(!inputForm.pw.value){
            alert ("비밀번호를 입력하세요")
            inputForm.pw.focus()
            return false
          } else {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
          }
        }
    }

}
</script>

<style scoped>
.loginCard {
  text-align: center;
}

.loginImg {
  position: absolute;
  left:73%;
  top:42%;
}
#loginTitle{
  position: relative;
  width:20%;
}
</style>