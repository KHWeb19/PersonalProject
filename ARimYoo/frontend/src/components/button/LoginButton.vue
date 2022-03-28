<template>
    <div>
      <v-dialog v-model="dialog" width="500">
        <template v-slot:activator="{ on, attrs }" >
          <v-btn
            color="white"
            height="25"
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
            <login-form @submit="onSubmit"/>
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
              @click="dialog = false"
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
import LoginForm from '../form/LoginForm.vue'
export default {
  components: { LoginForm },
    name: 'LoginButton',

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