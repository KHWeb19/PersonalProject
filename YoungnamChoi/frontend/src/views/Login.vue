<template>
  <v-app id="app">
    <v-main>
      <v-container
        style="position: relative; top: 20%; margin-left: 20%"
        class="text-xs-center"
      >
        <v-layout row wrap class="text-xs-center">
          <v-flex>
            <v-card flat class="mx-auto" max-width="800">
              <v-row style="margin-top: 60px">
                <v-col>
                  <v-form style="width: 400px; height: 300px">
                    <div class="mx-3">
                      <v-icon color="black" size="30px">mdi-account </v-icon>
                      userId
                      <div class="mx-1">
                        <v-text-field
                          placeholder="userId"
                          v-model="userId"
                          required
                        ></v-text-field>
                      </div>
                    </div>
                    <div class="mx-3">
                      <v-icon color="black" size="30px">mdi-lock</v-icon>
                      userPassword
                      <div class="mx-1">
                        <v-text-field
                          placeholder="userPassword"
                          type="password"
                          v-model="userPassword"
                          required
                        ></v-text-field>
                      </div>
                    </div>
                    <v-card-actions>
                      <v-btn
                        color="#2c4f91"
                        dark
                        large
                        block
                        @click="signupSubmit"
                        >Login</v-btn
                      >
                    </v-card-actions>
                    <v-card-actions>
                      <v-btn
                        color="#2c4f91"
                        dark
                        large
                        block
                        @click="loginSubmit"
                        >회원 가입</v-btn
                      >
                    </v-card-actions>
                  </v-form>
                </v-col>
              </v-row>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-main>
  </v-app>
</template>
<script>
// @ is an alias to /src

export default {
  name: "Login",
  data: () => ({
    //
  }),
};
</script>
