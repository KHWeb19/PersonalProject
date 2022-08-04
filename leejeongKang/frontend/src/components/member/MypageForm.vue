<template>
    <body>
      <v-container>
      <form>
      <v-row justify="center">
            <v-col xs="12" sm="6" md="6">
          <v-card class="pa-3">
             <v-subheader><input type="text" readonly :value="userInfo.name"/>님 안녕하세요!</v-subheader>
            <v-divider :inset="false"></v-divider>
                <v-col cols="12">
                  <v-text-field :value="userInfo.id" label="ID" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="userInfo.password" label="Password" type="password" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="userInfo.name" label="Name" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="userInfo.birth" label="Birth Day" readonly></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field :value="userInfo.phone" label="Phone Number" readonly></v-text-field>
                </v-col>
      <div id= "btn">
        <router-link style="color: blue" :to="{ name: 'EditMyPage' }">
                    <b>회원 정보를 수정하시겠습니까?</b>
        </router-link>
      </div><br>
              </v-card>
            </v-col>
      </v-row><br><br><br><br><br>
    </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: 'MypageForm',
  props: {
    member: {
      type: Object,
      required: true
    },
    userInfo: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
#btn { text-align: center; font-size: 20px; }
#BtnModify { background-color: navy; width: 500px; height: 55px;}
input { outline-style: none; width: 50px;}
a { text-decoration: none; font-size: 18px; }
</style>
