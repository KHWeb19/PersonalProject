<template>
  <v-container>
    <v-row align="center">
      <v-col cols="3"  sm="3" md="3" lg="3" v-if="this.isCheck">
        <v-menu open-on-click top offset-y>
          <template v-slot:activator="{ on, attrs }" >
            <v-btn style="margin-left: 20px" fab x-large v-bind="attrs" v-on="on"> {{ user }} </v-btn>
          </template>

          <v-list flat style="margin-top: 90px">
            <v-list-item-group v-model="selectedItem" color="primary">
              <v-list-item>
                <v-list-item-title><v-btn icon @click="myPage" style="width: 150px"><v-icon>mdi-book-open-outline</v-icon>&nbsp;마이페이지</v-btn></v-list-item-title>
              </v-list-item>

              <v-list-item>
                <v-list-item-title><v-btn icon @click="logOut" style="width: 120px"><v-icon>mdi-logout-variant</v-icon>&nbsp;로그아웃</v-btn></v-list-item-title>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-menu>
      </v-col>
      <v-col v-else cols="3"  sm="3" md="3" lg="3">
        <v-btn style="margin-left: 20px" fab @click="logIn" x-large> 로그인 </v-btn>
      </v-col>
      <v-spacer></v-spacer>
      <v-col>
        <v-btn class="ca red lighten-2" style="font-size: 30px" @click="planLink" x-large outlined> PLAN </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca blue lighten-2" style="font-size: 30px" @click="searchLink" x-large outlined> SEARCH </v-btn>
      </v-col>
      <v-col>
        <v-btn class="ca green lighten-2" style="font-size: 30px" @click="boardLink" x-large outlined> BOARD </v-btn>
      </v-col>
    </v-row>
    <hr size="20px" style="margin-top: 10px;">

  </v-container>
</template>

<script>
export default {
  name: "MainCategory",
  data(){
    return{
      user: "없다",
      items: ['로그아웃', '마이페이지'],
      isCheck: false,
      selectedItem: 1,
    }
  },
  methods: {
    planLink(){
      if(localStorage.getItem("session") === null) {
        this.$router.push({name: 'HomeView'})
      }else {
        this.$router.push({name: 'PlanListView'})
      }
    },
    searchLink() {
      this.$router.push({name: 'SearchView'})
    },
    boardLink(){
      this.$router.push({name: 'BoardView'})
    },
    logIn(){
      this.$router.push({name: 'LoginPage'})
    },
    logOut(){
      localStorage.removeItem("session");
      alert("로그아웃 되었습니다!");
      this.$router.push({name: 'LoginPage'})
    },
    myPage(){
      this.$router.push({name: 'MyPage'})
    }
  },
  created() {
    if(localStorage.getItem("session") !== null){
      this.user = localStorage.getItem("session");
      this.isCheck = true;
    }

    alert(this.isCheck)
  }
}
</script>

<style scoped>
.ca{
  width: 230px;
}
</style>