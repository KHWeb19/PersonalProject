<template>
    <v-dialog :value="dialog"  width="470" persistent>
      <v-card >
              <v-card-title class="text-h4 grey lighten-2">
                <img id="loginTitle" src="@/assets/main/Login.png">
              </v-card-title>
              <v-card-text>
                  <v-container>
                    <form name="loginForm" @submit.prevent="onSubmit">
                        <v-col cols="7">
                            <v-text-field  label="I D" color="red darken-2" name="id" type="text" v-model="id" ></v-text-field>
                        </v-col>
                        <v-col cols="7">
                          <v-text-field  label="PASSWORD" color="red darken-2"  name="pw" type="password" v-model="pw"></v-text-field>
                        </v-col>
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
                  type="button"
                  color="black"
                  text
                  @click="close"
                >
                  CANCLE
                </v-btn>
              </v-card-actions>
            </v-card>
    </v-dialog>
</template>

<script>

export default {
  name: "LoginForm",
  props: {
    loginForm : {
      type: Object
    }
  },
  data () {
    return {
      id:'',
      pw:''
    }
  },
  computed: {
    dialog () {
      return this.loginForm.dialog
    },
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
    },
     checkValue () {
          var inputForm = eval("document.loginForm")

          if(!inputForm.id.value){
            alert ("아이디를 입력하세요")
            inputForm.id.focus()
          
          } else if(!inputForm.pw.value){
            alert ("비밀번호를 입력하세요")
            inputForm.pw.focus()
          } else {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
            this.$emit('close')
          }

        },
        close(){
          this.$emit('close')
           return this.id='', this.pw=''
        }
  }
}

</script>

<style scoped>

.loginImg {
  position: absolute;
  left:70%;
  top:42%;
}
#loginTitle{
  position: relative;
  width:20%;
}
</style>