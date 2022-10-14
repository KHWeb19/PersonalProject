<template>
    <body>
      <form @submit.prevent="onSubmit">
        <v-container>
          <v-row justify="center">
            <v-col xs="12" sm="6" md="6">
          <v-card class="pa-3">
             <v-subheader style="dark">LOG IN</v-subheader>
            <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-text-field v-model="id" label="ID" required></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field v-model="password" label="Password" type="password"></v-text-field>
                </v-col>
      <br><br><br>
      <div id= "btn">
        <v-btn class="white--text" id="BtnLogin" type="submit">로그인</v-btn>
      </div><br>
          </v-card>
            </v-col>
          </v-row>
      </v-container><br><br><br><br><br>
    </form>
</body>

</template>

<script>
export default {
  name: "MemberLogin.vue",
  data () {
    return {
      id: '',
      password: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, password } = this
      this.$emit('submit', { id, password })
    }
  }
}
</script>

<style scoped>
h2 { text-align: center;}
#btn { text-align: center; font-size: 20px; }
#BtnLogin { background-color: navy; width: 450px; height: 50px;}
</style>
